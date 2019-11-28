package com.sly.demoftppool;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

//@RunWith(SpringRunner.class)
//@SpringBootTest
public class ApplicationTest {

	@Test
	public void test() throws ParseException {
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
		Calendar calendar = Calendar.getInstance();
		Date date = format.parse("20200301");
		calendar.setTime(date);
		calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH) - 1);
		System.out.println(calendar.get(Calendar.MONTH) + 1);
		Date time = calendar.getTime();
		System.out.println(calendar.get(Calendar.YEAR));
		System.out.println(format.format(time));
		
		System.out.println(calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
		
	}
	
	@Test
	public void test02() {
		InputStream is = null;
		BufferedInputStream bis = new BufferedInputStream(is);
		System.out.println();
	}

	@Test
	public void test03() {
		List<String> list = new ArrayList<String>();
		list.add("0");
		list.add("1");
		list.add("2");
		list.add("3");
		
		Iterator<String> iterator = list.iterator();
		while(iterator.hasNext()) {
			String next = iterator.next();
			System.out.println(next);
			if(next.equals("2")) {
				iterator.remove();
			}
		}
		
		System.out.println(list);
	}
	
	@Test
	public void test04() throws ParseException {
		String fileName = "/paycost/#{workDate}/channel_cost_report_#{workDate}.xls";
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
		Date date = format.parse("20190311");
		
		Calendar calendar = Calendar.getInstance();
		
        calendar.setTime(date);
        calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH) - 1);
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1;
        int maxDay = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);

        List<String> filePaths = new ArrayList<>();
        // 循环生成文件路径
        for (int i = 1; i <= maxDay; i++) {
			String monthStr = month < 10 ? "0" + month : String.valueOf(month);
			String dayStr = i < 10 ? "0" + i : String.valueOf(i);
			String dateStr = String.valueOf(year) + monthStr + dayStr;
            String filePath = StringUtils.replace(fileName, "#{workDate}", dateStr);
            filePaths.add(filePath);
        }
        
        for (String filePath : filePaths) {
			System.out.println(filePath);
		}
	}
	
	@Test
	public void test05() {
		BigDecimal payableSMoney = new BigDecimal("1");
		System.out.println(payableSMoney.compareTo(new BigDecimal("0")) == 0);
	}
}
