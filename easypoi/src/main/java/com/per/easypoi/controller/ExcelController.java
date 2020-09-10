package com.example.easypoi.controller;

import com.example.easypoi.model.PersonExportVo;
import com.example.easypoi.utils.ExcelUtils;
import javafx.scene.image.Image;
import org.apache.commons.lang3.StringUtils;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.Null;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * excel 导出控制器
 *
 * @author novel
 * @date 2018/12/27
 */
@RestController
@RequestMapping("excel")
public class ExcelController {
    /**
     * 导出
     *
     * @param response
     */
    @RequestMapping(value = "/export", method = RequestMethod.GET)
    public void exportExcel(HttpServletResponse response) throws IOException {
        List<PersonExportVo> personList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            PersonExportVo personVo = new PersonExportVo();
            personVo.setName("张三" + i);
            personVo.setUsername("张三" + i);
            personVo.setPhoneNumber("18888888888");
            personVo.setImageUrl("/static/user1-128x128.jpg");
            personList.add(personVo);
        }
        ExcelUtils.exportExcel(personList, "员工信息表", "员工信息", PersonExportVo.class, "员工信息", response);
    }

    /**
     * 导出excel
     *
     * @return 结果
     */
    @GetMapping("/exportToFile")
    public Map<String, Object> export() {
        List<PersonExportVo> personList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            PersonExportVo personVo = new PersonExportVo();
            personVo.setName("张三" + i);
            personVo.setUsername("张三" + i);
            personVo.setPhoneNumber("18888888888");
            personVo.setImageUrl("/static/user1-128x128.jpg");
            personList.add(personVo);
        }
        String fileName = ExcelUtils.exportExcelToFile(personList, "员工信息", PersonExportVo.class);
        Map<String, Object> map = new HashMap<>();
        map.put("fileName", fileName);
        return map;
    }

    /**
     * 导入
     *
     * @param file
     */
    @RequestMapping(value = "/import", method = RequestMethod.POST)
    public Object importExcel(@RequestParam("file") MultipartFile file) throws IOException {


        List<PersonExportVo> vos = ExcelUtils.importExcel(file, PersonExportVo.class);
        for (PersonExportVo vo : vos) {
            if (StringUtils.isNotBlank(vo.getImageUrl())&&checkImage(vo.getImageUrl())) {

                //转换成base64
                //上传到七牛云，返回URL地址
                //setImageUrl(URL)
                File file1 = new File(vo.getImageUrl());
                if (file1.isFile() && file1.exists()) {
                    System.out.println("file1 = " + file1);
                    file1.delete();
                }
            }
        }
        return vos;
    }

    /**
     *
     * @param pathImg 本地图片路径
     * @return
     */
    public boolean checkImage(String pathImg) {
        BufferedImage image = null;
        boolean valid =true;
        try {
            image= ImageIO.read(new File(pathImg));
            if (image == null || image.getWidth() <= 0 || image.getHeight() <= 0) {
                valid = false;

            }
        } catch(IOException ex) {
            ex.printStackTrace();
            valid=false;
        }
        return valid;
    }

}
