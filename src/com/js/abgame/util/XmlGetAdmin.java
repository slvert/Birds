package com.js.abgame.util;

import java.io.File;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.js.abgame.bean.AdminBean;

/**
 * 从xml里获取管理员信息
 * @author Abeni
 *
 */
public class XmlGetAdmin {
	/**
	 * 生成dom4j文档
	 * @return
	 */
	public static Document getdoc() {
		//创建解析器
		SAXReader sr=new SAXReader();
		//获取要修改的XML文件
		File file=new File("DataInit.xml");
		try {
			//生成dom4j文档
			Document doc=sr.read(file);
			return doc;
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//出错返回空
		return null;
	}
	/**
	 * 获得管理员信息
	 * @return
	 */
	public static AdminBean getAdminMsg() {
		//获得文档对象
		Document doc=getdoc();
		//获得根标签
		Element root=doc.getRootElement();//date
		//获得根标签的子标签
		Element ele=root.element("admin");
		//获得账号
		String loginname=ele.elementText("loginname");
		//获得密码
		String password=ele.elementText("password");
		//获得最大次数
		String logintimes=ele.elementText("logintimes");
		//创建封装类对象
		AdminBean admin=new AdminBean();
		//存入封装类
		admin.setLoginname(loginname);
		admin.setPassword(password);
		admin.setLogintimes(Integer.parseInt(logintimes));
		return admin;
		
	}
	
	/**
	 * 修改管理员信息
	 */
	public static void updateAdmin() {
		//获得文档对象
		Document doc=getdoc();
		
	}
	public static void main(String[] args) {
		AdminBean am=getAdminMsg();
		System.out.println(am.getLoginname());
		System.out.println(am.getPassword());
		System.out.println(am.getLogintimes());
	}
}
