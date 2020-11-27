package com.per;

import lombok.*;

import java.io.Serializable;
import java.util.List;

/**
 * @Description: TODO
 * @Author: lys
 * @Date: 2020-11-27 11:53
 * @Version: 1.3.*
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode(callSuper = false)
public class Model implements Serializable {

    private String name;
    private String password;
    private List<Integer> list;
    private NoName noName;

}
