package com.ruoyi.modules.chat.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ruoyi.modules.chat.entity.ApiKey;
import com.ruoyi.modules.chat.vo.ApiKeyVO;

import java.util.List;

/**
 * (chat_api_key)表服务接口
 *
 * @author wanwan
 * @since 2023-10-10 16:05:49
 */
public interface ApiKeyService extends IService<ApiKey> {
    
	List<ApiKeyVO> selectApiKeyList(ApiKeyVO entity);
}
