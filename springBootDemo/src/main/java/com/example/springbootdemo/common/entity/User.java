package com.example.springbootdemo.common.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.Version;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author kevin
 * @since 2023-02-22
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
      @TableId(value = "id", type = IdType.INPUT)
    private Long id;

    /**
     * 姓名
     */
    private String username;

    /**
     * 密码
     */
    private Integer password;

    /**
     * 邮箱
     */
    private String email;


}
