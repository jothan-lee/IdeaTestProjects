package com.per.easypoi.model;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelTarget;
import lombok.*;

import java.io.Serializable;
import java.lang.annotation.Target;

/**
 * @author lz
 * @date 2018/12/27
 */

@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PersonExportVo implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * 姓名
     */
    @Excel(name = "姓名", orderNum = "0", width = 15)
    private String name;
    /**
     * 性别
     * 属性类型是Integer，因为从数据库中查出来是integer类型，虽然最后转化成“男”或者“女”
     */
    @Excel(name = "性别", orderNum = "1", width = 15, replace = {"男_0", "女_1"})
    private Integer sex;
    /**
     * 登录用户名
     */
    @Excel(name = "用户名", orderNum = "2", width = 15)
    private String username;

    @Excel(name = "手机号码", orderNum = "3", width = 15)
    private String phoneNumber;

    /**
     * 通过本地拿人脸图片
     * type 类型为2
     */
    @Excel(name = "人脸图片1", orderNum = "4", width = 15, height = 30, type = 2, imageType = 1)
    private String imageUrl;

    /**
     * 通过网络路径拿人脸图片
     * 这个imageType必须为2，要不然报错
     * 属性类型为byte数组
     */
    @Excel(name = "人脸图片2", orderNum = "5", width = 15, height = 30, type = 2, imageType = 2)
    private byte[] urlToPicture;
}