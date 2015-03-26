package cn.edu.seu.leetcode;

public class RemoveElement {
	public int removeElement(int[] A, int elem) {
		int length = 0;
		for (int i = 0; i < A.length; i++) {
			if (A[i] != elem) {
				A[length++] = A[i];
			}
		}
		return length;
	}
}
