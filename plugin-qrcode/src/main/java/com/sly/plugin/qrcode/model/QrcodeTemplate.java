package com.sly.plugin.qrcode.model;

import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

/**
 * 二维码生成模板实体类
 * 
 * @author sly
 * @time 2019年7月15日
 */
public class QrcodeTemplate {
	private int width;
	private int height;
	private int frontColor = 0x000000;
	private int backgroundColor = 0xFFFFFF;
	private String content;
	private ErrorCorrectionLevel errorCorrectionLevel = ErrorCorrectionLevel.M;

	public QrcodeTemplate() {

	}

	/**
	 * 
	 * @param sideLength 正方形时长和宽相同
	 * @param content    二维码内容
	 */
	public QrcodeTemplate(int sideLength, String content) {
		this.width = sideLength;
		this.height = sideLength;
		this.content = content;
	}

	/**
	 * 
	 * @param sideLength           正方形时长和宽相同
	 * @param content              二维码内容
	 * @param errorCorrectionLevel 容错级别
	 */
	public QrcodeTemplate(int sideLength, String content, ErrorCorrectionLevel errorCorrectionLevel) {
		this.width = sideLength;
		this.height = sideLength;
		this.content = content;
		this.errorCorrectionLevel = errorCorrectionLevel;
	}

	/**
	 * 
	 * @param width   宽
	 * @param height  长
	 * @param content 二维码内容
	 */
	public QrcodeTemplate(int width, int height, String content) {
		this.width = width;
		this.height = height;
		this.content = content;
	}

	/**
	 * 
	 * @param sideLength      正方形时长和宽相同
	 * @param frontColor      字体颜色
	 * @param backgroundColor 背景颜色
	 * @param content         二维码内容
	 */
	public QrcodeTemplate(int sideLength, int frontColor, int backgroundColor, String content) {
		this.width = sideLength;
		this.height = sideLength;
		this.frontColor = frontColor;
		this.backgroundColor = backgroundColor;
		this.content = content;
	}

	/**
	 * 
	 * @param width                宽
	 * @param height               长
	 * @param frontColor           字体颜色
	 * @param backgroundColor      背景颜色
	 * @param content              二维码内容
	 * @param errorCorrectionLevel 容错级别
	 */
	public QrcodeTemplate(int width, int height, int frontColor, int backgroundColor, String content,
			ErrorCorrectionLevel errorCorrectionLevel) {
		this.width = width;
		this.height = height;
		this.frontColor = frontColor;
		this.backgroundColor = backgroundColor;
		this.content = content;
		this.errorCorrectionLevel = errorCorrectionLevel;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getFrontColor() {
		return frontColor;
	}

	public void setFrontColor(int frontColor) {
		this.frontColor = frontColor;
	}

	public int getBackgroundColor() {
		return backgroundColor;
	}

	public void setBackgroundColor(int backgroundColor) {
		this.backgroundColor = backgroundColor;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public ErrorCorrectionLevel getErrorCorrectionLevel() {
		return errorCorrectionLevel;
	}

	public void setErrorCorrectionLevel(ErrorCorrectionLevel errorCorrectionLevel) {
		this.errorCorrectionLevel = errorCorrectionLevel;
	}

}
