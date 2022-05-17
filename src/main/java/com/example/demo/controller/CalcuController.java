package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entity.CalcuNumData;
import com.example.demo.entity.CreateNum;
import com.example.demo.entity.InputDate;
import com.example.demo.entity.UpdateNum;
import com.example.demo.service.CalcuService;

@Controller
@RequestMapping("/")
public class CalcuController {

    @Autowired
    CalcuService calcuService;

    @GetMapping("/top")
    public String top(Model model, @ModelAttribute InputDate inputDate) {

	List<CalcuNumData> getCalcuAllNum = calcuService.findByAll();
	model.addAttribute("getCalcuNum", getCalcuAllNum);

	return "index";
    }

    // 計算式年月日の登録
    @GetMapping("/add")
    public String addNumData(Model model, @ModelAttribute("addData") CreateNum createNum) {

	return "add";
    }

    @PostMapping("/add")
    public String doneAddNumDate(Model model, @ModelAttribute("addData") CreateNum createNum) {

	calcuService.create(createNum);

	return "redirect:/top";
    }

    // 更新
    @GetMapping("/update/{id}")
    public String updateNumData(Model model, @PathVariable("id") String id,
	    @ModelAttribute("updateData") UpdateNum updateNum) {

	List<CalcuNumData> getCalcuNum = calcuService.findById(id);
	model.addAttribute("getCalcuNum", getCalcuNum);

	return "update";
    }

    @PostMapping("/add")
    public String doneUpdateNumDate(Model model, @ModelAttribute("updateData") UpdateNum updateNum) {

	calcuService.update(updateNum);

	return "redirect:/top";
    }

    // 削除
    @GetMapping("/delete/{id}")
    public String deleteNumData(Model model, @PathVariable("id") String id) {

	calcuService.delete(id);

	return "redirect:/top";
    }
}
