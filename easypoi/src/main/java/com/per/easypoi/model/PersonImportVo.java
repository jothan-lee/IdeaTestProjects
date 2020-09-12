package com.per.easypoi.model;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.*;

/**
 * @Description: TODO
 * @Author: lys
 * @Date: 2020-09-12 16:17
 * @Version: 1.3.*
 */
@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PersonImportVo {
    /**
     * 姓名
     */
    @Excel(name = "姓名", orderNum = "0", width = 15)
    private String name;
    /**
     * 性别
     * 属性类型是String，因为excel传上来是String类型，虽然最后转化成0或者1
     */
    @Excel(name = "性别", orderNum = "1", width = 15, replace = {"男_0", "女_1"})
    private String sex;
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
     * 属性类型为String，为本地存储该照片的路径
     */
    @Excel(name = "人脸图片1", orderNum = "4", width = 15, height = 30, type = 2)
    private String imageUrl;


}
