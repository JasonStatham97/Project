package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
public class AdminController {
    @Autowired
    private TableRep tableRep;
    @RequestMapping("/insert")
    public Object insert(@RequestParam("studentno") String studentno,@RequestParam("name") String name,
                       @RequestParam("major") String major,@RequestParam("classno") String classno,@RequestParam("address") String address,
                       @RequestParam("date") String date,@RequestParam("sex") String sex){
        ModelAndView modelAndView = new ModelAndView();
        if(tableRep.findByStudentno(studentno).isEmpty())
        {
            tableRep.insert(tableRep.findAll().size()+1,studentno,name,address,classno,major,date,sex);
            modelAndView.setViewName("/admin.html");
            modelAndView.addObject("message","添加成功");
            //return "redirect:/admin.html";
        return modelAndView;
        }
        else
        {
            modelAndView.setViewName("/demo3.html");
            modelAndView.addObject("message","用户已存在");

            return modelAndView;
        }

    }
    @RequestMapping("/delete")
    public ModelAndView delete(@RequestParam("studentno") String studentno){
        ModelAndView modelAndView = new ModelAndView();


        if(tableRep.findByStudentno(studentno).isEmpty()){
            modelAndView.setViewName("demo3.html");
            modelAndView.addObject("message","用户不存在");
            return modelAndView;
        }else{
            tableRep.deleteByStudentno(studentno);
            modelAndView.setViewName("/admin.html");
            modelAndView.addObject("message","删除成功");
            return modelAndView;
        }



    }
    @RequestMapping("/update")
    public  ModelAndView update(@RequestParam("name") String name,@RequestParam("studentno") String studentno,@RequestParam("sex") String sex,@RequestParam("classno") String classno,
                        @RequestParam("major") String major,@RequestParam("address") String address,@RequestParam("date") String date){
        Table_Student table_student = new Table_Student();

        List<Table_Student> li  = tableRep.findByStudentno(studentno);
        ModelAndView modelAndView = new ModelAndView();
        System.out.println(name+" "+studentno+" "+sex+" "+classno+" "+major+" "+address);
        if(li.isEmpty()){
            modelAndView.setViewName("/demo3.html");
            modelAndView.addObject("message","用户不存在");
            return modelAndView;
        }else{
            tableRep.deleteByStudentno(studentno);
            table_student.setId(tableRep.findAll().size()+Math.round(10));
            table_student.setStudentno(studentno);
            if(name.isEmpty())
                table_student.setName(li.get(0).getName());
            else
                table_student.setName(name);
             if(sex.isEmpty())
                 table_student.setSex(li.get(0).getSex());
             else
                 table_student.setSex(sex);
             if(classno.isEmpty())
                 table_student.setClassno(li.get(0).getClassno());
             else
                 table_student.setClassno(classno);
             if(address.isEmpty())
                 table_student.setClassno(li.get(0).getAddress());
             else
                 table_student.setAddress(address);
             if(major.isEmpty())
                 table_student.setMajor(li.get(0).getMajor());
             else
                 table_student.setMajor(major);
             if(date.isEmpty())
                 table_student.setDate(li.get(0).getDate());
             else
                 table_student.setDate(date);
            tableRep.save(table_student);
            modelAndView.setViewName("/admin.html");
            modelAndView.addObject("message","更新成功");
            System.out.println(table_student.getName()+" "+table_student.getStudentno()+" "+table_student.getSex()+" "+table_student.getClassno()+" "+table_student.getMajor()+" "+table_student.getAddress());
            return  modelAndView;
        }



    }
    @RequestMapping("/searchJump")
    public ModelAndView jump(){
        return new ModelAndView("/search");
    }
}
