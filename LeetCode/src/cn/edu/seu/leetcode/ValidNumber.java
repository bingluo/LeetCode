package cn.edu.seu.leetcode;

public class ValidNumber {
	public boolean isNumber(String s) {
		char array[] = s.trim().toCharArray();
		boolean point = false;
		boolean e = false;
		boolean number = false;
		boolean numberAfterE = true;
		boolean flag = false;
		for (int i = 0; i < array.length; i++) {
			if (array[i] >= '0' && array[i] <= '9') {
				number = true;
				numberAfterE = true;
			} else if (((array[i] == '+' || array[i] == '-') && !flag
					&& !number && !e && !point)
					|| (array[i] == '+' || array[i] == '-')
					&& number
					&& e
					&& !numberAfterE) {
				flag = true;
			} else if (array[i] == '.' && !e) {
				if (point)
					return false;
				else {
					point = true;
				}
			} else if (array[i] == 'e') {
				if (!number || e)
					return false;
				else {
					e = true;
					numberAfterE = false;
				}
			} else {
				return false;
			}
		}
		if (number && numberAfterE)
			return true;
		else
			return false;
	}
}
