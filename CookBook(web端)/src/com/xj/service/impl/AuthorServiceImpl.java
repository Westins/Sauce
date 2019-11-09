package com.xj.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xj.dao.AuthorMapper;
import com.xj.pojo.Author;
import com.xj.pojo.CookBook;
import com.xj.service.AuthorService;

@Service("AuthorService")
public class AuthorServiceImpl implements AuthorService {
	@Autowired
	AuthorMapper aMapper;

	@Override
	public Author getAuthorInfo(String aName) {
		// TODO Auto-generated method stub
		return aMapper.getAuthorInfo(aName);
	}


	@Override
	public int insertAuthor(Author author) {
		// TODO Auto-generated method stub
		return aMapper.insertAuthor(author);
	}

	@Override
	public List<Author> getAuthorAll() {
		// TODO Auto-generated method stub
		return aMapper.getAuthorAll();
	}

	@Override
	public List<CookBook> getcookbookbyaid(int aid) {
		// TODO Auto-generated method stub
		return aMapper.getcookbookbyaid(aid);
	}


	@Override
	public int updAuInfo(Author author) {
		// TODO Auto-generated method stub
		return aMapper.updAuInfo(author);
	}

}
