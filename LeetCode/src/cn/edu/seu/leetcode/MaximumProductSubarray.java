package cn.edu.seu.leetcode;

public class MaximumProductSubarray {
	// method A
	public int maxProduct(int[] A) {
		Integer pValue = null, nValue = null;
		int maxProduct = A[0];

		for (int i = 0; i < A.length; i++) {
			Integer tempP = null, tempN = null;
			if (A[i] == 0) {
				pValue = nValue = null;
				maxProduct = maxProduct < 0 ? 0 : maxProduct;
			} else if (A[i] > 0) {
				tempP = pValue == null ? A[i] : pValue * A[i];
				tempN = nValue == null ? null : nValue * A[i];
			} else {
				tempP = nValue == null ? null : nValue * A[i];
				tempN = pValue == null ? A[i] : pValue * A[i];
			}
			pValue = tempP;
			nValue = tempN;
			if (pValue != null) {
				maxProduct = maxProduct < pValue ? pValue : maxProduct;
			} else if (nValue != null) {
				maxProduct = maxProduct < nValue ? nValue : maxProduct;
			}
		}
		return maxProduct;
	}

	// method B
	public int maxProductB(int[] A) {
		int max = A[0];
		int min = A[0];
		int maxProduct = max;

		for (int i = 1; i < A.length; i++) {
			int temp = max;
			max = Math.max(A[i], Math.max(max * A[i], min * A[i]));
			min = Math.min(A[i], Math.min(temp * A[i], min * A[i]));
			maxProduct = maxProduct < max ? max : maxProduct;
		}
		return maxProduct;
	}
}
