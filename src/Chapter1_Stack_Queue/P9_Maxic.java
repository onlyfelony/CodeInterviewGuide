package Chapter1_Stack_Queue;

import java.util.Stack;

/*
 * 求最大子矩阵的大小☆☆☆
 */
public class P9_Maxic {

	public static int Maxic(int[][] map) {
		int maxSize = 0;
		int height[][] = new int[map.length][map[0].length];

		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				if (i == 0) {
					height[i][j] = map[i][j];
				} else {
					height[i][j] = (map[i][j] == 0) ? 0 : height[i - 1][j] + 1;
				}

			}

			maxSize = Math.max(maxSize, solveMax(height[i]));
		}

		return maxSize;

	}

	private static int solveMax(int[] h) {

		Stack<Integer> mStack = new Stack<Integer>();
		int cuMax = 0;

		for (int j = 0; j < h.length; j++) {

			while (!mStack.isEmpty() && (h[mStack.peek()] >h[j])) {
				// 维持递增序列
				int leftId;
				int rightId = j;
				int popId = mStack.pop();// 记录出栈元素的下标

				if (mStack.isEmpty()) {
					leftId = -1;
				} else {
					leftId = mStack.peek();
				}

				cuMax = Math.max(cuMax, (rightId - leftId - 1) * h[popId]);
			}

			mStack.push(j);

		}

		while (!mStack.isEmpty()) {
			int pId = mStack.pop();
			int lId;
			if (mStack.isEmpty()) {
				lId = -1;
			} else {
				lId = mStack.peek();
			}
//由于右边已经出栈的比它大，所以右边应该可以扩展到数组最右边
			cuMax = Math.max(cuMax, (h.length - lId-1) * h[pId]);

		}

		return cuMax;
	}

	public static void main(String[] args) {

		int[][] map = { { 1, 0, 1, 1 }, { 1, 1, 1, 1 }, { 1, 1, 1, 0 }};
		
		int []h = {3,4,5,4,3,6};
		System.out.println(Maxic(map));
		System.out.println("----");
		System.out.println(solveMax(h));
	}

}
