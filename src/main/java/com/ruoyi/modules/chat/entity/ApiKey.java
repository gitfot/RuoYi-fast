package com.ruoyi.modules.chat.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * (chat_api_key)表实体类
 *
 * @author wanwan
 * @since 2023-10-10 16:14:08
 */
@Data
@TableName("chat_api_key")
@EqualsAndHashCode
@ApiModel(value = "ApiKey对象", description = "对象")
public class ApiKey {

    private static final Long serialVersionId = 1L;

    @TableId(value = "id", type = IdType.ASSIGN_ID)
    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "ID")
    private Long id;

    @ApiModelProperty(value = "apiKey")
    private String apiKey;

    @ApiModelProperty(value = "请求地址")
    private String baseUrl;

    @ApiModelProperty(value = "使用模型")
    private String useModel;

    @ApiModelProperty(value = "总额度（美元）")
    private Double totalBalance;

    @ApiModelProperty(value = "已使用额度（美元）")
    private Double usageBalance;

    @ApiModelProperty(value = "剩余额度（美元）")
    private Double remainBalance;

    @ApiModelProperty(value = "权重，权重高的优先执行")
    private Integer weight;

    @ApiModelProperty(value = "状态")
    private String status;

    @ApiModelProperty(value = "备注")
    private String remark;

    @TableField(fill = FieldFill.INSERT)
    @ApiModelProperty(value = "创建者")
    private String createBy;

    @TableField(fill = FieldFill.INSERT)
    @ApiModelProperty(value = "创建日期")
    private Date createTime;
}
