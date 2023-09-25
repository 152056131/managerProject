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
 * 外部金融机构定义表|外部金融机构定义表，核心暂未使用
 * </p>
 *
 * @author kevin
 * @since 2023-09-13
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("FM_BANK")
public class FmBank implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 银行ID|银行ID
     */
    @TableField("BANK_ID")
    @ExcelProperty
    private String bankId;

    /**
     * 银行代码|在同一个表中两个不同字段的中文注释都为银行代码
     */
    @TableId(value = "BANK_CODE", type = IdType.INPUT)
    @ExcelProperty
    private String bankCode;

    /**
     * 银行类别|银行类别|O-我行,B-他行,S-建房互助协会,T-第三方银行
     */
    @TableField("BANK_TYPE")
    @ExcelProperty
    private String bankType;

    /**
     * 银行名称|银行名称
     */
    @TableField("BANK_NAME")
    @ExcelProperty
    private String bankName;

    /**
     * 状态|状态|A-有效,F-无效,O-未过账,P-已过账
     */
    @TableField("STATUS")
    @ExcelProperty
    private String status;

    /**
     * 法人|法人
     */
    @TableField("COMPANY")
    @ExcelProperty
    private String company;

    /**
     * 交易时间戳|交易时间戳
     */
    @TableField("TRAN_TIMESTAMP")
    @ExcelProperty
    private String tranTimestamp;


}
