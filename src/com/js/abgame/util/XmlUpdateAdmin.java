package com.js.abgame.util;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

import com.js.abgame.help.InputHelp;
import com.sun.xml.internal.bind.v2.runtime.Name;

/**
 * 修改管理员信息
 * @author Abeni
 *
 */
public class XmlUpdateAdmin {
	/**
	 * 修改登录名
	 */
	public static void updateLoginname(String name) {
		//获取dom4j文档对象
		Document doc=XmlGetAdmin.getdoc();
		//找到修改的节点
		List<Element> elements=doc.selectNodes("/date/admin/loginname");
		//获取集合第一条
		Element et=elements.get(0);
		//修改
		et.setText(name);
		//格式化输出
		geShiHua(doc);
		System.out.println("修改成功");
		
	}
	
	/** 
	 * 修改密码
	 */
	public static void updatePassword(String name) {
		//获取dom4j文档对象
		Document doc=XmlGetAdmin.getdoc();
		//找到修改的节点
		List<Element> ele=doc.selectNodes("date/admin/password");
		//获取集合第一条
		Element et=ele.get(0);
		//修改
		et.setText(name);
		//格式化输出
		geShiHua(doc);
		System.out.println("修改成功");
		
	}
	/**
	 * 修改登录次数
	 */
	public static void updateLogintimes(String name) {
		//获取dom4j文档对象
		Document doc=XmlGetAdmin.getdoc();
		//找到修改的节点
		List<Element> ele=doc.selectNodes("date/admin/logintimes");
		//获取集合第一条
		Element et=ele.get(0);
		//修改
		et.setText(name);
		//格式化输出
		geShiHua(doc);
		System.out.println("修改成功");
		
	}
	/**
	 * 格式化输出方法
	 * @param doc
	 */
	public static void geShiHua(Document doc) {
		//格式化输出
				OutputFormat of=OutputFormat.createPrettyPrint();
				//首行缩进
				of.setIndent("  ");
				//换行
				of.setNewlines(true);
				//设置编码格式
				of.setEncoding("UTF-8");
				//输出流接收
				XMLWriter xw=null;
				try {
					xw = new XMLWriter(new FileOutputStream("DataInit.xml"),of);
					//写回文档
					xw.write(doc);
				} catch (UnsupportedEncodingException | FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally {
					//关闭资源
					try {
						
						xw.close();
						
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
	}
	
	
}
