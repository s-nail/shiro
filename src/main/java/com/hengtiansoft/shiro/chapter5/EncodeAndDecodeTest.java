package com.hengtiansoft.shiro.chapter5;

import java.security.Key;

import org.apache.shiro.authc.credential.PasswordService;
import org.apache.shiro.codec.Base64;
import org.apache.shiro.codec.Hex;
import org.apache.shiro.crypto.AesCipherService;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.junit.Test;

public class EncodeAndDecodeTest {

	@Test
	public void encodeAndDecode() {
		String str = "hello";
		String base64Encoded = Base64.encodeToString(str.getBytes());
		System.out.println("base64Encoded:" + base64Encoded);
		String str2 = Base64.decodeToString(base64Encoded);
		System.out.println("str2:" + str2);
		System.out.println(str.equals(str2));

		String base64Encoded2 = Hex.encodeToString(str.getBytes());
		String str3 = new String(Hex.decode(base64Encoded2.getBytes()));
		// Assert.assertEquals(str, str2);
		System.out.println("Hex.decode:" + str.equals(str3));

	}

	@Test
	public void md5() {
		String str = "hello";
		String salt = "123";
		String md5 = new Md5Hash(str, salt).toString();
		String md5twice = new Md5Hash(str, salt, 2).toString();
		String md5annothertwice = new Md5Hash(str, salt, 2).toString();

		System.out.println("散列算法md5:" + md5);
		System.out.println("散列算法md5twice:" + md5twice);
		System.out.println("散列算法md5annothertwice:" + md5annothertwice);
		System.out.println(md5twice.equals(md5annothertwice));
	}

	@Test
	public void AES() {
		AesCipherService aesCipherService = new AesCipherService();
		aesCipherService.setKeySize(128);
		// 生成key
		Key key = aesCipherService.generateNewKey();
		String text = "hello";
		// 加密
		String encrptText = aesCipherService.encrypt(text.getBytes(),
				key.getEncoded()).toHex();
		System.out.println(encrptText);
		// 解密
		String text2 = new String(aesCipherService.decrypt(
				Hex.decode(encrptText), key.getEncoded()).getBytes());

		System.out.println(text.equals(text2));

	}

}
