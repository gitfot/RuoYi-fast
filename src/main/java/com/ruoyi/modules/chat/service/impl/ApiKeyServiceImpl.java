package com.ruoyi.modules.chat.service.impl;
import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ruoyi.modules.chat.entity.ApiKey;
import com.ruoyi.modules.chat.mapper.ApiKeyMapper;
import com.ruoyi.modules.chat.service.ApiKeyService;
import com.ruoyi.modules.chat.vo.ApiKeyVO;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * (chat_api_key)表服务实现类
 *
 * @author wanwan
 * @since 2023-10-10 16:09:09
 */
@Service
public class ApiKeyServiceImpl extends ServiceImpl<ApiKeyMapper, ApiKey> implements ApiKeyService {
    
	@Override
	public List<ApiKeyVO> selectApiKeyList(ApiKeyVO entity) {
		List<ApiKey> list = baseMapper.selectList(Wrappers.lambdaQuery(entity));
		return BeanUtil.copyToList(list, ApiKeyVO.class);
	}
}
