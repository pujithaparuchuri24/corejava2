package com.forms.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.forms.ModelClass;
@Repository
public class ModelDaoImpl implements ModelDao {
	String query;
    @Autowired   
	private JdbcTemplate jt;
	public int save(ModelClass m) {
		query="insert into model (name,email)values (?,?)";
		return jt.update(query, m.getName(),m.getEmail());
	}

	public List get() {
		query="select * from model";
		System.out.println( jt.queryForList(query));
		return jt.queryForList(query);
	}

	public ModelClass getbyName(String name) {
		System.out.println("dao start");
         query="select count(*)  from model where name=?";
         int count=jt.queryForObject(query, Integer.class, name);
         System.out.println(count);
         if(count==1)
         {
        	
        	ModelClass model=jt.queryForObject("select * from model where name=?", new BeanPropertyRowMapper<ModelClass>(ModelClass.class),name);
        	return  model; 	
         }
         System.out.println("dao end");
         return null;
	}

	public int delete(String name) {
		String query="delete from model where name=null";
		return jt.update(query);
	}

}
