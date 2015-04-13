package cn.edu.seu.leetcode;

import java.util.Stack;

public class SimplifyPath {
	public String simplifyPath(String path) {
		String files[] = path.split("/");
		Stack<String> stack = new Stack<String>();
		for (int i = 0; i < files.length; i++) {
			String file = files[i];
			if (file == null || file.isEmpty() || file.equals(".")) {

			} else if (file.equals("..")) {
				if (!stack.isEmpty())
					stack.pop();
			} else {
				stack.push(file);
			}
		}
		StringBuilder sb = new StringBuilder();
		for (Object obj : stack.toArray()) {
			sb.append("/").append(((String) obj).toString());
		}
		return stack.size() == 0 ? "/" : sb.toString();
	}
}
