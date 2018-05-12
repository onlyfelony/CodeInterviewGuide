package chapter2_LinkedList;
/*
 * 在单链表和双链表中删除倒数第k个结点☆
 */
public class P2_DeleteK {
	
	//单链表删除
	public static P1_Node deleteK_single(P1_Node head,int k){
		if(head==null||k<1){
			return head;
		}
		
		P1_Node cur = head;
		int curK = k;
		
		while(cur!=null){
			curK--;
			cur =cur.next;
		}
		
		if(curK==0){
			head = head.next;
		}else if(curK<0){
			cur = head;
			while(curK<-1){
				cur = cur.next;
				curK++;
			}
			cur.next = cur.next.next;
		}
		
		
		return head;
	}
	
	//双链表删除
	public static P2_DoubleNode deleteK_double(P2_DoubleNode head,int k){
		if(head==null||k<1){
			return head;
		}
		
		P2_DoubleNode cur = head;
		int curK = k;
		
		while(cur!=null){
			curK--;
			cur =cur.next;
		}
		
		if(curK==0){
			head = head.next;
			head.last = null;
		}else if(curK<0){
			cur = head;
			while(curK<-1){
				cur = cur.next;
				curK++;
			}
			
			cur.next = cur.next.next;
			if(cur.next!=null){
			cur.next.last = cur;
			}
		}
		
		
		return head;
	}
	

	public static void main(String[] args) {
		P1_Node head1 = new P1_Node(1);
		head1.next = new P1_Node(2);
		head1.next.next = new P1_Node(3);
		head1.next.next.next = new P1_Node(4);
		head1.next.next.next.next = new P1_Node(5);
		head1.next.next.next.next.next = new P1_Node(6);
		Utils.printLinkedList(head1);
		head1 = deleteK_single(head1, 3);
		Utils.printLinkedList(head1);
		
		P2_DoubleNode head2 = new P2_DoubleNode(1);
		head2.next = new P2_DoubleNode(2);
		head2.next.last = head2;
		head2.next.next = new P2_DoubleNode(3);
		head2.next.next.last = head2.next;
		head2.next.next.next = new P2_DoubleNode(4);
		head2.next.next.next.last = head2.next.next;
		head2.next.next.next.next = new P2_DoubleNode(5);
		head2.next.next.next.next.last = head2.next.next.next;
		head2.next.next.next.next.next = new P2_DoubleNode(6);
		head2.next.next.next.next.next.last = head2.next.next.next.next;
		Utils.printDoubleLinkedList(head2);
		head2 = deleteK_double(head2, 3);
		Utils.printDoubleLinkedList(head2);

	}
	}


