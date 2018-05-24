package chapter2_LinkedList;

import java.util.Stack;

/*
 * 判断一个链表是否为回文
 *    进阶 :要求时间复杂度O(n) 空间复杂度O(1)☆☆
 */

/*
 *  ※找中间结点(或者找中间结点后一个结点)时
 *     链表长度每增加2，中间结点就往后移1 ※
 */
public class P7_isHuiWen {

	/*
	 * 方法一 :时间复杂度O(n) 空间复杂度O(n) 栈
	 */
	public static boolean isPalind1(P1_Node head) {
		Stack<P1_Node> store = new Stack<>();

		P1_Node cur = head;
		while (cur != null) {
			store.push(cur);
			cur = cur.next;
		}// 把所有结点压栈

		cur = head;
		while (cur != null) {
			if (cur.value != store.pop().value) {
				return false;
			}
			cur = cur.next;
		}
		return true;

	}

	/*
	 * 方法二 :时间复杂度O(n) 空间复杂度O(n) 把右半部分压栈
	 */
	public static boolean isPalind2(P1_Node head) {
		if (head == null || head.next == null) {
			return true;
		}
		Stack<P1_Node> store = new Stack<>();

		P1_Node cur = head;
		P1_Node right = head.next;
		while (cur.next != null && cur.next.next != null) {
			right = right.next;
			cur = cur.next.next;
		}// 找到中间结点右边第一个结点

		while (right != null) {
			store.push(right);
			right = right.next;
		}// 把右半部分压栈

		cur = head;
		while (!store.isEmpty()) {
			if (store.pop().value != cur.value) {
				return false;
			}
			cur = cur.next;
		}

		return true;

	}

	/*
	 * 方法三 :时间复杂度O(n) 空间复杂度O(1) 把右半部分链表反转
	 */
	public static boolean isPalind3(P1_Node head) {
		if (head == null || head.next == null) {
			return true;
		}

		P1_Node cur = head;
		P1_Node mid = head;
		while (cur.next != null && cur.next.next != null) {
			cur = cur.next.next;
			mid = mid.next;
		}// 找到中间结点

		cur = mid.next;
		mid.next = null;
		while (cur != null) {
			P1_Node r = cur.next;
			cur.next = mid;
			mid = cur;
			cur = r;
		}// 反转右半部分链表

		boolean res = true;
		cur = head;
		P1_Node r = mid;// 记录下最右边的结点，之后还原
		while (cur != null && mid != null) {
			if (cur.value != mid.value) {
				res = false;
				break;
			}
			cur = cur.next;
			mid = mid.next;
		}

		cur = r.next;
		r.next = null;
		while (cur != null) {
			P1_Node l = cur.next;
			cur.next = r;
			r = cur;
			cur = l;
		}// 把之前反转的部分还原
		return res;

	}

	public static void main(String[] args) {
		P1_Node head = null;
		Utils.printLinkedList(head);
		System.out.print(isPalind1(head) + " | ");
		System.out.print(isPalind2(head) + " | ");
		System.out.println(isPalind3(head) + " | ");
		Utils.printLinkedList(head);
		System.out.println("=========================");

		head = new P1_Node(1);
		Utils.printLinkedList(head);
		System.out.print(isPalind1(head) + " | ");
		System.out.print(isPalind2(head) + " | ");
		System.out.println(isPalind3(head) + " | ");
		Utils.printLinkedList(head);
		System.out.println("=========================");

		head = new P1_Node(1);
		head.next = new P1_Node(2);
		Utils.printLinkedList(head);
		System.out.print(isPalind1(head) + " | ");
		System.out.print(isPalind2(head) + " | ");
		System.out.println(isPalind3(head) + " | ");
		Utils.printLinkedList(head);
		System.out.println("=========================");

		head = new P1_Node(1);
		head.next = new P1_Node(1);
		Utils.printLinkedList(head);
		System.out.print(isPalind1(head) + " | ");
		System.out.print(isPalind2(head) + " | ");
		System.out.println(isPalind3(head) + " | ");
		Utils.printLinkedList(head);
		System.out.println("=========================");

		head = new P1_Node(1);
		head.next = new P1_Node(2);
		head.next.next = new P1_Node(3);
		Utils.printLinkedList(head);
		System.out.print(isPalind1(head) + " | ");
		System.out.print(isPalind2(head) + " | ");
		System.out.println(isPalind3(head) + " | ");
		Utils.printLinkedList(head);
		System.out.println("=========================");

		head = new P1_Node(1);
		head.next = new P1_Node(2);
		head.next.next = new P1_Node(1);
		Utils.printLinkedList(head);
		System.out.print(isPalind1(head) + " | ");
		System.out.print(isPalind2(head) + " | ");
		System.out.println(isPalind3(head) + " | ");
		Utils.printLinkedList(head);
		System.out.println("=========================");

		head = new P1_Node(1);
		head.next = new P1_Node(2);
		head.next.next = new P1_Node(3);
		head.next.next.next = new P1_Node(1);
		Utils.printLinkedList(head);
		System.out.print(isPalind1(head) + " | ");
		System.out.print(isPalind2(head) + " | ");
		System.out.println(isPalind3(head) + " | ");
		Utils.printLinkedList(head);
		System.out.println("=========================");

		head = new P1_Node(1);
		head.next = new P1_Node(2);
		head.next.next = new P1_Node(2);
		head.next.next.next = new P1_Node(1);
		Utils.printLinkedList(head);
		System.out.print(isPalind1(head) + " | ");
		System.out.print(isPalind2(head) + " | ");
		System.out.println(isPalind3(head) + " | ");
		Utils.printLinkedList(head);
		System.out.println("=========================");

		head = new P1_Node(1);
		head.next = new P1_Node(2);
		head.next.next = new P1_Node(3);
		head.next.next.next = new P1_Node(2);
		head.next.next.next.next = new P1_Node(1);
		Utils.printLinkedList(head);
		System.out.print(isPalind1(head) + " | ");
		System.out.print(isPalind2(head) + " | ");
		System.out.println(isPalind3(head) + " | ");
		Utils.printLinkedList(head);
		System.out.println("=========================");
	}

}
