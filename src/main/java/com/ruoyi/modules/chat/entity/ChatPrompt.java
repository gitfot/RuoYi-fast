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
 * (chat_prompt)表实体类
 *
 * @author wanwan
 * @since 2023-10-09 15:20:43
 */
@Data
@TableName("chat_prompt")
@EqualsAndHashCode
@ApiModel(value = "ChatPrompt对象",description = "对象")
public class ChatPrompt {
    
    private static final Long serialVersionId = 1L;

    @TableId(value = "id", type = IdType.ASSIGN_ID)
    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "ID")
    private Long id;

    @ApiModelProperty(value = "创建日期")
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    @ApiModelProperty(value = "标题")
    private String title;

    @ApiModelProperty(value = "提示词内容")
    private String content;

    @ApiModelProperty(value = "描述")
    private String des;

    @ApiModelProperty(value = "标签")
    private String tag;

    @ApiModelProperty(value = "创建者")
    @TableField(fill = FieldFill.INSERT)
    private String createBy;

    @ApiModelProperty(value = "是否用户自建 1是")
    private Integer isUser = 1;
}
