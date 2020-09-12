package com.per.easypoi.utils;

import cn.afterturn.easypoi.excel.entity.result.ExcelVerifyHandlerResult;
import cn.afterturn.easypoi.handler.inter.IExcelVerifyHandler;
import com.per.easypoi.model.PersonExportVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;


@Component
public class TalentImportVerifyHandler implements IExcelVerifyHandler<PersonExportVo> {



    @Override
    public ExcelVerifyHandlerResult verifyHandler(PersonExportVo inputEntity) {
        ExcelVerifyHandlerResult result = new ExcelVerifyHandlerResult();
        result.setSuccess(false);
        if (StringUtils.isNotBlank(inputEntity.getImageUrl())) {
            return result;
        } else {
            result.setSuccess(true);
        }
        return result;
    }


}