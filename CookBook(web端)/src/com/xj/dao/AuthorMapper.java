package com.xj.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.xj.pojo.Author;
import com.xj.pojo.CookBook;

@Repository("authorMapper")

public interface AuthorMapper {
	public Author getAuthorInfo(String aName);
	public int updAuInfo(Author author);
	public int insertAuthor(Author author);

	public List<Author> getAuthorAll();
	
	

	public List<CookBook> getcookbookbyaid(int aid);
}
