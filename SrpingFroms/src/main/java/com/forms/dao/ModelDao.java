package com.forms.dao;

import java.util.List;

import com.forms.ModelClass;



public interface ModelDao {
	public int save(ModelClass m);
	public List get();
	public ModelClass getbyName(String name);
	public int delete(String name);

}
