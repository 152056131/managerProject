package com.example.managerproject.common.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author kevin
 * @since 2023-09-26
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("userInfo")
public class UserInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 客户号
     */
      @TableId(value = "customerId", type = IdType.INPUT)
    private String customerid;

    /**
     * 用户名
     */
    private String name;

    /**
     * 密码
     */
    private String password;

    /**
     * 创建时间
     */
    @TableField("createTime")
    private String createTime;

    /**
     * 是否有效
     */
    private String iseffective;


}
