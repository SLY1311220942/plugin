package com.sly.plugin.xss.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * xss过滤器配置
 * 
 * @author sly
 * @time 2019年6月18日
 */
@ConfigurationProperties(prefix = "plugin.xss-filter")
public class XssFilterProperties {
	private Filter filter;
	private Exclude exclude;

	public Filter getFilter() {
		return filter;
	}

	public void setFilter(Filter filter) {
		this.filter = filter;
	}

	public Exclude getExclude() {
		return exclude;
	}

	public void setExclude(Exclude exclude) {
		this.exclude = exclude;
	}

	public class Filter {
		/** 需要过滤的字符 */
		private String[] sqlstr = { "'", "exec", "execute", "insert", "delete", "update", "drop", "\\%", "master",
				"truncate", "declare", "sitename", "xp_cmdshell", "create", "table", "grant", "group_concat", "column",
				"schema", "union", ";--", "<", ">", "\\(", "\\)", "eval\\((.*)\\)" };

		/** 过滤后的字符 */
		private String[] nsqlstr = { "＇", "ｅｘｅｃ", "ｅｘｅｃｕｔｅ", "ｉｎｓｅｒｔ", "ｄｅｌｅｔｅ", "ｕｐｄａｔｅ", "ｄｒｏｐ", "％", "ｍａｓｔｅｒ",
				"ｔｒｕｎｃａｔｅ", "ｄｅｃｌａｒｅ", "ｓｉｔｅｎａｍｅ", "ｘｐ＿ｃｍｄｓｈｅｌｌ", "ｃｒｅａｔｅ", "ｔａｂｌｅ", "ｇｒａｎｔ", "ｇｒｏｕｐ＿ｃｏｎｃａｔ", "ｃｏｌｕｍｎ",
				"ｓｃｈｅｍａ", "ｕｎｉｏｎ", "；－－", "＜", "＞", "（", "）", "ｅｖａｌ＼＼（（．＊）＼＼）" };

		public String[] getSqlstr() {
			return sqlstr;
		}

		public void setSqlstr(String[] sqlstr) {
			this.sqlstr = sqlstr;
		}

		public String[] getNsqlstr() {
			return nsqlstr;
		}

		public void setNsqlstr(String[] nsqlstr) {
			this.nsqlstr = nsqlstr;
		}

	}

	public class Exclude {
		/** 排除路径 */
		private String[] excludePath;

		public String[] getExcludePath() {
			return excludePath;
		}

		public void setExcludePath(String[] excludePath) {
			this.excludePath = excludePath;
		}

	}

}
