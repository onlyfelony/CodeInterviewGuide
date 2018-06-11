package chapter2_LinkedList;
/**
 * �ڵ�������ɾ��ָ��ֵ�Ľڵ�
 */
public class P14_DeleteNum {
	
	/*
	 * ʱ�临�Ӷ�O(N) ����ռ临�Ӷ�O(1)
	 */
	private static P1_Node deleteNum(P1_Node head,int num){

		P1_Node cur = head;
		P1_Node nehead = null;
		P1_Node pre = null;
		
		while(cur!=null){
			if(cur.value==num){
				if(pre!=null){
					pre.next = cur.next;
				}
				
			}else{
				nehead = (nehead==null)?cur:nehead;
				pre = cur;
			}
			cur = cur.next;
		}
		
		return nehead;
		
	}

	public static void main(String[] args) {
		P1_Node head = new P1_Node(1);
		head.next = new P1_Node(1);
		head.next.next = new P1_Node(3);
		head.next.next.next = new P1_Node(3);
		head.next.next.next.next = new P1_Node(1);
		head.next.next.next.next.next = new P1_Node(2);
		head.next.next.next.next.next.next = new P1_Node(1);
		head.next.next.next.next.next.next.next = new P1_Node(1);
		Utils.printLinkedList(head);
		head = deleteNum(head, 1);
		Utils.printLinkedList(head);

		
	}

}
