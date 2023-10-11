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
 * @since 2023-10-11 16:12:56
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
    
    @TableField(fill = FieldFill.INSERT)@ApiModelProperty(value = "创建日期")
    private Date createTime;
    
    @ApiModelProperty(value = "标签")
    private String tag;
    
    @TableField(fill = FieldFill.INSERT)@ApiModelProperty(value = "创建者")
    private String createBy;
    
    @ApiModelProperty(value = "标题")
    private String name;
    
    @ApiModelProperty(value = "备注")
    private String remark;
    
    @ApiModelProperty(value = "是否内置")
    private Boolean builtin;
}
