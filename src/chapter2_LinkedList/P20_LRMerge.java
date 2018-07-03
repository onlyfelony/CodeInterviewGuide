package chapter2_LinkedList;
/**
 * 按照左右半区的方式重新组合单链表☆
 * N为奇数：左半区(N/2)右半区(N/2+1)
 *  时间复杂度O(N) 额外空间复杂度O(1) 
 *
 */
public class P20_LRMerge {

	/*
	 * 先遍历一遍找到中间结点，再组合
	 */
	public static P1_Node lrMerge(P1_Node head) {
		if(head==null||head.next==null){
			return head;
		}
		P1_Node cur = head.next;
		P1_Node mid  = head;
		while(cur.next!=null&&cur.next.next!=null){
			mid = mid.next;
			cur = cur.next.next;
		}//链表长度每增加2，mid向后移1
		
		P1_Node left = head;
		P1_Node right = mid.next;
		mid.next = null;
		
		while(left!=mid){
			P1_Node nleft = left.next;
			left.next = right;
			right = right.next;
			left.next.next = nleft;
			left = nleft;
		}
		left.next = right;
		return head;
		
		
	}
	
	
	public static void main(String[] args) {
		P1_Node head = null;
		lrMerge(head);
		Utils.printLinkedList(head);

		head = new P1_Node(1);
		lrMerge(head);
		Utils.printLinkedList(head);

		head = new P1_Node(1);
		head.next = new P1_Node(2);
		lrMerge(head);
		Utils.printLinkedList(head);

		head = new P1_Node(1);
		head.next = new P1_Node(2);
		head.next.next = new P1_Node(3);
		lrMerge(head);
		Utils.printLinkedList(head);

		head = new P1_Node(1);
		head.next = new P1_Node(2);
		head.next.next = new P1_Node(3);
		head.next.next.next = new P1_Node(4);
		lrMerge(head);
		Utils.printLinkedList(head);

		head = new P1_Node(1);
		head.next = new P1_Node(2);
		head.next.next = new P1_Node(3);
		head.next.next.next = new P1_Node(4);
		head.next.next.next.next = new P1_Node(5);
		lrMerge(head);
		Utils.printLinkedList(head);

		head = new P1_Node(1);
		head.next = new P1_Node(2);
		head.next.next = new P1_Node(3);
		head.next.next.next = new P1_Node(4);
		head.next.next.next.next = new P1_Node(5);
		head.next.next.next.next.next = new P1_Node(6);
		lrMerge(head);
		Utils.printLinkedList(head);

		head = new P1_Node(1);
		head.next = new P1_Node(2);
		head.next.next = new P1_Node(3);
		head.next.next.next = new P1_Node(4);
		head.next.next.next.next = new P1_Node(5);
		head.next.next.next.next.next = new P1_Node(6);
		head.next.next.next.next.next.next = new P1_Node(7);
		lrMerge(head);
		Utils.printLinkedList(head);
	}

}
