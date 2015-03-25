package cn.edu.seu.leetcode;

public class MedianofTwoSortedArrays {
	public double findMedianSortedArrays(int A[], int B[]) {
		int i = 0, j = 0;
		int merge[] = new int[A.length + B.length];
		while (i < A.length && j < B.length) {
			if (A[i] < B[j]) {
				merge[i + j] = A[i++];
			} else {
				merge[i + j] = B[j++];
			}
		}
		while (i < A.length) {
			merge[i + j] = A[i++];
		}
		while (j < B.length) {
			merge[i + j] = B[j++];
		}
		if (merge.length % 2 == 1) {
			return (double) merge[merge.length / 2];
		} else {
			return (double) (merge[merge.length / 2 - 1] + merge[merge.length / 2])
					/ (double) 2;
		}
	}
}
