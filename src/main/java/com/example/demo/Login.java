package com.example.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
public class Login {

    @Autowired
    private UserRep userRep;
    @RequestMapping(value ="/adlogin")
    public ModelAndView login(@RequestParam("username") String username, @RequestParam("password") String password){
        List<Table_User> li  = userRep.findByName(username);
        System.out.println(username+" "+password);
        System.out.println(li.isEmpty());
        ModelAndView modelAndView = new ModelAndView();
        if(li.isEmpty()){
            modelAndView.setViewName("/demo3.html");
            modelAndView.addObject("message","用户不存在");
            return modelAndView;
        }
       if(!li.isEmpty()&&(li.get(0).getPassword().equals(password))){
           modelAndView.setViewName("/admin.html");
            return modelAndView;
        }else{
           modelAndView.setViewName("/demo3.html");
           modelAndView.addObject("message","密码错误");
           return modelAndView;
        }

    }

}
