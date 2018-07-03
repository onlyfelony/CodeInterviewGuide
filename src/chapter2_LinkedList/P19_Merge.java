package chapter2_LinkedList;

/**
 * 合并两个有序的单链表☆
 *
 */
public class P19_Merge {

	public static P1_Node mergeTwo(P1_Node head1, P1_Node head2) {
		if (head1 == null || head2 == null) {
			return head1 == null ? head2 : head1;
		}

		P1_Node nehead = (head1.value <= head2.value) ? head1 : head2;
		P1_Node pre = nehead;
		P1_Node cur1 = nehead;
		P1_Node cur2 = (nehead == head1) ? head2 : head1;

		while (cur1 != null && cur2 != null) {
			if (cur1.value <= cur2.value) {
				pre = cur1;
				cur1 = cur1.next;
			} else {
				pre.next = cur2;
				cur2 = cur2.next;
				pre.next.next = cur1;
				pre = pre.next;
			}
		}

		if (cur1 == null) {
			pre.next = cur2;
		}
		return nehead;
	}

	public static void main(String[] args) {
		P1_Node head1 = null;
		P1_Node head2 = null;
		P1_Node head = mergeTwo(head1, head2);
		Utils.printLinkedList(head);

		head1 = new P1_Node(1);
		head2 = null;
		head = mergeTwo(head1, head2);
		Utils.printLinkedList(head);

		head1 = null;
		head2 = new P1_Node(1);
		head = mergeTwo(head1, head2);
		Utils.printLinkedList(head);

		head1 = new P1_Node(1);
		head2 = new P1_Node(2);
		head = mergeTwo(head1, head2);
		Utils.printLinkedList(head);

		head1 = new P1_Node(2);
		head2 = new P1_Node(1);
		head = mergeTwo(head1, head2);
		Utils.printLinkedList(head);

		head1 = new P1_Node(1);
		head1.next = new P1_Node(4);
		head2 = new P1_Node(2);
		head2.next = new P1_Node(3);
		head2.next.next = new P1_Node(5);
		head = mergeTwo(head1, head2);
		Utils.printLinkedList(head);

		head1 = new P1_Node(1);
		head1.next = new P1_Node(3);
		head1.next.next = new P1_Node(5);
		head1.next.next.next = new P1_Node(7);
		head1.next.next.next.next = new P1_Node(9);
		head2 = new P1_Node(0);
		head2.next = new P1_Node(6);
		head2.next.next = new P1_Node(6);
		head2.next.next.next = new P1_Node(7);
		head = mergeTwo(head1, head2);
		Utils.printLinkedList(head);
	}

}
