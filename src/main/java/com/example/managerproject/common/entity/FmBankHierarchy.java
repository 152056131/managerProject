package com.example.managerproject.common.entity;

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
 * 机构层次表|机构层次表
 * </p>
 *
 * @author kevin
 * @since 2023-09-13
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("FM_BANK_HIERARCHY")
public class FmBankHierarchy implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 层级代码|层级代码
     */
      @TableId(value = "HIERARCHY_CODE", type = IdType.INPUT)
    private String hierarchyCode;

    /**
     * 层级说明|层级说明
     */
    @TableField("HIERARCHY_NAME")
    private String hierarchyName;

    /**
     * 分行级别|分行级别
     */
    @TableField("HIERARCHY_LEVEL")
    private String hierarchyLevel;

    /**
     * 法人|法人
     */
    @TableField("COMPANY")
    private String company;

    /**
     * 交易时间戳|交易时间戳
     */
    @TableField("TRAN_TIMESTAMP")
    private String tranTimestamp;


}
