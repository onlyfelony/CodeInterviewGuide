package chapter2_LinkedList;

/*
 * 打印两个有序链表的公共部分☆
 */
public class P1_Two_Linked_Common {

	static void print_Comm(P1_Node head1, P1_Node head2) {
		while (head1 != null && head2 != null) {
			if (head1.value < head2.value) {
				head1 = head1.next;
			} else if (head1.value == head2.value) {
				System.out.println(head1.value + " ");
				head1 = head1.next;
				head2 = head2.next;

			} else {
				head2 = head2.next;

			}
		}

	}

	public static void main(String[] args) {
		P1_Node node1 = new P1_Node(2);
		node1.next = new P1_Node(3);
		node1.next.next = new P1_Node(5);
		node1.next.next.next = new P1_Node(6);

		P1_Node node2 = new P1_Node(1);
		node2.next = new P1_Node(2);
		node2.next.next = new P1_Node(5);
		node2.next.next.next = new P1_Node(7);
		node2.next.next.next.next = new P1_Node(8);

		Utils.printLinkedList(node1);
		Utils.printLinkedList(node2);
		print_Comm(node1, node2);
	}

}
