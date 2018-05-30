package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

public interface TableRep extends JpaRepository<Table_Student,Integer> {
    List<Table_Student>findByName(String name);
    List<Table_Student>findByStudentno(@Param("studentno") String studentno);
    List<Table_Student>findByMajor(String major);
    List<Table_Student>findByAddress(String address);
    List<Table_Student>findByClassno(String classno);
    List<Table_Student>findBySex(String sex);
    List<Table_Student>findByDate(String date);
    @Modifying
    @Transactional
    @Query("delete from Table_Student u where u.studentno=:studentno")
    public int deleteByStudentno(@Param("studentno") String studentno);
    @Modifying
    @Transactional
    @Query(value = "insert into message value(?,?,?,?,?,?,?,?)",nativeQuery = true)
    public int insert(@Param("id") int id,@Param("name") String name,@Param("studentno") String studentno,@Param("major") String major,
    @Param("classno") String classno,@Param("address") String address,@Param("date") String date,@Param("sex") String sex
    );
    /*@Modifying
    @Transactional
    @Query()*/
}
