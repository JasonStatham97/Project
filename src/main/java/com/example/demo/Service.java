package com.example.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
@org.springframework.stereotype.Service

public class Service  {
   @Resource
    private UserRep userRep;
/***adminService*****/
    @Transactional
    public void saveTable_Student(Table_User table){
        userRep.save(table);
    }
    @Transactional
    public  void deleteTable_Student(Table_User table){
        userRep.delete(table);
    }
    @Transactional
    public Object findAllTable_User(){
        return userRep.findAll();
    }
    /***studentService*****/
    /*select*/
    @Resource
    private TableRep tableRep;
    @Transactional
    public List<Table_Student> findByMajor(String major){
       return  tableRep.findByMajor(major);
    }
    @Transactional
    public List<Table_Student> findByAddress(String address){
        return tableRep.findByAddress(address);
    }
    @Transactional
    public List<Table_Student> findByStudent(String studentno){
        return tableRep.findByStudentno(studentno);
    }
    @Transactional
    public List<Table_Student> findByClassno(String classno){
        return tableRep.findByClassno(classno);
    }
    @Transactional
    public List<Table_Student> findByName(String name){
        return tableRep.findByName(name);
    }
    /*insert*/
    @Transactional
    public void  insert( int id, String name, String studentno,String major,
                      String classno, String address, String date, String sex){
        tableRep.insert(id,name,studentno,major,classno,address,date,sex);
    }
    /*delete*/
    @Transactional
    public void delete(String studentno){
        tableRep.deleteByStudentno(studentno);
    }


}