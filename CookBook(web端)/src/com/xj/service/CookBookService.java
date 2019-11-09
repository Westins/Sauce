package com.xj.service;

import java.util.List;
import java.util.Map;

import com.xj.pojo.Author;
import com.xj.pojo.CookBook;

public interface CookBookService {
	public List<CookBook> getAllInfo(int ckId);

	public int addCook(CookBook cb);

	public List<CookBook> selPage(Map<String, Object> map);

	public List<CookBook> getcookbookbyaid(int aid);

	public List<CookBook> getcookbooklist();

	public CookBook getById(int ckId);

	public int setckstatebyckid(int ckid);
	public Author getAuthorInfo(String aName);

}
