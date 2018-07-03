package chapter2_LinkedList;

/**
 * 给定一个无序单链表头结点head，实现单链表的选择排序☆ 要求：额外空间复杂度为O(1)
 */
public class P16_SelectedSort {

	public static P1_Node selectSort(P1_Node head) {
		if (head == null || head.next == null) {
			return head;
		}

		P1_Node left = head;// 已排好序部分
		P1_Node pl = null;//left前面一个结点
		P1_Node pre = null;// 当前结点的前面一个结点
		P1_Node mp = null;// 最小结点的前面一个结点
		P1_Node cur = head;// 当前结点
		P1_Node min = left;// 最小结点
		P1_Node nehead = null;// 新头结点

		while (left != null) {

			while (cur != null) {

				if (cur.value < min.value) {
					min = cur;
					mp = pre;
				}
				pre = cur;
				cur = cur.next;
			}

			if (mp != null) {
				mp.next = min.next;

				min.next = left;

			}
			if (nehead == null) {
				nehead = min;
			} else {
				pl.next = min;
			}
			pl = min;

			left = min.next;
			pre = min;
			cur = left;
			min = left;
			mp = null;

		}

		return nehead;

	}

	public static void main(String[] args) {
		P1_Node head = null;
		head = selectSort(head);
		Utils.printLinkedList(head);

		head = new P1_Node(1);
		head = selectSort(head);
		Utils.printLinkedList(head);

		head = new P1_Node(1);
		head.next = new P1_Node(2);
		head = selectSort(head);
		Utils.printLinkedList(head);

		head = new P1_Node(2);
		head.next = new P1_Node(1);
		head = selectSort(head);
		Utils.printLinkedList(head);

		head = new P1_Node(1);
		head.next = new P1_Node(2);
		head.next.next = new P1_Node(3);
		head = selectSort(head);
		Utils.printLinkedList(head);

		head = new P1_Node(1);
		head.next = new P1_Node(3);
		head.next.next = new P1_Node(2);
		head = selectSort(head);
		Utils.printLinkedList(head);

		head = new P1_Node(2);
		head.next = new P1_Node(1);
		head.next.next = new P1_Node(3);
		head = selectSort(head);
		Utils.printLinkedList(head);

		head = new P1_Node(2);
		head.next = new P1_Node(3);
		head.next.next = new P1_Node(1);
		head = selectSort(head);
		Utils.printLinkedList(head);

		head = new P1_Node(3);
		head.next = new P1_Node(1);
		head.next.next = new P1_Node(2);
		head = selectSort(head);
		Utils.printLinkedList(head);

		head = new P1_Node(3);
		head.next = new P1_Node(2);
		head.next.next = new P1_Node(1);
		head = selectSort(head);
		Utils.printLinkedList(head);

		head = new P1_Node(3);
		head.next = new P1_Node(1);
		head.next.next = new P1_Node(4);
		head.next.next.next = new P1_Node(2);
		head = selectSort(head);
		Utils.printLinkedList(head);
	}

}
