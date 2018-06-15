package chapter2_LinkedList;

import java.util.LinkedList;
import java.util.Queue;

/**
 * ������������ת��������˫�������� 
 *   ����һ��ʱ�临�Ӷ�O(N) ����ռ临�Ӷ�O(N) 
 *   ��������ʱ�临�Ӷ�O(N) ����ռ临�Ӷ�O(h),hΪ�������ĸ߶�
 */
/*
 * ����������:��<��<��
 */
public class P15_treeToDLinklist {
	/*
	 * ����һ��<�ö��У��������>
	 */
	public static P15_TreeNode doubleNode1(P15_TreeNode head) {

		if (head == null) {
			return head;
		}

		Queue<P15_TreeNode> queue = new LinkedList<P15_TreeNode>();
		MidOrder(head, queue);// �������
		P15_TreeNode nhead = queue.poll();
		P15_TreeNode pre = nhead;
		P15_TreeNode cur = nhead;

		while (!queue.isEmpty()) {
			pre.right = queue.poll();
			cur = pre.right;
			cur.left = pre;
			pre = cur;
		}
		return nhead;

	}

	// �������
	public static void MidOrder(P15_TreeNode root, Queue<P15_TreeNode> queue) {
		if (root == null) {
			return;
		}

		MidOrder(root.left, queue);
		queue.offer(root);
		MidOrder(root.right, queue);

	}

	/*
	 * ��������<�ݹ����ÿ������>
	 */
	public static P15_TreeNode doubleNode2(P15_TreeNode head) {
		if (head == null) {
			return head;
		}
		P15_TreeNode nh = particuLinkList(head);

		P15_TreeNode nehead = nh.right;
		nh.right = null;

		return nehead;
	}

	/*
	 *    ����ʱ��Ͷ���ռ临�Ӷ�:������particuLinkList()�ݹ麯�������Ĵ���������ʱ�临�Ӷ�,
	 * particuLinkList()�ᴦ�������������������������Ƕ��������ĸ���������ʱ�临�Ӷ�ΪO(N)
	 * particuLinkList()�ݹ麯�����ռ�ö������߶�Ϊh��ջ�ռ䣬���Զ���ռ临�Ӷ�ΪO(h)
	 */

	// ��ÿ�����������������˫������
	public static P15_TreeNode particuLinkList(P15_TreeNode root) {
		if (root == null) {
			return root;
		}

		P15_TreeNode mleft = root;
		P15_TreeNode mright = root;

		P15_TreeNode pleft = particuLinkList(root.left);
		P15_TreeNode pright = particuLinkList(root.right);// ������������
		if (pleft != null) {
			mleft = pleft.right;
			pleft.right = root;
		}
		root.left = pleft;

		if (pright != null) {
			pright.left = root;
			mright = pright;
		}
		root.right = pright;
		mright.right = mleft;

		return mright;// ����β�����(�˽ڵ��rightָ��ͷ�����)
	}

	// ��ӡ
	public static void printBSTInOrder(P15_TreeNode head) {
		System.out.print("BST in-order: ");
		if (head != null) {
			inOrderPrint(head);
		}
		System.out.println();
	}

	public static void inOrderPrint(P15_TreeNode head) {
		if (head == null) {
			return;
		}
		inOrderPrint(head.left);
		System.out.print(head.value + " ");
		inOrderPrint(head.right);
	}

	public static void printDoubleLinkedList(P15_TreeNode head) {
		System.out.print("Double Linked List: ");
		P15_TreeNode end = null;
		while (head != null) {
			System.out.print(head.value + " ");
			end = head;
			head = head.right;
		}
		System.out.print("| ");
		while (end != null) {
			System.out.print(end.value + " ");
			end = end.left;
		}
		System.out.println();
	}

	public static void main(String[] args) {
		P15_TreeNode head = new P15_TreeNode(5);
		head.left = new P15_TreeNode(2);
		head.right = new P15_TreeNode(9);
		head.left.left = new P15_TreeNode(1);
		head.left.right = new P15_TreeNode(3);
		head.left.right.right = new P15_TreeNode(4);
		head.right.left = new P15_TreeNode(7);
		head.right.right = new P15_TreeNode(10);
		head.left.left = new P15_TreeNode(1);
		head.right.left.left = new P15_TreeNode(6);
		head.right.left.right = new P15_TreeNode(8);

		printBSTInOrder(head);
		head = doubleNode1(head);
		printDoubleLinkedList(head);

		head = new P15_TreeNode(5);
		head.left = new P15_TreeNode(2);
		head.right = new P15_TreeNode(9);
		head.left.left = new P15_TreeNode(1);
		head.left.right = new P15_TreeNode(3);
		head.left.right.right = new P15_TreeNode(4);
		head.right.left = new P15_TreeNode(7);
		head.right.right = new P15_TreeNode(10);
		head.left.left = new P15_TreeNode(1);
		head.right.left.left = new P15_TreeNode(6);
		head.right.left.right = new P15_TreeNode(8);

		printBSTInOrder(head);
		head = doubleNode1(head);
		printDoubleLinkedList(head);
	}

}
