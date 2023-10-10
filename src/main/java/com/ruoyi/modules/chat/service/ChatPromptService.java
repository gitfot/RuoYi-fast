package com.ruoyi.modules.chat.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.ruoyi.modules.chat.entity.ChatPrompt;
import com.ruoyi.modules.chat.vo.ChatPromptVO;

import java.util.List;

/**
 * (chat_prompt)表服务接口
 *
 * @author wanwan
 * @since 2023-10-09 17:34:08
 */
public interface ChatPromptService extends IService<ChatPrompt> {

	List<ChatPromptVO> selectPromptList(ChatPromptVO chatPrompt);
}
