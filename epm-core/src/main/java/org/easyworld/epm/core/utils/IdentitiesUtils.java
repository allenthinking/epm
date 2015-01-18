package org.easyworld.epm.core.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class IdentitiesUtils {
	private static Random random = new Random();

	/**
	 * generate identity as the date and random with the length
	 * @return
	 */
	public static String generateDateAndRandom(int length) {
		random = new Random();
		Double d = random.nextDouble();
		String s = d + "";
		s = s.substring(3, 3 + length);

		SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
		String str = format.format(new Date());

		str = str + s;
		return str;

	}

	public static final String allChar = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
	public static final String letterChar = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
	public static final String numberChar = "0123456789";

	/**
	 * 返回一个定长的�?机字符串(�?�包�?�大�?写字�?�?数字)
	 * 
	 * @param length
	 *            �?机字符串长度
	 * @return �?机字符串
	 */
	public static String generateString(int length) {
		StringBuffer sb = new StringBuffer();
		Random random = new Random();
		for (int i = 0; i < length; i++) {
			sb.append(allChar.charAt(random.nextInt(allChar.length())));
		}
		return sb.toString();
	}

	/**
	 * 返回一个定长的�?机纯字�?字符串(�?�包�?�大�?写字�?)
	 * 
	 * @param length
	 *            �?机字符串长度
	 * @return �?机字符串
	 */
	public static String generateMixString(int length) {
		StringBuffer sb = new StringBuffer();
		Random random = new Random();
		for (int i = 0; i < length; i++) {
			sb.append(allChar.charAt(random.nextInt(letterChar.length())));
		}
		return sb.toString();
	}

	/**
	 * 返回一个定长的�?机纯大写字�?字符串(�?�包�?�大�?写字�?)
	 * 
	 * @param length
	 *            �?机字符串长度
	 * @return �?机字符串
	 */
	public static String generateLowerString(int length) {
		return generateMixString(length).toLowerCase();
	}

	/**
	 * 返回一个定长的�?机纯�?写字�?字符串(�?�包�?�大�?写字�?)
	 * 
	 * @param length
	 *            �?机字符串长度
	 * @return �?机字符串
	 */
	public static String generateUpperString(int length) {
		return generateMixString(length).toUpperCase();
	}

	/**
	 * 生�?一个定长的纯0字符串
	 * 
	 * @param length
	 *            字符串长度
	 * @return 纯0字符串
	 */
	public static String generateZeroString(int length) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < length; i++) {
			sb.append('0');
		}
		return sb.toString();
	}

	/**
	 * 根�?�数字生�?一个定长的字符串，长度�?够�?�?�补0
	 * 
	 * @param num
	 *            数字
	 * @param fixdlenth
	 *            字符串长度
	 * @return 定长的字符串
	 */
	public static String toFixdLengthString(long num, int fixdlenth) {
		StringBuffer sb = new StringBuffer();
		String strNum = String.valueOf(num);
		if (fixdlenth - strNum.length() >= 0) {
			sb.append(generateZeroString(fixdlenth - strNum.length()));
		} else {
			throw new RuntimeException("将数字" + num + "转化为长度为" + fixdlenth
					+ "的字符串�?�生异常�?");
		}
		sb.append(strNum);
		return sb.toString();
	}

	/**
	 * 根�?�数字生�?一个定长的字符串，长度�?够�?�?�补0
	 * 
	 * @param num
	 *            数字
	 * @param fixdlenth
	 *            字符串长度
	 * @return 定长的字符串
	 */
	public static String toFixdLengthString(int num, int fixdlenth) {
		StringBuffer sb = new StringBuffer();
		String strNum = String.valueOf(num);
		if (fixdlenth - strNum.length() >= 0) {
			sb.append(generateZeroString(fixdlenth - strNum.length()));
		} else {
			throw new RuntimeException("将数字" + num + "转化为长度为" + fixdlenth
					+ "的字符串�?�生异常�?");
		}
		sb.append(strNum);
		return sb.toString();
	}

	public static void main(String[] args) {

		Random r = new Random();
		Double d = r.nextDouble();
		System.out.println(d);
		String s = d + "";
		s = s.substring(3, 3 + 6);
		System.out.println(s);

		SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
		String str = format.format(new Date());
		System.out.println(str);
		
		System.out.println(IdentitiesUtils.generateDateAndRandom(6));
	}
}
