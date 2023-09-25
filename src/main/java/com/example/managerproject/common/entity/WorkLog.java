package com.example.managerproject.common.entity;

import com.alibaba.excel.annotation.ExcelProperty;
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
 * @since 2023-09-21
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class WorkLog implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.INPUT)
    @ExcelProperty
    private String id;
    @ExcelProperty
    private String customerid;
    @ExcelProperty
    private String createTime;
    @ExcelProperty
    private String workContext;
    @ExcelProperty
    private String username;


}
