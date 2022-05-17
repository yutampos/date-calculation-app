package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.CalcuNumData;
import com.example.demo.entity.CreateNum;
import com.example.demo.entity.UpdateNum;
import com.example.demo.repository.Repository;

@Service
public class CalcuService {
    @Autowired
    Repository repository;

    public List<CalcuNumData> findByAll() {
	return repository.findByAll();
    }

    public List<CalcuNumData> findById(String id) {
	return repository.findById(id);
    }

    public void create(CreateNum createNum) {
	repository.create(createNum);
    }

    public void update(UpdateNum updateNum) {
	repository.update(updateNum);
    }

    public void delete(String id) {
	repository.delete(id);
    }
}
