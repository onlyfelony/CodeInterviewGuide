package chapter2_LinkedList;
/*
 * 反转部分单向链表☆
 */
public class P5_reverse_partLinked {
	
	public static P1_Node reverse(P1_Node head,int from,int to){
		
		if(from>=to||from<1||head==null){
			return head;
		}
		
		int i = 1;
		P1_Node lh = head;
		
		while(i<from-1){
			i++;
			lh = lh.next;
		}
		P1_Node pre;
		if(from!=1){
			pre = lh.next;i++;
		}else{
			pre = lh;
		}
		
		P1_Node cur = pre.next;
		P1_Node after = cur;
		pre.next = null;
		
		while(i<to){
			i++;
			after = after.next;
			cur.next = pre;
			pre = cur;
			cur = after;
		}
		
		if(from!=1){
			lh.next.next = cur;
			lh.next = pre;
			return lh;
		}else{
			lh.next = cur;
			return pre;
		}
		
	}
	



	public static void main(String[] args) {
		P1_Node head = null;
		Utils.printLinkedList(head);
		head = reverse(head, 1, 1);
		Utils.printLinkedList(head);

		head = new P1_Node(1);
		Utils.printLinkedList(head);
		head = reverse(head, 1, 1);
		Utils.printLinkedList(head);
		
		head = new P1_Node(1);
		head.next = new P1_Node(2);
		Utils.printLinkedList(head);
		head = reverse(head, 1, 2);
		Utils.printLinkedList(head);
		
		head = new P1_Node(1);
		head.next = new P1_Node(2);
		head.next.next = new P1_Node(3);
		Utils.printLinkedList(head);
		head = reverse(head, 2, 3);
		Utils.printLinkedList(head);
		
		head = new P1_Node(1);
		head.next = new P1_Node(2);
		head.next.next = new P1_Node(3);
		Utils.printLinkedList(head);
		head = reverse(head, 1, 3);
		Utils.printLinkedList(head);
	}

}
