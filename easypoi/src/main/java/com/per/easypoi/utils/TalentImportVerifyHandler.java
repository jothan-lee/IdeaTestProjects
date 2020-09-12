package com.per.easypoi.utils;

import cn.afterturn.easypoi.excel.entity.result.ExcelVerifyHandlerResult;
import cn.afterturn.easypoi.handler.inter.IExcelVerifyHandler;
import com.per.easypoi.model.PersonExportVo;
import com.per.easypoi.model.PersonImportVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;


@Component
public class TalentImportVerifyHandler implements IExcelVerifyHandler<PersonImportVo> {



    @Override
    public ExcelVerifyHandlerResult verifyHandler(PersonImportVo inputEntity) {
        ExcelVerifyHandlerResult result = new ExcelVerifyHandlerResult();

        if (StringUtils.isNotBlank(inputEntity.getImageUrl())) {
            result.setSuccess(true);
        } else {
            result.setSuccess(false);
        }
        return result;
    }


}