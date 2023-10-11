package com.ruoyi.modules.chat.vo;

import com.ruoyi.modules.chat.entity.PromptContext;
import com.ruoyi.modules.chat.entity.PromptModel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import com.ruoyi.modules.chat.entity.ChatPrompt;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "ChatPromptVO对象", description = "VO对象") 
public class ChatPromptVO extends ChatPrompt {
    
    private static final Long serialVersionId = 1L;

    @ApiModelProperty("提示词上下文内容")
    private List<PromptContext> context;

    @ApiModelProperty("提示词模型配置")
    private PromptModel modelConfig;
}
