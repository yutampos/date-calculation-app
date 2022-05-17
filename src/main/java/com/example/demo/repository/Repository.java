package com.example.demo.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.demo.entity.CalcuNumData;
import com.example.demo.entity.CreateNum;
import com.example.demo.entity.UpdateNum;

@Mapper
public interface Repository {

    public List<CalcuNumData> findByAll();

    public List<CalcuNumData> findById(String id);

    public void create(@Param("calcuC") CreateNum createNum);

    public void update(@Param("calcuU") UpdateNum updateNum);

    public void delete(String id);
}
