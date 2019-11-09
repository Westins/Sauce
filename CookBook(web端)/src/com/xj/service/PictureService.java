package com.xj.service;

import java.util.List;
import java.util.Map;

import com.xj.pojo.Picture;

public interface PictureService {
	public List<Picture> getAllInfo(String pType);

	public List<Picture> getContent(int pId);
	
	public List<Picture> selPage(Map<String, Object> map);

	public List<Picture> selType();

	public List<Picture> getcookbooklist();

	public List<Picture> getpicturelist();

	public int insertpicture(Picture picture);

	public int delpicturebypid(int pId);
}
