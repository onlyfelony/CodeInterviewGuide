package chapter2_LinkedList;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 将搜索二叉树转化成有序双向链表☆☆ 
 *   方法一：时间复杂度O(N) 额外空间复杂度O(N) 
 *   方法二：时间复杂度O(N) 额外空间复杂度O(h),h为二叉树的高度
 */
/*
 * 搜索二叉树:左<根<右
 */
public class P15_treeToDLinklist {
	/*
	 * 方法一：<用队列，中序遍历>
	 */
	public static P15_TreeNode doubleNode1(P15_TreeNode head) {

		if (head == null) {
			return head;
		}

		Queue<P15_TreeNode> queue = new LinkedList<P15_TreeNode>();
		MidOrder(head, queue);// 中序遍历
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

	// 中序遍历
	public static void MidOrder(P15_TreeNode root, Queue<P15_TreeNode> queue) {
		if (root == null) {
			return;
		}

		MidOrder(root.left, queue);
		queue.offer(root);
		MidOrder(root.right, queue);

	}

	/*
	 * 方法二：<递归调整每棵子树>
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
	 *    关于时间和额外空间复杂度:可以用particuLinkList()递归函数发生的次数来估算时间复杂度,
	 * particuLinkList()会处理所有子树，子树的数量就是二叉树结点的个数，所以时间复杂度为O(N)
	 * particuLinkList()递归函数最多占用二叉树高度为h的栈空间，所以额外空间复杂度为O(h)
	 */

	// 把每棵子树调整成特殊的双向链表
	public static P15_TreeNode particuLinkList(P15_TreeNode root) {
		if (root == null) {
			return root;
		}

		P15_TreeNode mleft = root;
		P15_TreeNode mright = root;

		P15_TreeNode pleft = particuLinkList(root.left);
		P15_TreeNode pright = particuLinkList(root.right);// 调整左右子树
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

		return mright;// 返回尾部结点(此节点的right指向头部结点)
	}

	// 打印
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
