package chapter2_LinkedList;

import java.util.Stack;

/**
 * 将单链表的每K个节点逆序 ☆☆
 */
public class P12_reverseOnK {
	/*
	 * 最优：<直接在链表中调整> 时间复杂度O(N) 额外空间复杂度O(1)
	 */
	private static P1_Node partKreverse2(P1_Node head, int k) {
		if (k <= 1 || head == null || head.next == null) {
			return head;
		}

		int count = 1;
		P1_Node cur = head;
		P1_Node left = head;
		P1_Node right = null;
		P1_Node nehead = head;// 新的head
		P1_Node prehead = null;

		while (cur != null) {

			if (count % k == 0) {
				right = cur;
				cur = cur.next;
				count++;

				if (left == head) {
					nehead = right;
				}
				reverseK(left, right);// 从left-right逆序

				if (prehead == null) {
					prehead = left;
				} else {
					prehead.next = right;
					prehead = left;
				}

				left = cur;

			} else {
				cur = cur.next;
				count++;
			}
		}
		if (right != null) {
			prehead.next = left;
		}
		return nehead;

	}

	// 逆序left-right
	private static void reverseK(P1_Node left, P1_Node right) {

		P1_Node cur = left.next;
		left.next = null;
		P1_Node r = null;

		while (cur != right) {

			r = cur.next;
			cur.next = left;
			left = cur;
			cur = r;
		}
		cur.next = left;
	}

	
	/*
	 * 方法一：<用栈> 时间复杂度O(N) 额外空间复杂度O(N)
	 */
	private static P1_Node partKreverse1(P1_Node head,int k){
		if (k <= 1 || head == null || head.next == null) {
			return head;
		}
		
		int count = 1;
		P1_Node prehead = null;P1_Node nehead = head;
		P1_Node cur = head;P1_Node h;
		P1_Node next = null;P1_Node left = head;
		Stack<P1_Node> stack = new Stack<P1_Node>();
		
		while(cur!=null){
			stack.push(cur);
			next = cur.next;
			
			if(count%k==0){
				h = Kreverse(stack,prehead);
				nehead = (nehead==head)?h:nehead;
				prehead = left;left = next;
			}
			cur = next;count++;
		}
		
		
		if(prehead!=null){
			prehead.next = left;
		}
		return nehead;
	}
	private static P1_Node Kreverse(Stack<P1_Node> stack, P1_Node prehead) {
		P1_Node h = stack.pop();
		P1_Node p = h;
		if(prehead!=null){
			prehead.next = h;
		}
		while(!stack.isEmpty()){
			p.next = stack.pop();
			p = p.next;
		}
		p.next = null;
		return h;
	}

	public static void main(String[] args) {
		P1_Node head = null;
		int K = 3;
		Utils.printLinkedList(head);
		 head = partKreverse1(head, K);
		Utils.printLinkedList(head);
		head = partKreverse2(head, K);
		Utils.printLinkedList(head);
		System.out.println("=======================");

		head = new P1_Node(1);
		K = 3;
		Utils.printLinkedList(head);
		 head = partKreverse1(head, K);
		 Utils.printLinkedList(head);
		head = partKreverse2(head, K);
		Utils.printLinkedList(head);
		System.out.println("=======================");

		head = new P1_Node(1);
		head.next = new P1_Node(2);
		K = 2;
		Utils.printLinkedList(head);
		 head = partKreverse1(head, K);
		Utils.printLinkedList(head);
		head = partKreverse2(head, K);
		Utils.printLinkedList(head);
		System.out.println("=======================");

		head = new P1_Node(1);
		head.next = new P1_Node(2);
		K = 3;
		Utils.printLinkedList(head);
		 head = partKreverse1(head, K);
		Utils.printLinkedList(head);
		head = partKreverse2(head, K);
		Utils.printLinkedList(head);
		System.out.println("=======================");

		head = new P1_Node(1);
		head.next = new P1_Node(2);
		head.next.next = new P1_Node(3);
		head.next.next.next = new P1_Node(4);
		K = 2;
		Utils.printLinkedList(head);
		 head = partKreverse1(head, K);
		Utils.printLinkedList(head);
		head = partKreverse2(head, K);
		Utils.printLinkedList(head);
		System.out.println("=======================");

		head = new P1_Node(1);
		head.next = new P1_Node(2);
		head.next.next = new P1_Node(3);
		head.next.next.next = new P1_Node(4);
		head.next.next.next.next = new P1_Node(5);
		head.next.next.next.next.next = new P1_Node(6);
		head.next.next.next.next.next.next = new P1_Node(7);
		head.next.next.next.next.next.next.next = new P1_Node(8);
		K = 3;
		Utils.printLinkedList(head);
		 head = partKreverse1(head, K);
		Utils.printLinkedList(head);
		head = partKreverse2(head, K);
		Utils.printLinkedList(head);
		System.out.println("=======================");

	}

}
