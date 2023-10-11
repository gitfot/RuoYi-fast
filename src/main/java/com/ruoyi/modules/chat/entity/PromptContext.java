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
 * (chat_prompt_context)表实体类
 *
 * @author wanwan
 * @since 2023-10-11 16:24:18
 */
@Data
@TableName("chat_prompt_context")
@EqualsAndHashCode
@ApiModel(value = "PromptContext对象", description = "对象")
public class PromptContext {

    private static final Long serialVersionId = 1L;

    @TableId(value = "id", type = IdType.ASSIGN_ID)
    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "ID")
    private Long id;

    @ApiModelProperty(value = "提示词表id")
    private Long promptId;

    @ApiModelProperty(value = "角色[user,system,assistant]")
    private String role;

    @ApiModelProperty(value = "内容")
    private String content;

    @ApiModelProperty(value = "排序")
    private Integer sort;

    @ApiModelProperty(value = "对话日期")
    private Date date;
}
