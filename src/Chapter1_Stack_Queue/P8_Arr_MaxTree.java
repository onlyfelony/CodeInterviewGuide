package Chapter1_Stack_Queue;

import java.util.HashMap;
import java.util.Stack;

/*
 * 构造数组的MaxTree☆☆☆
 *   一个数组的MaxTree定义如下：
 *     1.数组中必须没有重复元素(这个题目会给定一个没有重复元素的数组)
 *     2.MaxTree是一颗二叉树，数组的每个值对应一个二叉树结点
 *     3.包括MaxTree在内的每一颗子树上，值最大的结点就是树的头
 */
public class P8_Arr_MaxTree {

	public static P8_Node Max_Tree(int arr[]) {

		P8_Node nodeArr[] = new P8_Node[arr.length];
		for (int i = 0; i < arr.length; i++) {
			nodeArr[i] = new P8_Node(arr[i]);
		}// 初始化结点数组

		Stack<P8_Node> stackNode = new Stack<P8_Node>();

		// 两个HashMap记录每个结点左边第一个比它大的结点和右边第一个比它大的结点
		HashMap<P8_Node, P8_Node> lM_Node = new HashMap<P8_Node, P8_Node>();
		HashMap<P8_Node, P8_Node> rM_Node = new HashMap<P8_Node, P8_Node>();

		for (int i = 0; i < arr.length; i++) {
			while (!stackNode.isEmpty() && (stackNode.peek().value < arr[i])) {
				P8_Node popNod = stackNode.pop();
				rM_Node.put(popNod, nodeArr[i]);

				if (stackNode.isEmpty()) {
					lM_Node.put(popNod, null);
				} else {
					lM_Node.put(popNod, stackNode.peek());
				}
				// 只有出栈的时候才能确定左边和右边比它大的第一个元素
			}

			stackNode.push(nodeArr[i]);

		}

		// 如果栈中还有元素
		while (!stackNode.isEmpty()) {
			P8_Node pNode = stackNode.pop();
			rM_Node.put(pNode, null);

			if (stackNode.isEmpty()) {
				lM_Node.put(pNode, null);
			} else {
				lM_Node.put(pNode, stackNode.peek());
			}

		}

		P8_Node head = null;
		for (int i = 0; i < arr.length; i++) {
			P8_Node leftMax = lM_Node.get(nodeArr[i]);
			P8_Node rightMax = rM_Node.get(nodeArr[i]);

			if (leftMax == null && rightMax == null) {
				head = nodeArr[i];
			} else if (leftMax == null) {
				// 如果左边没有比它大的元素，那它就以右边为父节点
				if (rightMax.left == null) {
					rightMax.left = nodeArr[i];
				} else {
					rightMax.right = nodeArr[i];
				}

			} else if (rightMax == null) {
				// 如果右边没有比它大的元素，那它就以左边为父节点
				if (leftMax.left == null) {
					leftMax.left = nodeArr[i];
				} else {
					leftMax.right = nodeArr[i];
				}

			} else {
				// 如果左右两边都有，就取其中最小的作为父节点
				P8_Node parent = (leftMax.value > rightMax.value) ? rightMax
						: leftMax;

				if (parent.left == null) {
					parent.left = nodeArr[i];
				} else {
					parent.right = nodeArr[i];
				}

			}

		}

		return head;
	}

	public static void printPreOrder(P8_Node head) {
		if (head == null) {
			return;
		}
		System.out.print(head.value + " ");
		printPreOrder(head.left);
		printPreOrder(head.right);
	}

	public static void printInOrder(P8_Node head) {
		if (head == null) {
			return;
		}
		printPreOrder(head.left);
		System.out.print(head.value + " ");
		printPreOrder(head.right);
	}

	public static void main(String[] args) {

		int[] uniqueArr = { 3, 4, 5, 1, 2 };
		P8_Node head = Max_Tree(uniqueArr);
		printPreOrder(head);
		System.out.println();
		printInOrder(head);

	}

}
