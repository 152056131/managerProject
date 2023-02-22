package com.example.springbootdemo.common.entity;

import com.baomidou.mybatisplus.annotation.Version;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author kevin
 * @since 2023-02-21
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Test1 implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 测试表id
     */
    private Integer id;

    private String name;

    private String password;


}
