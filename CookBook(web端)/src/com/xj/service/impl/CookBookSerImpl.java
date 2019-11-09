package com.xj.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xj.dao.CookBookMapper;
import com.xj.pojo.Author;
import com.xj.pojo.CookBook;
import com.xj.service.CookBookService;

@Service("cbService")
public class CookBookSerImpl implements CookBookService {
	@Resource(name = "cbMapper")
	CookBookMapper cbMapper;

	@Override
	public Author getAuthorInfo(String aName) {
		// TODO Auto-generated method stub
		return cbMapper.getAuthorInfo(aName);
	}

	@Override
	public List<CookBook> getAllInfo(int ckId) {

		return cbMapper.getAllInfo(ckId);
	}

	@Override
	public int addCook(CookBook cb) {
		// TODO Auto-generated method stub
		return cbMapper.addCook(cb);
	}

	@Override
	public List<CookBook> selPage(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return cbMapper.selPage(map);
	}

	@Override
	public List<CookBook> getcookbookbyaid(int aid) {
		// TODO Auto-generated method stub
		return cbMapper.getcookbookbyaid(aid);
	}

	@Override
	public List<CookBook> getcookbooklist() {
		// TODO Auto-generated method stub
		return cbMapper.getcookbooklist();
	}

	@Override
	public int setckstatebyckid(int ckid) {
		// TODO Auto-generated method stub
		return cbMapper.setckstatebyckid(ckid);
	}

	@Override
	public CookBook getById(int ckId) {
		// TODO Auto-generated method stub
		return cbMapper.getById(ckId);
	}
}
