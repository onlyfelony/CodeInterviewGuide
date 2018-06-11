package chapter2_LinkedList;

import java.util.HashSet;

/**
 * 
 * 删除无序单链表中值重复出现的节点☆
 *    方法一：时间复杂度O(N) 额外空间复杂度O(N)
 *    方法二：时间复杂度O(N^2) 额外空间复杂度O(1)
 */
public class P13_DeleteDuplicate {

	/*
	 * 方法一：<用哈希表>HashSet
	 */
	private static P1_Node deleteDup1(P1_Node head){
		if(head==null||head.next==null){
			return head;
		}
		P1_Node cur = head.next;
		P1_Node ncur = head;
		HashSet<Integer> set = new HashSet<Integer>();
		set.add(ncur.value);
		
		while(cur!=null){
			if(set.contains(cur.value)){
				ncur.next = cur.next;
				cur = ncur.next;
			}else{
				set.add(cur.value);
				ncur = cur;
				cur = cur.next;
			}
		}

		return head;
	}
	/*
	 * 方法二：<类似选择排序>
	 */

	private static P1_Node deleteDup2(P1_Node head){
		
		P1_Node ncur = head;
		P1_Node nnext = null;
		P1_Node pre  = null;
		int va;
		
		while(ncur!=null){
			va = ncur.value;
			nnext = ncur.next;
			pre = ncur;
			
			while(nnext!=null){
				if(va==nnext.value){
					pre.next = nnext.next;
					nnext = pre.next;
				}else{
					pre = pre.next;
					nnext = nnext.next;
				}
				
				
			}
			ncur = ncur.next;
		}
		return head;
	}
	
	
	
	
	public static void main(String[] args) {
		P1_Node head = new P1_Node(1);
		head.next = new P1_Node(2);
		head.next.next = new P1_Node(3);
		head.next.next.next = new P1_Node(3);
		head.next.next.next.next = new P1_Node(4);
		head.next.next.next.next.next = new P1_Node(4);
		head.next.next.next.next.next.next = new P1_Node(2);
		head.next.next.next.next.next.next.next = new P1_Node(1);
		head.next.next.next.next.next.next.next.next = new P1_Node(1);
		Utils.printLinkedList(head);
		deleteDup1(head);
		Utils.printLinkedList(head);
		System.out.println("=======================");
		head = new P1_Node(1);
		head.next = new P1_Node(1);
		head.next.next = new P1_Node(3);
		head.next.next.next = new P1_Node(3);
		head.next.next.next.next = new P1_Node(4);
		head.next.next.next.next.next = new P1_Node(4);
		head.next.next.next.next.next.next = new P1_Node(2);
		head.next.next.next.next.next.next.next = new P1_Node(1);
		head.next.next.next.next.next.next.next.next = new P1_Node(1);
		Utils.printLinkedList(head);
		deleteDup2(head);
		Utils.printLinkedList(head);
	}

}
