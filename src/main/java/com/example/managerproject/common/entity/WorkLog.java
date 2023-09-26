package com.example.managerproject.common.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
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
public class WorkLog implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 日志编号
     */
      @TableId(value = "id", type = IdType.INPUT)
    private String id;

    /**
     * 客户号
     */
    private String customerid;

    /**
     * 创建时间
     */
    private String createTime;

    /**
     * 日志内容
     */
    private String workContext;

    /**
     * 用户名
     */
    private String username;

    /**
     * 文字格式
     */
    private String elementPath;


}
