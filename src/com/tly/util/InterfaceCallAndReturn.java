package com.tly.util;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;


@RestController
public class InterfaceCallAndReturn {


	/**
	 * 发送post请求
	 * @author 川
	 * @date 2018年9月30日  
	 * @version 1.0    
	 */
	public static String apiOpen(String url,JSONObject param) throws Exception {
		JSONObject string = null;
		StringBuffer real = new StringBuffer();
		try {
			//工具
			StringBuffer sb = new StringBuffer(url);
			String returnvalue = "";
			//设置url
			URL realUrl = new URL(sb.toString());
			//打开链接
			HttpURLConnection  con = (HttpURLConnection) realUrl.openConnection();
			//设置请求方式
			con.setRequestProperty("Content-Type", "application/json");
			con.setRequestProperty("Access-Control-Allow-Origin", "*");
			con.setRequestMethod("POST");
			
			//业务要求、设置其他请求头
			con.setRequestProperty("X-Gizwits-Application-Id", "9538ae5c8ca04a0bb5810f85244cf7d4");
			con.setRequestProperty("X-Gizwits-User-token","523061375ee6499fb5de6edf244ac3e0");
			
			con.setDoOutput(true);
			con.setDoInput(true);
			//con.connect();
			//设置输出流 把参数输出
			OutputStream out = con.getOutputStream();
			out.write(param.toString().getBytes());
			out.flush();
			out.close();
			int responseCode = con.getResponseCode();
			InputStream iStream = null;
			if (responseCode == 200) {
				iStream = con.getInputStream();
			}else {
				iStream = con.getErrorStream();
				System.out.println(responseCode);
			}
			//接受返回的json
			BufferedReader in = new BufferedReader(new InputStreamReader(iStream));
			while((returnvalue = in.readLine()) != null) {
				real.append(returnvalue);
				System.out.println(returnvalue);
			}
			in.close();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return real.toString();
	}
}
