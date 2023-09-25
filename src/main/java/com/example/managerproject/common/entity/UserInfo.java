package com.example.managerproject.common.entity;

import com.alibaba.excel.annotation.ExcelProperty;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.Version;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;

import java.io.Serializable;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 *
 * </p>
 *
 * @author kevin
 * @since 2023-09-13
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("userInfo")
public class UserInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "customerId", type = IdType.INPUT)
    @ExcelProperty
    private String customerid;
    @ExcelProperty
    private String name;
    @ExcelProperty
    private String password;
    @ExcelProperty
    private String iseffective;

    @TableField("createTime")
    @ExcelProperty
    private String createtime;


}
