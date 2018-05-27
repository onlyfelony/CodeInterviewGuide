package chapter2_LinkedList;

import java.util.HashMap;

/*
 * 复制含有随机指针节点的链表
 *   进阶 :要求时间复杂度O(n) 空间复杂度O(1)☆☆
 */
public class P9_CopyList {

	/*
	 * 方法一 :时间复杂度O(n) 空间复杂度O(n) <用HashMap把原来链表结点与新的链表结点映射>
	 */
	public static P9_Node copyListWithRand1(P9_Node head) {
		HashMap<P9_Node, P9_Node> map = new HashMap<P9_Node, P9_Node>();
		P9_Node cur = head;
		while (cur != null) {
			map.put(cur, new P9_Node(cur.value));
			cur = cur.next;
		}// 把原来的链表结点和新的链表结点映射

		cur = head;
		while (cur != null) {
			map.get(cur).next = map.get(cur.next);
			map.get(cur).rand = map.get(cur.rand);
			cur = cur.next;
		}// 设置新的结点的next和rand

		return map.get(head);

	}

	/*
	 * 方法二 :时间复杂度O(n) 空间复杂度O(1) <把复制的节点插在原来结点的后面>
	 */
	public static P9_Node copyListWithRand2(P9_Node head) {
		if (head == null) {
			return null;
		}

		P9_Node cur = head;
		while (cur != null) {
			P9_Node nCur = new P9_Node(cur.value);
			nCur.next = cur.next;
			cur.next = nCur;
			cur = cur.next.next;
		}// 把新节点插在原来节点的后面

		cur = head;
		while (cur != null) {
			cur.next.rand = (cur.rand == null) ? null : cur.rand.next;
			cur = cur.next.next;
		}//设置新节点的rand

		
		P9_Node nHead = head.next;
		P9_Node nCur = nHead;
		cur = head;
		while(nCur.next!=null){
			cur.next = nCur.next;
			cur = cur.next;
			nCur.next = cur.next;
			nCur = nCur.next;
		}
		cur.next = nCur.next;//把两个链表分开
		
		return nHead;
	}

	public static void main(String[] args) {
		P9_Node head = null;
		P9_Node res1 = null;
		P9_Node res2 = null;
		Utils.printRandLinkedList(head);
		res1 = copyListWithRand1(head);
		Utils.printRandLinkedList(res1);
		res2 = copyListWithRand2(head);
		Utils.printRandLinkedList(res2);
		Utils.printRandLinkedList(head);
		System.out.println("=========================");

		head = new P9_Node(1);
		head.next = new P9_Node(2);
		head.next.next = new P9_Node(3);
		head.next.next.next = new P9_Node(4);
		head.next.next.next.next = new P9_Node(5);
		head.next.next.next.next.next = new P9_Node(6);

		head.rand = head.next.next.next.next.next; // 1 -> 6
		head.next.rand = head.next.next.next.next.next; // 2 -> 6
		head.next.next.rand = head.next.next.next.next; // 3 -> 5
		head.next.next.next.rand = head.next.next; // 4 -> 3
		head.next.next.next.next.rand = null; // 5 -> null
		head.next.next.next.next.next.rand = head.next.next.next; // 6 -> 4

		Utils.printRandLinkedList(head);
		res1 = copyListWithRand1(head);
		Utils.printRandLinkedList(res1);
		
		res2 = copyListWithRand2(head);
		Utils.printRandLinkedList(res2);
		Utils.printRandLinkedList(head);
		System.out.println("=========================");
	}

}
