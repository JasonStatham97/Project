package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface AccountRep extends JpaRepository<Table_Account,Integer> {
    List<Table_Account> findByUsername(String username);
    @Modifying
    @Transactional
    @Query(value = "insert into account value(?,?,?)",nativeQuery = true)
    public int insert(@Param("id")int id,@Param("username") String username,@Param("password") String password);
    @Transactional
    public int deleteByUsername(String username);

}
