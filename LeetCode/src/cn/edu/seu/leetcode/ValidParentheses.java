package cn.edu.seu.leetcode;

import java.util.Stack;

public class ValidParentheses {
	public boolean isValid(String s) {
		Stack<Character> stack = new Stack<Character>();
		for (char c : s.toCharArray()) {
			if (c == '(' || c == '{' || c == '[') {
				stack.push(c);
			} else if (c == ')') {
				if (stack.isEmpty() || stack.pop() != '(')
					return false;
			} else if (c == '}') {
				if (stack.isEmpty() || stack.pop() != '{')
					return false;
			} else if (c == ']') {
				if (stack.isEmpty() || stack.pop() != '[')
					return false;
			}
			// for right parentheses, pop() is necessary
		}
		// never forget!!!
		if (stack.isEmpty())
			return true;
		else
			return false;
	}
}
