package com.ruoyi.modules.chat.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ruoyi.modules.chat.entity.ChatPrompt;
import com.ruoyi.modules.chat.entity.PromptContext;
import com.ruoyi.modules.chat.entity.PromptModel;
import com.ruoyi.modules.chat.mapper.ChatPromptMapper;
import com.ruoyi.modules.chat.service.ChatPromptService;
import com.ruoyi.modules.chat.service.PromptContextService;
import com.ruoyi.modules.chat.service.PromptModelService;
import com.ruoyi.modules.chat.vo.ChatPromptVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


/**
 * (chat_prompt)表服务实现类
 *
 * @author wanwan
 * @since 2023-10-09 17:34:10
 */
@Service
public class ChatPromptServiceImpl extends ServiceImpl<ChatPromptMapper, ChatPrompt> implements ChatPromptService {

	@Autowired
	private PromptContextService contextService;
	@Autowired
	private PromptModelService modelService;

	@Override
	public List<ChatPromptVO> selectPromptList(ChatPromptVO chatPrompt) {
		List<ChatPrompt> chatPrompts = baseMapper.selectList(Wrappers.lambdaQuery(chatPrompt));
		List<ChatPromptVO> promptVOS = BeanUtil.copyToList(chatPrompts, ChatPromptVO.class);
		List<Long> promptIds = promptVOS.stream().map(ChatPromptVO::getId).collect(Collectors.toList());

		List<PromptContext> contextList = contextService.list(Wrappers.<PromptContext>lambdaQuery().in(PromptContext::getPromptId, promptIds));
		Map<Long, List<PromptContext>> promptContextMap =
				contextList.stream().collect(Collectors.groupingBy(PromptContext::getPromptId));

		List<PromptModel> modelList = modelService.list(Wrappers.<PromptModel>lambdaQuery().in(PromptModel::getPromptId, promptIds));
		Map<Long, List<PromptModel>> promptModelMap = modelList.stream().collect(Collectors.groupingBy(PromptModel::getPromptId));

		promptVOS.forEach( p -> {
			p.setContext(promptContextMap.get(p.getId()));
			p.setModelConfig(promptModelMap.get(p.getId()).get(0));
		});
		return promptVOS;
	}
}
