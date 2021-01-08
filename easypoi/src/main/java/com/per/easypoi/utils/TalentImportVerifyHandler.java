package com.per.easypoi.utils;

import cn.afterturn.easypoi.excel.entity.result.ExcelVerifyHandlerResult;
import cn.afterturn.easypoi.handler.inter.IExcelVerifyHandler;
import com.per.easypoi.model.PersonExportVo;
import com.per.easypoi.model.PersonImportVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

/**
 * @Description: TODO 自定义校验
 * @Author: lys
 * @Date: 2020-09-12 14:11
 * @Version: 1.3.*
 */
@Component
public class TalentImportVerifyHandler implements IExcelVerifyHandler<PersonImportVo> {


    /**
     *
     * @param inputEntity
     * @return result.setSuccess(true); 通过校验。 result.setSuccess(false);跳过该条数据
     */
    @Override
    public ExcelVerifyHandlerResult verifyHandler(PersonImportVo inputEntity) {
        ExcelVerifyHandlerResult result = new ExcelVerifyHandlerResult();

        if (StringUtils.isNotBlank(inputEntity.getImageUrl())) {
            //通过校验
            result.setSuccess(true);

        } else {
            //未通过校验，忽略此行数据
            result.setSuccess(false);
        }
        return result;
    }


}