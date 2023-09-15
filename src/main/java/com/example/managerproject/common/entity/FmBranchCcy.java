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
 * 机构币种表|机构币种表
 * </p>
 *
 * @author kevin
 * @since 2023-09-13
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("FM_BRANCH_CCY")
public class FmBranchCcy implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 所属机构号|机构代码
     */
      @TableId(value = "BRANCH", type = IdType.INPUT)
    private String branch;

    /**
     * 币种|币种
     */
    @TableField("CCY")
    private String ccy;

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
