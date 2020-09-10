package com.per.easypoi.utils;

import cn.afterturn.easypoi.excel.entity.result.ExcelVerifyHandlerResult;
import cn.afterturn.easypoi.handler.inter.IExcelVerifyHandler;
import com.example.easypoi.model.PersonExportVo;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.StringJoiner;

@Component
public class TalentImportVerifyHandler implements IExcelVerifyHandler<PersonExportVo> {



    @Override
    public ExcelVerifyHandlerResult verifyHandler(PersonExportVo inputEntity) {
        StringJoiner joiner = new StringJoiner(",");
        // 根据姓名与手机号判断数据是否重复

        return new ExcelVerifyHandlerResult(true);
    }


}