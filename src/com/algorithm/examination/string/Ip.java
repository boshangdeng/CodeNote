package com.algorithm.examination.string;

import java.util.ArrayList;

/**
 * �����ַ�����������ɣ����жϿ��ܵ�ip��ַ����� ˼·������
 * 
 * @author wangbo
 *
 */
public class Ip {

	public ArrayList<String> getIps(String s) {
		ArrayList<String> ips = new ArrayList<>();
		if (s == null || s.length() == 0)
			return ips;
		backTrace(ips, s, "", 0, 0);
		return ips;
	}

	private void backTrace(ArrayList<String> ips, String s, String current, int i, int p) {
		// �ж��Ƿ����һ�κϷ�IP��ַƴ��
		if (i == 4) {
			ips.add(current);
			return;
		}
		// ö�ٵ�ǰ�εĳ���
		for (int j = 1; j <= 3; j++) {
			// ��λ��������255
			if (j == 3 && (p+j<s.length())&&Integer.parseInt(s.substring(p, p + j)) > 255)
				continue;
			// ÿ����λ����Ϊ0
			if (s.charAt(p) == '0')
				continue;
			// ÿ������1λ��������λ
			if (s.length() - p - j < 4 - i - 1 || (s.length() - p - j > 3 * (4 - i - 1)))
				continue;
			// �ж��Ƿ���Ҫ�ָ���
			if (i > 0)
				current += ".";
			current += s.substring(p, p + j);
			backTrace(ips, s, current, i + 1, p + j);
			// ��ԭ
			current = current.substring(0, current.length() - j);
			if (i > 0)
				current = current.substring(0, current.length() - 1);
		}

	}
}
