package com.ruoyi.modules.chat.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ruoyi.modules.chat.entity.ChatPrompt;
import com.ruoyi.modules.chat.mapper.ChatPromptMapper;
import com.ruoyi.modules.chat.service.ChatPromptService;
import com.ruoyi.modules.chat.vo.ChatPromptVO;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * (chat_prompt)表服务实现类
 *
 * @author wanwan
 * @since 2023-10-09 17:34:10
 */
@Service
public class ChatPromptServiceImpl extends ServiceImpl<ChatPromptMapper, ChatPrompt> implements ChatPromptService {

	@Override
	public List<ChatPromptVO> selectPromptList(ChatPromptVO chatPrompt) {
		List<ChatPrompt> chatPrompts = baseMapper.selectList(Wrappers.lambdaQuery(chatPrompt));
		return BeanUtil.copyToList(chatPrompts, ChatPromptVO.class);
	}
}
