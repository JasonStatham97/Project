package com.example.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.xml.MarshallingView;

import javax.jws.WebParam;
import java.util.List;

@RestController
public class AccountController {
    @Autowired
    private AccountRep accountRep;

    @RequestMapping("/signin")
    public ModelAndView lognin(@RequestParam("username") String username, @RequestParam("password") String password) {
        ModelAndView modelAndView = new ModelAndView();
        if (accountRep.findByUsername(username).isEmpty()) {
            //System.out.println("11111111");
            accountRep.insert(accountRep.findAll().size() + 1, username, password);
            System.out.println(username);
            modelAndView.setViewName("/search.html");
            return modelAndView;
        } else {
            modelAndView.setViewName("/demo3");
            modelAndView.addObject("message","用户已存在");
            System.out.println("已存在");
            return modelAndView;
        }

    }

    @RequestMapping("/login")
    public ModelAndView login(@RequestParam("username") String username, @RequestParam("password") String password) {
        List<Table_Account> li = accountRep.findByUsername(username);
        ModelAndView modelAndView = new ModelAndView();
        System.out.println(username + " " + password);
        System.out.println(li.isEmpty());
        if(li.isEmpty()){
            modelAndView.setViewName("/demo3.html");
            modelAndView.addObject("message","用户不存在");
            return modelAndView;
        }
        if ( (li.get(0).getPassword().equals(password))) {
          modelAndView.setViewName("/search.html");
          return modelAndView;
        } else {
            modelAndView.setViewName("/demo3.html");
            modelAndView.addObject("message","密码错误");
            return modelAndView;
        }

    }
    @RequestMapping("/renewuser")
    public ModelAndView reNewUser(@RequestParam("username") String username,@RequestParam("username2") String username2,@RequestParam("password") String password){
        List<Table_Account> li  = accountRep.findByUsername(username);
        ModelAndView modelAndView = new ModelAndView();
        if(li.isEmpty()){
            modelAndView.setViewName("/demo3.html");
            modelAndView.addObject("message","用户不存在");
            return modelAndView;
        }else
        {
            Table_Account table_account = new Table_Account();
            if(!username2.isEmpty()){
                accountRep.deleteByUsername(username);
                table_account.setId(accountRep.findAll().size()+Math.round(100));
                table_account.setUsername(username2);
                table_account.setPassword(password);
                accountRep.save(table_account);
                modelAndView.setViewName("/admin.html");
                modelAndView.addObject("message","用户信息更新成功");
                return  modelAndView;
            }else
            {
                accountRep.deleteByUsername(username);
                table_account.setPassword(password);
                table_account.setUsername(username);
                accountRep.save(table_account);
                modelAndView.setViewName("/admin.html");
                modelAndView.addObject("message","用户信息更新成功");
                return  modelAndView;
            }
        }

    }
}
