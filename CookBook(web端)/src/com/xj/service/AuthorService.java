package com.xj.service;

import java.util.List;

import com.xj.pojo.Author;
import com.xj.pojo.CookBook;

public interface AuthorService {
	public Author getAuthorInfo(String aName);

	public int insertAuthor(Author author);

	public List<Author> getAuthorAll();

	public List<CookBook> getcookbookbyaid(int aid);

	public int updAuInfo(Author author);
}
