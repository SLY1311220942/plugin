package com.sly.plugin.sensitiveword.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 敏感词过滤属性类
 * 
 * @author sly
 * @time 2019年6月27日
 */
@ConfigurationProperties(prefix = "plugin.sensitive-word")
public class SensitiveWordProperties {
	/** 敏感词文件位置 */
	private String wordFileLocation;
	
	/** 无效字符 默认:空格,*,#,@ */
	private String invaChar = " *#@";

	public String getWordFileLocation() {
		return wordFileLocation;
	}

	public void setWordFileLocation(String wordFileLocation) {
		this.wordFileLocation = wordFileLocation;
	}

	public char[] getInvaChar() {
		char[] invaChars = {};
		if(invaChar != null ) {
			invaChars = invaChar.toCharArray();
		}
		return invaChars;
	}

	public void setInvaChar(String invaChar) {
		this.invaChar = invaChar;
	}

	

}
