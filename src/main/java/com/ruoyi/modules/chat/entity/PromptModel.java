package com.ruoyi.modules.chat.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;


/**
 * (chat_prompt_model)表实体类
 *
 * @author wanwan
 * @since 2023-10-11 16:28:49
 */
@Data
@TableName("chat_prompt_model")
@EqualsAndHashCode
@ApiModel(value = "PromptModel对象", description = "对象")
public class PromptModel {

    private static final Long serialVersionId = 1L;

    @TableId(value = "id", type = IdType.ASSIGN_ID)
    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "ID")
    private Long id;

    @ApiModelProperty(value = "提示词表id")
    private Long promptId;

    @ApiModelProperty(value = "模型")
    private String model;

    @ApiModelProperty(value = "随机性")
    private Double temperature;

    @ApiModelProperty(value = "核采样")
    private Double topP;

    @ApiModelProperty(value = "单次回复限制")
    private Integer maxTokens;

    @ApiModelProperty(value = "话题新鲜度-值越大越容易扩展到新话题")
    private Double presencePenalty;

    @ApiModelProperty(value = "频率惩罚度-值越大越有可能降低重复词")
    private Double frequencyPenalty;

    @ApiModelProperty(value = "是否注入系统级提示信息 1是")
    private Integer sendMemory;

    @ApiModelProperty(value = "附带历史消息数")
    private Integer historyMessageCount;

    @ApiModelProperty(value = "历史消息长度压缩阈值")
    private Integer compressMessageLengthThreshold;
}
