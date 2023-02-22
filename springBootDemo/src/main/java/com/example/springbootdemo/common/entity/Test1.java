package com.example.springbootdemo.common.entity;

import com.baomidou.mybatisplus.annotation.Version;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 用户测试表
 * </p>
 *
 * @author kevin
 * @since 2023-02-22
 */
@Data
public class Test1 implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 测试表id
     */
    private Integer id;

    /**
     * 姓名
     */
    private String name;

    /**
     * 密码
     */
    private String password;


}
