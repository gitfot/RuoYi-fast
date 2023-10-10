package com.ruoyi.modules.chat.mapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ruoyi.modules.chat.entity.ApiKey;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.apache.ibatis.annotations.Mapper;
import com.ruoyi.modules.chat.vo.ApiKeyVO;

import java.util.List;

/**
 * (chat_api_key)Mapper接口
 *
 * @author wanwan
 * @since 2023-10-10 16:05:49
 */
@Mapper
public interface ApiKeyMapper extends BaseMapper<ApiKey> {
   
   /**
	 * 自定义分页
	 */
	List<ApiKeyVO> selectApiKeyPage(IPage<ApiKeyVO> page, ApiKeyVO entity);
}
