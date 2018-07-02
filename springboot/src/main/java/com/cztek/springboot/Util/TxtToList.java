package com.cztek.springboot.Util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.cztek.springboot.entity.CookBook;
import com.cztek.springboot.entity.Message;


public class TxtToList {

	public static Message FileToTxt(MultipartFile file,int Id,String sale) {
		Message msg = new Message();
		List<CookBook> list = new ArrayList<>();
		InputStream inputStream;
		try {
			inputStream = file.getInputStream();
			InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "UTF-8");
			BufferedReader br = new BufferedReader(inputStreamReader);
			String line = "";
			String str = "";
			int price = 0;
			int index=0;
			line = br.readLine();
			Integer salenum = Integer.valueOf(sale);
			float sales=(float) (salenum/10.0);
			while (!StringUtils.isEmpty(line)) {
				index++;
				CookBook cookbook = new CookBook();
				int indexOf = line.indexOf(",");
				int lastIndexOf = line.lastIndexOf(",") + 1;
				if(indexOf>0 && lastIndexOf>1){
					str = line.substring(0,indexOf);
					price = Integer.valueOf(line.substring(lastIndexOf));
					price =(int) (price*sales);
					if (checkNameChese(str) && price > 0) {
						cookbook.setCookname(str);
						cookbook.setPrice(price);
						cookbook.setRestauranId(Id);
						list.add(cookbook);
					}else{
						msg.setCode(404);
						msg.setMessage("第"+index+"行请检查格式是否正确");
						return msg;
					}
				}else{
					msg.setCode(500);
					msg.setMessage("第"+index+"行请检查格式是否正确");
					return msg;
				}
				line = br.readLine();
			}
			msg.setContent(list);
			return msg;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return msg;
	}

	/**
	 * 检验一个字符是否是中文
	 * 
	 * @param c
	 * @return
	 */
	public static boolean isChineseChar(char c) {
		try {
			return String.valueOf(c).getBytes("UTF-8").length > 1;
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * 判断字符串是否是中文
	 */
	public static boolean checkNameChese(String str) {
		boolean flag = true;
		char[] charArray = str.toCharArray();
		for (int i = 0; i < charArray.length; i++) {
			if (!isChineseChar(charArray[i])) {
				flag = false;
				break;
			}
		}
		return flag;
	}
}
