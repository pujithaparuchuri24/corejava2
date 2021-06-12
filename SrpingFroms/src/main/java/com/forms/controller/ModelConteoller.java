package com.forms.controller;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.forms.ModelClass;
import com.forms.dao.ModelDao;

@Controller
public class ModelConteoller {
	@Autowired 
	private ModelDao dao;
	@RequestMapping("/")
	public String welcome(org.springframework.ui.Model m)
	{
		m.addAttribute("model", new ModelClass());
		return "welcome";
	}
	@PostMapping("/save")
	public String  save(@Valid @ModelAttribute ModelClass model,
			BindingResult b)
	{

		if(b.hasErrors())
		{
			return "welcome";
		}
		System.out.println(dao.save(model));
		return "redirect:/getall";
	}
	@GetMapping("/getall")
	public String get(Map<String,List<ModelClass>> m)
	{
		List<ModelClass> model=dao.get();
		m.put("modellist",model);
		return "getall";
	}
	@GetMapping("/editemp/{name}")
	public String edit(@PathVariable("name") String name,Model m)
	{
		ModelClass model=dao.getbyName(name);
		if(model==null)
		{
			m.addAttribute("m","more records are there"); 
		}
		else
		{
			m.addAttribute("m",model);
		}
		return "edit";
	}
	@ResponseBody
	@GetMapping("/deleteemp/{name}")
	public int delete(@PathVariable String name)
	{
		return dao.delete(name);
	}
}