package cn.edu.seu.leetcode;

import java.util.HashMap;

public class FractionToRecurringDecimal {
	public String fractionToDecimal(int numerator, int denominator) {
		StringBuilder sb = new StringBuilder();

		// "-"
		if ((numerator < 0 ^ denominator < 0) && numerator != 0)
			sb.append("-");

		// part >= 1
		// attention! abs(MIN_VALUE) == MIN_VALUE !!!
		long num = Math.abs((long) numerator);
		long den = Math.abs((long) denominator);
		sb.append(num / den);
		num %= den;
		if (num == 0)
			return sb.toString();

		// part < 1
		sb.append(".");
		HashMap<Long, Integer> map = new HashMap<Long, Integer>();
		while (num != 0) {
			num *= 10;
			if (map.containsKey(num)) {
				int index = map.get(num);
				sb.insert(index - 1, "(");
				sb.append(")");
				break;
			} else {
				sb.append(num / den);
				map.put(num, sb.length());
			}
			num %= den;
		}
		return sb.toString();
	}
}
