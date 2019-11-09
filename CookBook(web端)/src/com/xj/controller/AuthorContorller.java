package com.xj.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xj.pojo.Author;
import com.xj.service.AuthorService;

@Controller("AuthorContorller")
public class AuthorContorller {
	@Autowired
	AuthorService aService;

	@RequestMapping("/getAuthorInfo")
	@ResponseBody
	public Author getAuthorInfo(String aname){
		Author a=aService.getAuthorInfo(aname);
		System.out.println(a.toString());
        return  a;
	}
	
	@RequestMapping("/updAuInfo")
	@ResponseBody
	public Author updAuInfo(String aid,String name,String sex,String email,String phone){
		try {
			sex=new String(sex.getBytes("ISO-8859-1"),"UTF-8");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if("男".equals(sex)){
			sex="0";
		}else if("女".equals(sex)){
			sex="1";
		}
		Author a=aService.getAuthorInfo(name);
		int id=Integer.parseInt(aid);
		Author au=new Author();
		au.setaPetName(name);
		au.setaEmail(email);
		au.setaSex(sex);
		au.setaPhone(phone);
		au.setaId(id);
		int i=aService.updAuInfo(au);
		System.out.println(i);
        return  a;
		
	}

//	/*
//	 * 登录判断
//	 */
//	@RequestMapping("/login")
//	public String login(Model model, HttpServletRequest request, HttpSession session) {
//		System.out.println("进入登录...");
//		String aName = request.getParameter("aName");
//		String aPwd = request.getParameter("aPwd");
//		String state = request.getParameter("state");
//		Author author = aService.getAuthorInfo(aName);
//
//		if (author != null) {
//			System.out.println(author.toString());
//			if (author.getaPwd().equals(aPwd)) {
//				session.setAttribute("author", author);
//				return "main";
//			} else {
//				return "login";
//			}
//		} else {
//			model.addAttribute("login", 0);
//			return "login";
//		}
//	}

	@RequestMapping("/register")
	public String register(HttpServletRequest request) {
		System.out.println("register");
		String aName = request.getParameter("aName");
		String aEmail = request.getParameter("aEmail");
		String aPwd = request.getParameter("aPwd");
		String strState = request.getParameter("state");
		int state = Integer.parseInt(strState);
		Author author = new Author();
		author.setaName(aName);
		author.setaEmail(aEmail);
		author.setaPwd(aPwd);
		author.setState(state);
		int count = aService.insertAuthor(author);
		if (count > 0) {
			return "login";
		} else {
			return "register";
		}

	}

	@RequestMapping("/selectAuthor")
	public String selectAuthor(HttpServletRequest request, Model model, HttpSession session) {
		System.out.println("查看用户信息");
		List<Author> authorList = aService.getAuthorAll();
		System.out.println(authorList.size());
		if (authorList != null) {
			session.setAttribute("authorList", authorList);
			// model.addAttribute("authorList", authorList);
			return "element";
		} else {
			return "element";
		}
	}

}
