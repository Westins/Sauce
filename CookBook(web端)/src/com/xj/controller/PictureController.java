package com.xj.controller;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.xj.pojo.Picture;
import com.xj.service.PictureService;

@Controller
@RequestMapping("/")
public class PictureController {

	@Resource(name = "pService")
	PictureService ps;

	@RequestMapping("/getPicInfo")
	public String getPicInfo(Model mo, HttpSession session, String p, String pType, HttpServletRequest request)
			throws UnsupportedEncodingException {

		if (pType != null) {
			pType = new String(pType.getBytes("ISO-8859-1"), "utf-8");

		}

		List<Picture> pList = ps.getAllInfo(pType); // 根据菜系查出数据
		mo.addAttribute("pList", pList);

		// 查询所有菜系
		List<Picture> ptList = ps.selType();
		mo.addAttribute("ptList", ptList);
		session.setAttribute("pSize", pList.size());
		return "pics";
	}

	@RequestMapping("/getPicContent")
	public String getPicContent(String pId,Model mo){
		int picId=Integer.parseInt(pId);
		List<Picture> pl=ps.getContent(picId);
		mo.addAttribute("pl", pl);
		return "picContent";
	}
	
	@RequestMapping("/selpictureall")
	public String selpictureall(Model model) {
		System.out.println("查询所有图片");
		List<Picture> picList = ps.getpicturelist();
		System.out.println(picList.toString());
		if (picList.size() > 0) {
			model.addAttribute("picList", picList);
			return "table";
		} else {
			model.addAttribute("sel", 0);
			return "table";
		}
	}

	@RequestMapping("/delpicturebyid")
	public String delpicturebyid(HttpServletRequest request, Model model) {
		System.out.println("删除记录");
		String pid = request.getParameter("pId");
		int pId = Integer.parseInt(pid);
		int count = ps.delpicturebypid(pId);
		if (count > 0) {
			model.addAttribute("del", 1);
			return "redirect:/selpictureall.do";
		} else {
			model.addAttribute("del", 0);
			return "table";
		}
	}

	@RequestMapping("/addPicture")
	public String addPicture(HttpServletRequest request, MultipartFile pimg) throws Exception {
		// ------- 文件上传 ---------------
		String newFileName = null;
		if (!pimg.isEmpty()) {
			System.out.println("没有上传图片！");
			// 工程地址
			String url = "E:\\eclipseDome\\CookBook\\WebContent\\img\\";
			// 获取原始图片的拓展名
			String originalFilename = pimg.getOriginalFilename();
			// 新的文件名字
			newFileName = UUID.randomUUID() + originalFilename;
			// 封装上传文件位置的全路径
			File targetFile = new File(url, newFileName);
			// 本地文件上传到封装上传文件位置的全路径
			pimg.transferTo(targetFile);
			System.out.println("newFileName" + newFileName);
			System.out.println("文件存储位置:" + url);
			// ------- 文件上传 ---------------
			// baby.setHeadImg("img/" + newFileName);
		}
		Picture picture = new Picture();
		String pType = request.getParameter("pType");
		String pDish = request.getParameter("pDish");
		String pCaption = request.getParameter("pCaption");
		String pImg = "img/" + newFileName;
		picture.setpType(pType);
		picture.setpDish(pDish);
		picture.setpImg(pImg);
		picture.setpCaption(pCaption);
		int i = ps.insertpicture(picture);
		return "redirect:/selpictureall.do";
	}
}
