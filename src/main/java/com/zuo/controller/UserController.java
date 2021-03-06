package com.zuo.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;  
import org.springframework.ui.Model;  
import org.springframework.web.bind.annotation.RequestMapping;  
import org.springframework.web.bind.annotation.RequestParam;

import com.zuo.pojo.User;
import com.zuo.service.UserService;
  
  
@Controller
public class UserController {
    /**
     * 使用@Autowired也可以，@Autowired默认按类型装配
     * @Resource 默认按名称装配，当找不到与名称匹配的bean才会按类型装配。
     */
    @Resource 
    private UserService userService;
    /**
     * 测试查询
     * 
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("/showUser")
    public String testtoshowUser(@RequestParam(value = "id") Integer id, Model model) {
        System.out.println("id:" + id);
        User user = userService.getUserById(id);
        model.addAttribute("user", user);
        return "showUser";
    }

    /**
     * 测试添加数据
     * 
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("/insertUser")
    public String testinsertUser() {
        User user = new User();
        user.setUserName("李清照");
        user.setPassword("3232322");
        user.setAge(22);
        int count = userService.insert(user);
        System.out.println("插入" + count + "条数据成功");
        return "showUser";
    }
}
