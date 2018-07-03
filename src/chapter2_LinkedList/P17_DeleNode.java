package chapter2_LinkedList;
/**
 * ����һ�������еĽ��node�������������������ͷ���� 
 * Ҫ��������ɾ��node������ʲô����
 *  Ҫ��ʱ�临�Ӷ�O(1)
 *
 */
public class P17_DeleNode {
/*
 * ����ɾ����������ɾ�����һ�����
 */
	public static void deletePartiNode(P1_Node node){
		if(node==null){
			return ;
		}
		
		if(node.next == null){
			throw new RuntimeException("cannot delete node");
		}
		
		node.value = node.next.value;
		node.next  = node.next.next;
		
	}
	
	
	
	public static void main(String[] args) {
		P1_Node head = new P1_Node(1);
		head.next = new P1_Node(2);
		head.next.next = new P1_Node(3);
		P1_Node node = head;
		Utils.printLinkedList(head);
		deletePartiNode(node);
		Utils.printLinkedList(head);

		head = new P1_Node(1);
		head.next = new P1_Node(2);
		head.next.next = new P1_Node(3);
		node = head.next;
		Utils.printLinkedList(head);
		deletePartiNode(node);
		Utils.printLinkedList(head);
		
		head = new P1_Node(1);
		head.next = new P1_Node(2);
		head.next.next = new P1_Node(3);
		node = head.next.next;
		Utils.printLinkedList(head);
		deletePartiNode(node);
		Utils.printLinkedList(head);
	}

}
