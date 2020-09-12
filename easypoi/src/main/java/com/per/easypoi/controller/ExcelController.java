package com.per.easypoi.controller;

import cn.afterturn.easypoi.handler.inter.IExcelVerifyHandler;
import com.per.easypoi.model.PersonExportVo;
import com.per.easypoi.model.PersonImportVo;
import com.per.easypoi.utils.ExcelUtils;
import com.per.easypoi.utils.TalentImportVerifyHandler;
import com.per.easypoi.utils.UrlFileToByte;
import org.apache.commons.lang3.StringUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
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
 * @author lys
 * @date 2018/12/27
 */
@RestController
@RequestMapping("excel")
public class ExcelController {

    @Autowired
    UrlFileToByte urlFileToByte;

    @Autowired
    TalentImportVerifyHandler talentImportVerifyHandler;
    /**
     * 导出
     *
     * @param response
     */
    @RequestMapping(value = "/export", method = RequestMethod.GET)
    public void exportExcel(HttpServletResponse response) throws IOException {
        List<PersonExportVo> personList = new ArrayList<>();
        //用循环模拟数据库中的数据
        for (int i = 0; i < 5; i++) {
            PersonExportVo personVo = new PersonExportVo();
            personVo.setName("张三" + i);
            personVo.setUsername("张三" + i);
            personVo.setPhoneNumber("18888888888");
            personVo.setSex(0);
            //此路径可以是相对路径，也可以是绝对路径
            personVo.setImageUrl("C:\\Users\\Administrator\\Desktop\\图片\\111.jpg");
            //通过工具类拿到网络路径的图片的byte数组
            personVo.setUrlToPicture(urlFileToByte.getImageFromURL("http://mgjtest.4000750222.com/mgjtesteQuSJfRLnxJl.jpg"));
            personList.add(personVo);
        }
        ExcelUtils.exportExcel(personList, "员工信息表", "员工信息", PersonExportVo.class, "员工信息", response);
    }

    /**
     * 导入模板导出
     * @param response
     * @throws IOException
     */
    @RequestMapping(value = "/importTemplate", method = RequestMethod.POST)
    public void importTemplate(HttpServletResponse response) throws IOException {
        List<PersonImportVo> list = new ArrayList<>();

        ExcelUtils.exportExcel(list, "员工信息表模板", "员工信息", PersonImportVo.class, "员工信息", response);

    }
    /**
     * 导入
     *自定义校验excel
     * @param file
     */
    @RequestMapping(value = "/import", method = RequestMethod.POST)
    public Object importExcel(@RequestParam("file") MultipartFile file) throws IOException {

    List<PersonImportVo> vos = ExcelUtils.importExcel(file,1,1, PersonImportVo.class,talentImportVerifyHandler);
        for (PersonImportVo vo : vos) {
            if (StringUtils.isNotBlank(vo.getImageUrl())&&checkImage(vo.getImageUrl())) {

                //上传到七牛云，返回URL地址
                //setImageUrl(URL)
                File file1 = new File(vo.getImageUrl());
                if (file1.isFile() && file1.exists()) {
                    System.out.println("file1 = " + file1);
                    file1.delete();
                }
            }
        }
        return null;
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
