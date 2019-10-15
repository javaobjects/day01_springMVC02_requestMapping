package com.tencent.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.tencent.pojo.Emp;
import com.tencent.service.IEmpService;

/**
 * 
* <p>Title: EmpController</p>  
* <p>
*	Description: 
* 	控制器：处理器请求，响应结果
* </p> 
* @author xianxian 
* @date 2019年10月15日
 */
@Controller
//@RequestMapping("/emp") //修饰类，访问路径http://localhost:8080/day01_springMVC02_requestMapping/emp/get
public class EmpController {

	//@Autowired @Qualifier("empService") //默认根据类型匹配，通常结合@Qualifier指定引用名称使用
	@Resource(name="empService") //默认根据名称匹配
	private IEmpService empService;
	
	
	
	/**
	 * 
	 * <p>Title: getEmps</p>  
	 * <p>
	 *	Description: 
	 *  @RequestMapping注解:
	 *  value:表示访问路径
	 *  method:表示访问方法时，配置请求方式是GET或POST
	 *	params:
	 * 			params={"empno"},发起请求时，必须带参数，且参数名称必须为empno
	 * 			params={"!empno"},发起请求时，不能带参数名为empno的参数
	 * 			params={"empno=7788"},发起请求时，必须带参数，且参数名称必须为empno，
	 * 						参数值必须为7788
	 * 			params={"empno=7788",ename},发起请求时，必须带参数，
	 * 							且第一个参数名称必须为empno，参数值必须为7788，
	 * 							同时第二个参数的名称必须为ename
	 * </p> 
	 * @return
	 */
	@RequestMapping(value = "/get",method = {RequestMethod.GET,RequestMethod.POST},
			params = {
					"empno=7788","ename"
			})//修饰方法，在无修饰类的前提下，访问路径http://localhost:8080/day01_springMVC02_requestMapping/get
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
