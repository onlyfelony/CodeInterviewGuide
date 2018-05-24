package chapter2_LinkedList;

import java.util.Stack;

/*
 * �ж�һ�������Ƿ�Ϊ����
 *    ���� :Ҫ��ʱ�临�Ӷ�O(n) �ռ临�Ӷ�O(1)���
 */

/*
 *  �����м���(�������м����һ�����)ʱ
 *     ������ÿ����2���м����������1 ��
 */
public class P7_isHuiWen {

	/*
	 * ����һ :ʱ�临�Ӷ�O(n) �ռ临�Ӷ�O(n) ջ
	 */
	public static boolean isPalind1(P1_Node head) {
		Stack<P1_Node> store = new Stack<>();

		P1_Node cur = head;
		while (cur != null) {
			store.push(cur);
			cur = cur.next;
		}// �����н��ѹջ

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
	 * ������ :ʱ�临�Ӷ�O(n) �ռ临�Ӷ�O(n) ���Ұ벿��ѹջ
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
		}// �ҵ��м����ұߵ�һ�����

		while (right != null) {
			store.push(right);
			right = right.next;
		}// ���Ұ벿��ѹջ

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
	 * ������ :ʱ�临�Ӷ�O(n) �ռ临�Ӷ�O(1) ���Ұ벿������ת
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
		}// �ҵ��м���

		cur = mid.next;
		mid.next = null;
		while (cur != null) {
			P1_Node r = cur.next;
			cur.next = mid;
			mid = cur;
			cur = r;
		}// ��ת�Ұ벿������

		boolean res = true;
		cur = head;
		P1_Node r = mid;// ��¼�����ұߵĽ�㣬֮��ԭ
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
		}// ��֮ǰ��ת�Ĳ��ֻ�ԭ
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
