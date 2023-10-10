package com.ruoyi.modules.chat.controller;


import com.ruoyi.modules.chat.entity.ChatPrompt;
import com.ruoyi.modules.chat.service.ChatPromptService;
import com.ruoyi.modules.chat.vo.ChatPromptVO;
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
 * (chat_prompt)表控制层
 *
 * @author wanwan
 * @since 2023-10-10 09:53:10
 */
@RestController
@RequestMapping("/chat/prompt")
@RequiredArgsConstructor
public class ChatPromptController extends BaseController {
  
    private final ChatPromptService chatPromptService;
 
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return success(chatPromptService.getById(id));
    }

    @GetMapping("/list")
    public TableDataInfo list(ChatPromptVO param) {
        startPage();
        List<ChatPromptVO> list = chatPromptService.selectPromptList(param);
        return getDataTable(list);
    }
    
    @Log(title = "导出列表", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ChatPromptVO param) {
        List<ChatPromptVO> list = chatPromptService.selectPromptList(param);
        ExcelUtil<ChatPromptVO> util = new ExcelUtil<>(ChatPromptVO.class);
        util.exportExcel(response, list, "excel数据");
    }
    
    @Log(title = "新增记录", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ChatPrompt entity) {
        return toAjax(chatPromptService.save(entity));
    }

    @Log(title = "编辑数据", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ChatPrompt entity) {
        return toAjax(chatPromptService.updateById(entity));
    }

    @Log(title = "删除记录", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(chatPromptService.removeBatchByIds(Arrays.asList(ids)));
    }
}
