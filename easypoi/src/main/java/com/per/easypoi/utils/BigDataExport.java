package com.per.easypoi.utils;

import cn.afterturn.easypoi.handler.inter.IExcelExportServer;
import com.per.easypoi.model.PersonExportVo;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * 大数据导出模拟查询数据
 * @author lYS
 * @date 2020/9/18 0018
 */
@Component
public class BigDataExport implements IExcelExportServer {
    @Override
    public List<Object> selectListForExcelExport(Object queryParams, int page) {
        List<PersonExportVo> vos = new ArrayList<>();
        if (page < 20) {
            for (int i = 0; i < 10000; i++) {
                PersonExportVo vo = new PersonExportVo();
                vo.setName("测试数据"+page*i);
                vo.setSex(1);
                vo.setUsername("testData");
                vo.setPhoneNumber("13007659887");
                vo.setImageUrl("http");
               /* vo.setUrlToPicture();*/
                vos.add(vo);
                System.out.println("第"+i+"条数据");
            }
        }
        List<Object> list = new ArrayList<>();
        list.addAll(vos);
        return list;
    }
}
