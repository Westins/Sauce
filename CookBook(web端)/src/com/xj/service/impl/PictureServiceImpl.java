package com.xj.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xj.dao.PictureMapper;
import com.xj.pojo.Picture;
import com.xj.service.PictureService;

@Service("pService")
public class PictureServiceImpl implements PictureService {
	@Resource(name = "pMapper")
	PictureMapper pMapper;

	@Override
	public List<Picture> selPage(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return pMapper.selPage(map);
	}

	@Override
	public List<Picture> getAllInfo(String pType) {
		// TODO Auto-generated method stub
		return pMapper.getAllInfo(pType);
	}

	@Override
	public List<Picture> selType() {
		// TODO Auto-generated method stub
		return pMapper.selType();
	}

	@Override
	public List<Picture> getcookbooklist() {
		// TODO Auto-generated method stub
		return pMapper.getcookbooklist();
	}

	@Override
	public int delpicturebypid(int pId) {
		// TODO Auto-generated method stub
		return pMapper.delpicturebypid(pId);
	}

	@Override
	public List<Picture> getpicturelist() {
		// TODO Auto-generated method stub
		return pMapper.getpicturelist();
	}

	@Override
	public int insertpicture(Picture picture) {
		// TODO Auto-generated method stub
		return pMapper.insertpicture(picture);
	}

	@Override
	public List<Picture> getContent(int pId) {
		// TODO Auto-generated method stub
		return pMapper.getContent(pId);
	}

}
