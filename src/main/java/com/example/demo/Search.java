package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;

@Controller
public class Search extends Exception {
    @Autowired
    private TableRep tableRep;

    @RequestMapping(value = "/search")
    public ModelAndView search(@RequestParam("message") String message) {
        List<Table_Student> li = null;

        String str1 = null;
        String str2 = null;
        boolean b1 = true;
        ModelAndView modelAndView = new ModelAndView();
        if(message.isEmpty())
        {
            li = tableRep.findAll();
            modelAndView.setViewName("result.html");
            modelAndView.addObject("list",li);
            return modelAndView;
        }
        try {

            str1 = message.substring(0, 2);
            str2 = message.substring(3);
        }catch (Exception e){
            modelAndView.setViewName("/demo3.html");
            modelAndView.addObject("message","关键字格式错误");
            return modelAndView;
        }

            //System.out.println(str1+" "+str2);
          switch (str1){
                case "姓名":li = tableRep.findByName(str2);break;
                case "学号":li = tableRep.findByStudentno(str2);break;
                case "性别":li = tableRep.findBySex(str2);break;
                case "籍贯":li = tableRep.findByAddress(str2);break;
                case "专业":li = tableRep.findByMajor(str2);break;
                case "班级":li = tableRep.findByClassno(str2);break;
                case "年份":li = tableRep.findByDate(str2);break;
                default: b1 = false;System.out.println("关键字输入错误");break;
            }

            if(b1){
                modelAndView.setViewName("/result");
                modelAndView.addObject("list",li);
            }else{
                modelAndView.setViewName("/demo3.html");
                modelAndView.addObject("message","关键字格式错误");
            }


            return modelAndView;
    }
}