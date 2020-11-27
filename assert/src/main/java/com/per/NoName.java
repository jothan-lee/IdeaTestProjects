package com.per;

import lombok.*;

import java.io.Serializable;

/**
 * @Description: TODO
 * @Author: lys
 * @Date: 2020-11-27 11:56
 * @Version: 1.3.*
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode(callSuper = false)
public class NoName implements Serializable {
    private String img;
    private Integer num;
}
