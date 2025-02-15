package com.wfuhui.modules.bbs.api;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wfuhui.common.annotation.AuthIgnore;
import com.wfuhui.common.utils.R;
import com.wfuhui.modules.bbs.entity.CategoryEntity;
import com.wfuhui.modules.bbs.service.CategoryService;

/**
 * 分类接口
 * @author lzl
 *
 */
@RestController
@RequestMapping("/api/category")
public class ApiCategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	/**
	 * 列表
	 * @return
	 */
	@AuthIgnore
    @GetMapping("list")
    public R list(){
    	Map<String, Object> params = new HashMap<String, Object>();
    	params.put("sidx", "sort");
    	params.put("order", "ASC");
    	List<CategoryEntity> categoryList = categoryService.queryList(params);
        return R.ok().put("categoryList", categoryList);
    }
}
