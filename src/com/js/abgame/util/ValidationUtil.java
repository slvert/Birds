package com.js.abgame.util;
/**
 * 正则类
 * @author Abeni
 *
 */
public class ValidationUtil {
		/**
		 * 正则表达式 ^开始 $结束
		 * (?![0-9]$)在字符串结束之前不能只有数字
		 * (?![0-9]$)(?![a-zA-Z]$)在字符串结束之前不能全为数字，不能全为字母
		 */
		//用户名正则表达式必须有字母，最少1位
		public static final String CHKLOGINNAME="^(?![0-9]+$)[a-zA-Z0-9]{1,16}$";
		//密码不能纯数字或字母 最少6位最多16位
		public static final String CHKPASSWORD="^(?![0-9]+$)(?![a-zA-Z]+$)[a-zA-Z0-9]{6,16}$";
		//必须汉字 最少2位 最多4位
		public static final String CHKNICKNAME="^[\u4e00-\u9fa5]{2,4}$";
		//性别必须是男或女
		public static final String CHKSEX="^['男','女']$";
		//年龄最小18岁最大69岁
		public static final String CHKAGE="1[8-9]|[2-6][0-9]$";
}
