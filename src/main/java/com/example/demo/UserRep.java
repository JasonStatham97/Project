package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRep extends JpaRepository<Table_User,Integer> {
    @Query("select t from Table_User t where t.name =:name")
    List<Table_User> findByName(@Param("name") String name);
   // List<Table_Student>findByID(int id);
}
