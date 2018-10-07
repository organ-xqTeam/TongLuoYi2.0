package com.tly.util;

import com.alibaba.fastjson.JSONObject;

/**
 * 控制设备
 * @author 川
 * @date 2018年9月30日 
 */
public class ControlProduct {
	
	public static void main(String[] args) {
		
		//登录
		/*JSONObject param = new JSONObject();
		param.put("username", "admin");
		param.put("password", "123456");
		param.put("lang", "en");
		try {
			InterfaceCallAndReturn.apiOpen("https://api.gizwits.com/app/login", param);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		
		//控制机器
		JSONObject param = new JSONObject();
		JSONObject attrsParam = new JSONObject();
		attrsParam.put("dev_energy_max", 140);
		attrsParam.put("dev_energy_level", 1);
		attrsParam.put("dev_type", 2);
		attrsParam.put("dev_energy_min", 70);
		attrsParam.put("dev_power", 1);
		attrsParam.put("dev_pulse_width", 600);
		attrsParam.put("dev_led", 0);
		attrsParam.put("dev_pulse_cnt_max", 500);
		
		param.put("attrs", attrsParam);
		try {
			InterfaceCallAndReturn.apiOpen("https://api.gizwits.com/app/control/Lc9mpnB4foFvDbQXJ9nNbL", param);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
