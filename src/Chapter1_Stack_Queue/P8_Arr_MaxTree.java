package Chapter1_Stack_Queue;

import java.util.HashMap;
import java.util.Stack;

/*
 * ���������MaxTree����
 *   һ�������MaxTree�������£�
 *     1.�����б���û���ظ�Ԫ��(�����Ŀ�����һ��û���ظ�Ԫ�ص�����)
 *     2.MaxTree��һ�Ŷ������������ÿ��ֵ��Ӧһ�����������
 *     3.����MaxTree���ڵ�ÿһ�������ϣ�ֵ���Ľ���������ͷ
 */
public class P8_Arr_MaxTree {

	public static P8_Node Max_Tree(int arr[]) {

		P8_Node nodeArr[] = new P8_Node[arr.length];
		for (int i = 0; i < arr.length; i++) {
			nodeArr[i] = new P8_Node(arr[i]);
		}// ��ʼ���������

		Stack<P8_Node> stackNode = new Stack<P8_Node>();

		// ����HashMap��¼ÿ�������ߵ�һ��������Ľ����ұߵ�һ��������Ľ��
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
				// ֻ�г�ջ��ʱ�����ȷ����ߺ��ұ߱�����ĵ�һ��Ԫ��
			}

			stackNode.push(nodeArr[i]);

		}

		// ���ջ�л���Ԫ��
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
				// ������û�б������Ԫ�أ����������ұ�Ϊ���ڵ�
				if (rightMax.left == null) {
					rightMax.left = nodeArr[i];
				} else {
					rightMax.right = nodeArr[i];
				}

			} else if (rightMax == null) {
				// ����ұ�û�б������Ԫ�أ������������Ϊ���ڵ�
				if (leftMax.left == null) {
					leftMax.left = nodeArr[i];
				} else {
					leftMax.right = nodeArr[i];
				}

			} else {
				// ����������߶��У���ȡ������С����Ϊ���ڵ�
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
