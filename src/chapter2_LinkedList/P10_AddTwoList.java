package chapter2_LinkedList;

import java.util.Stack;

/*
 * 两个单链表生成相加链表☆
 *   <<Tip:关于reverseList()传入的对象形参问题>>
 */
public class P10_AddTwoList {
	/*
	 * <栈>
	 */
	public static P1_Node addlists1(P1_Node head1, P1_Node head2) {
		Stack<Integer> num1 = new Stack<>();
		Stack<Integer> num2 = new Stack<>();

		pushToNum(num1, head1);// 把两个链表的value压入栈
		pushToNum(num2, head2);
		int jn = 0;// 进位
		P1_Node cNext = null;
		P1_Node cHead = null;

		while (!num1.isEmpty() || !num2.isEmpty()) {

			int n1 = num1.isEmpty()?0:num1.pop();
			int n2 = num2.isEmpty()?0:num2.pop();
			int res = n1 + n2 + jn;
			jn = res / 10;
			res = res % 10;

			cNext = new P1_Node(res);// 生成新节点
			cNext.next = cHead;
			cHead = cNext;

		}

		if (jn > 0) {
			cNext = new P1_Node(jn);
			cNext.next = cHead;
		}
		return cNext;
	}

	private static void pushToNum(Stack<Integer> num, P1_Node head) {

		P1_Node cur = head;
		while (cur != null) {
			num.push(cur.value);
			cur = cur.next;
		}

	}
	/*
	 * <用链表，省去栈的空间>
	 */
	
	public static P1_Node addlists2(P1_Node head1, P1_Node head2) {
		head1 = reverseList(head1);
		head2 = reverseList(head2);
		
		P1_Node cur1 = head1;
		P1_Node cur2 = head2;
		
		int n1 = 0;
		int n2 = 0;
		int jn = 0;//进位
		int res = 0;
		
		P1_Node cNext = null;
		P1_Node cHead = null;
		
		while(cur1!=null||cur2!=null){
			n1 = (cur1==null)?0:cur1.value;
			n2 = (cur2==null)?0:cur2.value;
			
			res = n1 + n2 + jn;
			jn = res/10;
			res = res%10;
			
			cNext = new P1_Node(res);
			cNext.next = cHead;
			cHead = cNext;
			
			cur1 = (cur1==null)?null:cur1.next;
			cur2 = (cur2==null)?null:cur2.next;
		}
		
		if (jn > 0) {
			cNext = new P1_Node(jn);
			cNext.next = cHead;
		}
		
		head1 = reverseList(head1);
		head2 = reverseList(head2);
		return cNext;
		
	}

	//逆序链表
	private static P1_Node reverseList(P1_Node head) {
		if(head==null||head.next==null){
			return head ;
		}
		P1_Node l = head;
		P1_Node cur = head.next;
		P1_Node r = null;
		l.next = null;
		while(cur!=null){
			r = cur.next;
			cur.next = l;
			l = cur;
			cur = r;
			
		}
		return l;
	}

	public static void main(String[] args) {
		P1_Node head1 = new P1_Node(9);
		head1.next = new P1_Node(9);
		head1.next.next = new P1_Node(9);

		P1_Node head2 = new P1_Node(1);
		//reverseList(head1);
		//Utils.printLinkedList(head1);

		Utils.printLinkedList(head1);
		Utils.printLinkedList(head2);
		Utils.printLinkedList(addlists1(head1, head2));
		Utils.printLinkedList(addlists2(head1, head2));
	}

}
