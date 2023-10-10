package com.ruoyi.modules.chat.vo;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import com.ruoyi.modules.chat.entity.ChatPrompt;

@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "ChatPromptVO对象", description = "VO对象") 
public class ChatPromptVO extends ChatPrompt {
    
    private static final Long serialVersionId = 1L;
}
