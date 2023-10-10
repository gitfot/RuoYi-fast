package com.ruoyi.modules.chat.controller;

import com.ruoyi.modules.chat.entity.ApiKey;
import com.ruoyi.modules.chat.service.ApiKeyService;
import com.ruoyi.modules.chat.vo.ApiKeyVO;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.framework.web.page.TableDataInfo;
import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;

import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.List;

/**
 * (chat_api_key)表控制层
 *
 * @author wanwan
 * @since 2023-10-10 16:05:49
 */
@RestController
@RequestMapping("/chat/apiKey")
@RequiredArgsConstructor
public class ApiKeyController extends BaseController {
  
    private final ApiKeyService apiKeyService;
 
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return success(apiKeyService.getById(id));
    }

    @GetMapping("/list")
    public TableDataInfo list(ApiKeyVO param) {
        startPage();
        List<ApiKeyVO> list = apiKeyService.selectApiKeyList(param);
        return getDataTable(list);
    }
    
    @Log(title = "导出列表", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ApiKeyVO param) {
        List<ApiKeyVO> list = apiKeyService.selectApiKeyList(param);
        ExcelUtil<ApiKeyVO> util = new ExcelUtil<>(ApiKeyVO.class);
        util.exportExcel(response, list, "excel数据");
    }
    
    @Log(title = "新增记录", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ApiKey entity) {
        return toAjax(apiKeyService.save(entity));
    }

    @Log(title = "编辑数据", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ApiKey entity) {
        return toAjax(apiKeyService.updateById(entity));
    }

    @Log(title = "删除记录", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(apiKeyService.removeBatchByIds(Arrays.asList(ids)));
    }
}
