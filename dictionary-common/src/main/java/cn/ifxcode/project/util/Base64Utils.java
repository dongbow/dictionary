package cn.ifxcode.project.util;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.StringUtils;

/**
 * Base64
 *
 * @author dongbo
 * @date 2017/10/20
 */
public class Base64Utils {
	
	public static String encrypt(String s){
		if(StringUtils.isEmpty(s)){
			return "";
		}
		s = new String(Base64.encodeBase64(s.getBytes()));
		return s;
	}
	
	public static String decrypt(String s){
		if(StringUtils.isEmpty(s)){
			return "";
		}
		s = new String(Base64.decodeBase64(s.getBytes()));
		return s;
	}
	
}
