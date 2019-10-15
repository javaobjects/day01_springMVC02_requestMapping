package com.tencent.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.tencent.pojo.Emp;
import com.tencent.service.IEmpService;

/**
 * 控制器：处理器请求，响应结果
 */
@Controller
public class EmpController {

	//@Autowired @Qualifier("empService") //默认根据类型匹配，通常结合@Qualifier指定引用名称使用
	@Resource(name="empService") //默认根据名称匹配
	private IEmpService empService;
	
	@RequestMapping("/getEmps.action")
	public ModelAndView getEmps()
	{
		ModelAndView mav = new ModelAndView();
		
		//1.调用service方法，查询所有雇员信息
		List<Emp> empList = empService.selectEmps();
		
		//2.保存到作用域
		mav.addObject("empList", empList);
		
		//3.指定跳转的路径
		mav.setViewName("/empQuery.jsp");
		
		return mav;
	}
	
}
