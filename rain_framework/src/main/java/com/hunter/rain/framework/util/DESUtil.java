package com.hunter.rain.framework.util;

import java.security.Key;

import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;
import javax.crypto.spec.IvParameterSpec;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

/**
 * 3DES加密
 * 
 */
@SuppressWarnings("restriction")
public class DESUtil {
	
	private static String pkkey ="30DmQ0trv4c0XazOSfJ8Pcn4GlslN8zD";
	
	public static void main(String[] args) throws Exception {
		
		byte[] keyiv = { 1, 2, 3, 4, 5, 6, 7, 8 };
		byte[] data = "2017-12-12@yuanlw@123".getBytes("UTF-8");

		System.out.println("ECB加密解密");
		byte[] str3 = des3EncodeECB(data);
		byte[] str4 = ees3DecodeECB(str3);
		System.out.println(new BASE64Encoder().encode(str3));
		System.out.println(new String(str4, "UTF-8"));
		System.out.println();
		System.out.println("CBC加密解密");
		byte[] str5 = des3EncodeCBC(keyiv, data);
		byte[] str6 = des3DecodeCBC(keyiv, str5);
		System.out.println(new BASE64Encoder().encode(str5));
		System.out.println(new String(str6, "UTF-8"));
	}

	public static byte[] des3EncodeECB(byte[] data) throws Exception {
		byte[] key = new BASE64Decoder().decodeBuffer(pkkey);
		Key deskey = null;
		DESedeKeySpec spec = new DESedeKeySpec(key);
		SecretKeyFactory keyfactory = SecretKeyFactory.getInstance("desede");
		deskey = keyfactory.generateSecret(spec);
		Cipher cipher = Cipher.getInstance("desede" + "/ECB/PKCS5Padding");
		cipher.init(Cipher.ENCRYPT_MODE, deskey);
		byte[] bOut = cipher.doFinal(data);
		return bOut;
	}

	public static byte[] ees3DecodeECB(byte[] data) throws Exception {
		byte[] key = new BASE64Decoder().decodeBuffer(pkkey);
		Key deskey = null;
		DESedeKeySpec spec = new DESedeKeySpec(key);
		SecretKeyFactory keyfactory = SecretKeyFactory.getInstance("desede");
		deskey = keyfactory.generateSecret(spec);
		Cipher cipher = Cipher.getInstance("desede" + "/ECB/PKCS5Padding");
		cipher.init(Cipher.DECRYPT_MODE, deskey);
		byte[] bOut = cipher.doFinal(data);
		return bOut;
	}

	public static byte[] des3EncodeCBC(byte[] keyiv, byte[] data) throws Exception {
		byte[] key = new BASE64Decoder().decodeBuffer(pkkey);
		Key deskey = null;
		DESedeKeySpec spec = new DESedeKeySpec(key);
		SecretKeyFactory keyfactory = SecretKeyFactory.getInstance("desede");
		deskey = keyfactory.generateSecret(spec);
		Cipher cipher = Cipher.getInstance("desede" + "/CBC/PKCS5Padding");
		IvParameterSpec ips = new IvParameterSpec(keyiv);
		cipher.init(Cipher.ENCRYPT_MODE, deskey, ips);
		byte[] bOut = cipher.doFinal(data);
		return bOut;
	}

	public static byte[] des3DecodeCBC(byte[] keyiv, byte[] data) throws Exception {
		byte[] key = new BASE64Decoder().decodeBuffer(pkkey);
		Key deskey = null;
		DESedeKeySpec spec = new DESedeKeySpec(key);
		SecretKeyFactory keyfactory = SecretKeyFactory.getInstance("desede");
		deskey = keyfactory.generateSecret(spec);
		Cipher cipher = Cipher.getInstance("desede" + "/CBC/PKCS5Padding");
		IvParameterSpec ips = new IvParameterSpec(keyiv);
		cipher.init(Cipher.DECRYPT_MODE, deskey, ips);
		byte[] bOut = cipher.doFinal(data);
		return bOut;
	}
}

