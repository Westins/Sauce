package com.xj.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.xj.pojo.Author;
import com.xj.pojo.CookBook;
import com.xj.service.AuthorService;
import com.xj.service.CookBookService;

@Controller
@RequestMapping("/")
public class CookBookController {

	@Resource(name = "cbService")
	CookBookService cb;
	
	@Resource(name = "AuthorService")
	AuthorService as;

	@RequestMapping("/selectCookBook")
	public String selectCookBook(Model model) {
		System.out.println("查询所有博客");
		List<CookBook> ckList = cb.getcookbooklist();
		System.out.println(ckList);
		model.addAttribute("ckList", ckList);
		return "main";

	}

	@RequestMapping("/update")
	public String update(HttpServletRequest request, Model model) {
		String ckId = request.getParameter("ckid");
		int ckid = Integer.parseInt(ckId);
		int count = cb.setckstatebyckid(ckid);
		
		if (count > 0) {
			model.addAttribute("ok", 1);
			return "redirect:/selectCookBook.do";
		} else {
			model.addAttribute("ok", 0);
			return "redirect:/selectCookBook.do";
		}
	}

	@RequestMapping("/login")
	public String login(HttpServletRequest request) {
		String state = request.getParameter("state");
		System.out.println(state);
		if (state.equals("0")) {
			String aName = request.getParameter("aName");
			return "redirect:/getCookBookInfo.do?aName="+aName;
		} else {
			String aName = request.getParameter("aName");
			String aPwd = request.getParameter("aPwd");
			return "redirect:/adminLogin.do?aName=" + aName + "&aPwd=" + aPwd;
		}
	}

	/*
	 * 登录判断
	 */
	@RequestMapping("/adminLogin")
	public String adminLogin(Model model, HttpServletRequest request, HttpSession session) {
		System.out.println("进入登录...");
		String aName = request.getParameter("aName");
		String aPwd = request.getParameter("aPwd");
		System.out.println(aName + aPwd);
		Author author = cb.getAuthorInfo(aName);

		if (author != null) {
			System.out.println(author.toString());
			if (author.getaPwd().equals(aPwd)) {
				session.setAttribute("author", author);
				return "main";
			} else {
				return "login";
			}
		} else {
			model.addAttribute("login", 0);
			return "login";
		}
	}

	@RequestMapping("/getCookBookInfo")
	public String getCookBookInfo(Model mo,String p,HttpSession session,String aName){
		if(aName!=null){
			System.out.println(aName);
			Author au=as.getAuthorInfo(aName);
			session.setAttribute("aName", aName);
			session.setAttribute("aId", au.getaId());
			session.setAttribute("email", au.getaEmail());
			session.setAttribute("phone", au.getaPhone());
			session.setAttribute("head", au.getaHead());
		}
		
		System.out.println("p=="+p);
		List<CookBook> cbList=cb.getAllInfo(0); //查询所以文章信息
		int page=1;         //第一页
		int size=8;         //每页8条数据
		int count=0;        //页数
		if(cbList.size()%size==0){
			count=cbList.size()/size;
		}else{
			count=cbList.size()/size+1;
		}
		int[] pages=new int[count];
		for(int i=0;i<pages.length;i++){
			pages[i]=i+1;
		}
		
		if(p!=null){
		    page=Integer.parseInt(p);
		}
		
		Map<String,Object> map=new HashMap<>();
		map.put("start",(page-1)*size);
		map.put("end", size);           //每页 size 条
		map.put("pag", page);
		
		List<CookBook> pa=cb.selPage(map);
		System.out.println("pa===="+pa.size());
		
		mo.addAttribute("pages", pages);
		mo.addAttribute("map", map);
		mo.addAttribute("ckbList", cbList);
		session.setAttribute("pSize", cbList.size());
		return "index";
	}
	
	
	
	@RequestMapping("/getckInfo")
	@ResponseBody
	public List<CookBook> getckInfo(){
		List<CookBook> cbList=cb.getAllInfo(0);
		return cbList;
	}

	@RequestMapping("/getDescInfo")
	public String getDescInfo(Model mo,int ckId){
		List<CookBook> cList=cb.getAllInfo(ckId);
		mo.addAttribute("cList", cList);
		return "xiangqing";
	}

	@RequestMapping("/getById")
	@ResponseBody
	public CookBook getById(String id){
		System.out.println("123========="+id);
		int ckId=Integer.parseInt(id);
		CookBook ckb=cb.getById(ckId);
		return ckb;
	}
	
	@RequestMapping("/addCook")
	public String addCook(String ckTitle, String ckContent,String aId,
			@RequestParam(value = "ckImg", required = false) MultipartFile mulFile) throws Exception {
		CookBook ck = new CookBook();
		SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
		Date d = new Date();
		String date = sdf.format(d);
		System.out.println("时间：" + date);

		// 定义文件保存的本地路径
		String localPath = "E:\\eclipseDome\\CookBook\\WebContent\\img\\blog-img\\";
		// 定义 文件名
		String filename = null;
		filename = mulFile.getOriginalFilename();

		// 存入磁盘
		File newFile = new File(localPath + filename);
		mulFile.transferTo(newFile);

		// 数据库地址
		String sqlpath = null;
		sqlpath = "img/blog-img/" + filename;
		int aid=Integer.parseInt(aId);
		ck.setCkTitle(ckTitle);
		ck.setCkContent(ckContent);
		ck.setCkImg(sqlpath);
		ck.setCkTime(date);
		ck.setaId(aid);

		int i = cb.addCook(ck);
		System.out.println("i=" + i);
		return "wait";
	}
}
