package chapter2_LinkedList;
/**
 * 给定一个链表中的结点node，但不给定整个链表的头结点☆ 
 * 要在链表中删除node，会有什么问题
 *  要求：时间复杂度O(1)
 *
 */
public class P17_DeleNode {
/*
 * 这种删除方法不能删除最后一个结点
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
