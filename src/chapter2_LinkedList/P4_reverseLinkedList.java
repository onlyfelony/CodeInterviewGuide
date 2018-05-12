package chapter2_LinkedList;

/*
 * 反转单向和双向链表☆
 * 要求：
 *   链表长度为N，时间复杂度为O(N),额外空间复杂度为O(1)
 */
public class P4_reverseLinkedList {

	// 反转单向链表
	public static P1_Node reverse_single(P1_Node head) {
		if (head == null || head.next == null) {
			return head;
		}

		P1_Node pre = head;
		P1_Node cur = head.next;
		P1_Node last = cur;
		head.next =null;
		while (cur != null) {
			last = last.next;
			cur.next = pre;
			pre = cur;
			cur = last;
		}

		return pre;

	}
	
	//反转双向链表
	public static P2_DoubleNode reverse_double(P2_DoubleNode head){
		if(head==null||head.next==null){
			return head;
		}
		
		P2_DoubleNode pre = head;
		P2_DoubleNode cur = head.next;
		P2_DoubleNode after = cur;
		head.last = cur;
		head.next = null;
		
		while(cur!=null){
			after = after.next;
			cur.last = after;
			cur.next = pre;
			pre = cur;
			cur = after;
		}
		return pre;
	}


	
	
	public static void main(String[] args) {

		P1_Node head1 = new P1_Node(1);
		head1.next = new P1_Node(2);
		head1.next.next = new P1_Node(3);
		Utils.printLinkedList(head1);
		head1 = reverse_single(head1);
		Utils.printLinkedList(head1);
		
		
		P2_DoubleNode head2 = new P2_DoubleNode(1);
		head2.next = new P2_DoubleNode(2);
		head2.next.last = head2;
		head2.next.next = new P2_DoubleNode(3);
		head2.next.next.last = head2.next;
		head2.next.next.next = new P2_DoubleNode(4);
		head2.next.next.next.last = head2.next.next;
		Utils.printDoubleLinkedList(head2);
		Utils.printDoubleLinkedList(reverse_double(head2));

	}

}
