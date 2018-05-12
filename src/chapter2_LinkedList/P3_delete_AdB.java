package chapter2_LinkedList;

/*
 * 删除链表的中间结点和a/b处的结点☆
 */
public class P3_delete_AdB {

	// 删除中间结点
	// 方法1：和删除a/b差不多(a=n,b=2) 但不是最优解
	public static P1_Node delet_mid1(P1_Node head) {
		if (head == null) {
			return head;
		}
		P1_Node cur = head;
		int n = 0;
		while (cur != null) {
			n++;
			cur = cur.next;
		}

		int k = (int) Math.ceil(n / 2.0);

		if (k == 1) {
			head = head.next;
		} else if (k > 1) {
			int i = 1;
			cur = head;
			while (i < k - 1) {
				cur = cur.next;
				i++;
			}
			cur.next = cur.next.next;
		}

		return head;
	}

	// 删除中间结点
	// 方法2：当链表长度每增加2，要删除的结点就向后移一个节点
	public static P1_Node delet_mid2(P1_Node head) {
		if (head == null || head.next == null) {
			return head;
		}
		if (head.next.next == null) {
			return head.next;
		}
		P1_Node pre = head;// 要删除结点的前一个结点
		P1_Node cur = head.next.next;// 当前遍历到链表的哪一个结点

		while (cur.next != null && cur.next.next != null) {
			pre = pre.next;
			cur = cur.next.next;
		}
		pre.next = pre.next.next;
		return head;

	}

	// 删除a/b处的结点
	public static P1_Node delet_ab(P1_Node head, int a, int b) {
		if (a / b < 0 || a / b > 1 || head == null) {
			return head;
		}
		P1_Node cur = head;
		int n = 0;
		while (cur != null) {
			n++;
			cur = cur.next;
		}

		int k = (int) Math.ceil((double) (a * n) / (double) b);

		if (k == 1) {
			head = head.next;
		} else if (k > 1) {
			int i = 1;
			cur = head;
			while (i < k - 1) {
				cur = cur.next;
				i++;
			}
			cur.next = cur.next.next;
		}
		return head;
	}

	public static void main(String[] args) {
		P1_Node head = new P1_Node(1);
		head.next = new P1_Node(2);
		head.next.next = new P1_Node(3);
		head.next.next.next = new P1_Node(4);
		head.next.next.next.next = new P1_Node(5);
		head.next.next.next.next.next = new P1_Node(6);
		Utils.printLinkedList(head);

		head = delet_mid1(head);
		Utils.printLinkedList(head);
		head = delet_ab(head, 2, 5);
		Utils.printLinkedList(head);
		head = delet_ab(head, 1, 3);
		Utils.printLinkedList(head);
		head = delet_mid2(head);
		Utils.printLinkedList(head);
		head = delet_mid2(head);
		Utils.printLinkedList(head);
	}

}
