package com.algorithm.consistencyhash;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/*
 * ʵ��һ���Թ�ϣ�㷨��ʹ�õĹ�ϣ����,ʹ��MD5�㷨����֤һ���Թ�ϣ��ƽ����
 */
public class HashFunction {
	private MessageDigest md5 = null;

	public long hash(String key) {
		if (md5 == null) {
			try {
				md5 = MessageDigest.getInstance("MD5");
			} catch (NoSuchAlgorithmException e) {
				throw new IllegalStateException("no md5 algrithm found");
			}
		}

		md5.reset();
		md5.update(key.getBytes());
		byte[] bKey = md5.digest();
		// ����Ĺ�ϣ����ʵ��ϸ��--ÿ���ֽ� & 0xFF ����λ
		long result = ((long) (bKey[3] & 0xFF) << 24)
				| ((long) (bKey[2] & 0xFF) << 16 | ((long) (bKey[1] & 0xFF) << 8) | (long) (bKey[0] & 0xFF));
		return result & 0xffffffffL;
	}
}
