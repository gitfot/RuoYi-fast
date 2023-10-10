package com.ruoyi.modules.chat.vo;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import com.ruoyi.modules.chat.entity.ApiKey;

@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "ApiKeyVO对象", description = "VO对象") 
public class ApiKeyVO extends ApiKey {
    
    private static final Long serialVersionId = 1L;
}
