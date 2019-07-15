package com.sly.plugin.qrcode.generator;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageOutputStream;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.common.BitMatrix;
import com.sly.plugin.qrcode.model.QrcodeTemplate;

/**
 * qrcode生成器
 * 
 * @author sly
 * @time 2019年7月15日
 */
public class QrcodeGenerator {

	/**
	 * 生成二维码返回流
	 * 
	 * @param template
	 * @return
	 * @throws Exception
	 * @author sly
	 * @time 2019年7月15日
	 */
	public static InputStream generateQrcodeInputStream(QrcodeTemplate template) {
		try {
			Map<EncodeHintType, Object> hints = new HashMap<>();
			hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
			hints.put(EncodeHintType.ERROR_CORRECTION, template.getErrorCorrectionLevel());
			hints.put(EncodeHintType.MARGIN, 1);

			MultiFormatWriter multiFormatWriter = new MultiFormatWriter();
			BitMatrix bitMatrix = multiFormatWriter.encode(template.getContent(), BarcodeFormat.QR_CODE,
					template.getWidth(), template.getHeight(), hints);

			BufferedImage bufferedImage = new BufferedImage(template.getWidth(), template.getHeight(),
					BufferedImage.TYPE_INT_BGR);
			for (int x = 0; x < template.getWidth(); x++) {
				for (int y = 0; y < template.getHeight(); y++) {
					bufferedImage.setRGB(x, y,
							bitMatrix.get(x, y) ? template.getFrontColor() : template.getBackgroundColor());
				}
			}

			ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
			ImageOutputStream imageOutput = ImageIO.createImageOutputStream(byteArrayOutputStream);
			ImageIO.write(bufferedImage, "png", imageOutput);
			InputStream inputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());

			return inputStream;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}

	/**
	 * 生成二维码返回image
	 * 
	 * @param template
	 * @return
	 * @author sly
	 * @time 2019年7月15日
	 */
	public static BufferedImage generateQrcodeImage(QrcodeTemplate template) {
		try {
			Map<EncodeHintType, Object> hints = new HashMap<>();
			hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
			hints.put(EncodeHintType.ERROR_CORRECTION, template.getErrorCorrectionLevel());
			hints.put(EncodeHintType.MARGIN, 1);

			MultiFormatWriter multiFormatWriter = new MultiFormatWriter();
			BitMatrix bitMatrix = multiFormatWriter.encode(template.getContent(), BarcodeFormat.QR_CODE,
					template.getWidth(), template.getHeight(), hints);

			BufferedImage bufferedImage = new BufferedImage(template.getWidth(), template.getHeight(),
					BufferedImage.TYPE_INT_BGR);
			for (int x = 0; x < template.getWidth(); x++) {
				for (int y = 0; y < template.getHeight(); y++) {
					bufferedImage.setRGB(x, y,
							bitMatrix.get(x, y) ? template.getFrontColor() : template.getBackgroundColor());
				}
			}

			return bufferedImage;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}

	/**
	 * 生成带logo的二维码返回流
	 * 
	 * @param template
	 * @param logoImage
	 * @return
	 * @author sly
	 * @time 2019年7月15日
	 */
	public static InputStream generateQrcodeWithLogoInputStream(QrcodeTemplate template, BufferedImage logoImage) {
		try {
			// 生成二维码
			Map<EncodeHintType, Object> hints = new HashMap<>();
			hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
			hints.put(EncodeHintType.ERROR_CORRECTION, template.getErrorCorrectionLevel());
			hints.put(EncodeHintType.MARGIN, 1);

			MultiFormatWriter multiFormatWriter = new MultiFormatWriter();
			BitMatrix bitMatrix = multiFormatWriter.encode(template.getContent(), BarcodeFormat.QR_CODE,
					template.getWidth(), template.getHeight(), hints);

			BufferedImage bufferedImage = new BufferedImage(template.getWidth(), template.getHeight(),
					BufferedImage.TYPE_INT_BGR);
			for (int x = 0; x < template.getWidth(); x++) {
				for (int y = 0; y < template.getHeight(); y++) {
					bufferedImage.setRGB(x, y,
							bitMatrix.get(x, y) ? template.getFrontColor() : template.getBackgroundColor());
				}
			}

			// 绘制logo
			// 设置logo为二维码的1/5
			int logoWidth = template.getWidth() / 5;
			int logoHeight = template.getHeight() / 5;
			// 设置logo图片放置位置
			int x = template.getWidth() / 2 - template.getWidth() / 10;
			int y = template.getHeight() / 2 - template.getHeight() / 10;

			Graphics2D graphics2d = bufferedImage.createGraphics();
			graphics2d.drawImage(logoImage, x, y, logoWidth, logoHeight, null);
			graphics2d.drawRoundRect(x, y, logoWidth, logoHeight, 0, 0);
			// logo边框大小
			graphics2d.setStroke(new BasicStroke(2));
			// logo边框颜色
			graphics2d.setColor(Color.WHITE);
			graphics2d.drawRect(x, y, logoWidth, logoHeight);
			graphics2d.dispose();
			logoImage.flush();
			bufferedImage.flush();

			// 将image转为流
			ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
			ImageOutputStream imageOutput = ImageIO.createImageOutputStream(byteArrayOutputStream);
			ImageIO.write(bufferedImage, "png", imageOutput);
			InputStream inputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());

			return inputStream;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 生成带logo的二维码返image
	 * 
	 * @param template
	 * @param logoImage
	 * @return
	 * @author sly
	 * @time 2019年7月15日
	 */
	public static BufferedImage generateQrcodeWithLogoImage(QrcodeTemplate template, BufferedImage logoImage) {
		try {
			// 生成二维码
			Map<EncodeHintType, Object> hints = new HashMap<>();
			hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
			hints.put(EncodeHintType.ERROR_CORRECTION, template.getErrorCorrectionLevel());
			hints.put(EncodeHintType.MARGIN, 1);

			MultiFormatWriter multiFormatWriter = new MultiFormatWriter();
			BitMatrix bitMatrix = multiFormatWriter.encode(template.getContent(), BarcodeFormat.QR_CODE,
					template.getWidth(), template.getHeight(), hints);

			BufferedImage bufferedImage = new BufferedImage(template.getWidth(), template.getHeight(),
					BufferedImage.TYPE_INT_BGR);
			for (int x = 0; x < template.getWidth(); x++) {
				for (int y = 0; y < template.getHeight(); y++) {
					bufferedImage.setRGB(x, y,
							bitMatrix.get(x, y) ? template.getFrontColor() : template.getBackgroundColor());
				}
			}

			// 绘制logo
			// 设置logo为二维码的1/5
			int logoWidth = template.getWidth() / 5;
			int logoHeight = template.getHeight() / 5;
			// 设置logo图片放置位置
			int x = template.getWidth() / 2 - template.getWidth() / 10;
			int y = template.getHeight() / 2 - template.getHeight() / 10;

			Graphics2D graphics2d = bufferedImage.createGraphics();
			graphics2d.drawImage(logoImage, x, y, logoWidth, logoHeight, null);
			graphics2d.drawRoundRect(x, y, logoWidth, logoHeight, 0, 0);
			// logo边框大小
			graphics2d.setStroke(new BasicStroke(2));
			// logo边框颜色
			graphics2d.setColor(Color.WHITE);
			graphics2d.drawRect(x, y, logoWidth, logoHeight);
			graphics2d.dispose();
			logoImage.flush();
			bufferedImage.flush();

			return bufferedImage;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
}
