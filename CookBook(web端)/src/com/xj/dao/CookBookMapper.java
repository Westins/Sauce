package com.xj.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.xj.pojo.Author;
import com.xj.pojo.CookBook;
import com.xj.pojo.Picture;

@Repository("cbMapper")
public interface CookBookMapper {
	public List<CookBook> getAllInfo(int ckId);

	public int addCook(CookBook cb);

	public List<CookBook> selPage(Map<String, Object> map);

	public CookBook getById(int ckId);

	
	public List<CookBook> getcookbookbyaid(int aid);

	public List<CookBook> getcookbooklist();

	public int setckstatebyckid(int ckid);
	public Author getAuthorInfo(String aName);
}
