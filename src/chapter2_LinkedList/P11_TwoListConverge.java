package chapter2_LinkedList;

/*
 * 两个单链表相交的一系列问题 ☆☆☆☆
 *   问题一：如何判断一个链表是否有环，如果有，则返回第一个进入环的结点，没有则返回null4
 *   问题二：如何判断两个无环链表是否相交，相交则返回第一个相交结点，不相交则返回null
 *   问题三：如何判断两个有环链表是否相交，相交则返回第一个相交结点，不相交则返回null
 */
public class P11_TwoListConverge {

	/*
	 * 问题一：<用两个指针f,s>
	 */
	public static P1_Node haveCircle(P1_Node head) {
		P1_Node f = head;
		P1_Node s = head;

		while (f != null) {
			if (f.next != null) {
				f = f.next.next;// f指针每次走两步
			} else {
				return null;
			}

			s = s.next;// s指针每次走一步
			if (s == f) {
				break;// 第一次重合的时候停止
			}

		}

		if (f == null) {
			return null;
		} else {
			f = head;// 令f从头结点开始
		}

		while (f != s) {
			f = f.next;
			s = s.next;// f,s都只移动1步
		}

		return f;// 第二次重合的时候就是环的第一个结点
	}

	/*
	 * 问题二：<比较两个链表的长度，让长链表先走len1 - len2>
	 */
	public static P1_Node NoCircleConvert(P1_Node head1, P1_Node head2) {
		if (head1 == null || head2 == null) {
			return null;
		}

		int len1 = 1;
		int len2 = 1;// 记录链表长度
		P1_Node tail1 = head1;
		P1_Node tail2 = head2;

		while (tail1.next != null) {
			len1++;
			tail1 = tail1.next;
		}

		while (tail2.next != null) {
			len2++;
			tail2 = tail2.next;
		}
		if (tail1 != tail2) {
			return null;
		}
		tail1 = (len1 > len2) ? head1 : head2;// 指向长链表的头结点
		tail2 = (tail1 == head1) ? head2 : head1;
		int ls = Math.abs(len1 - len2);
		int t = 0;
		while (tail1 != tail2) {
			if (t >= ls) {
				tail2 = tail2.next;
			}
			tail1 = tail1.next;
			t++;
		}

		return tail1;
	}

	/*
	 * 问题三：<两种情况 (1)loop1=loop2 考虑它们在进入环之前相交<<和问题二类似>> (2)loop1!=loop2
	 * 让loop1走一圈,在重新回到loop1之前看有没有和loop2相遇 >
	 * %loop1:head1进入环的第一个结点，即问题一haveCircle(head1) (loop2类似)
	 */

	public static P1_Node CircleConvert(P1_Node head1, P1_Node loop1,
			P1_Node head2, P1_Node loop2) {
		if (loop1 == loop2) {
			int n = 0;
			P1_Node cur1 = head1;
			P1_Node cur2 = head2;
			while (cur1 != loop1) {
				n++;
				cur1 = cur1.next;
			}

			while (cur2 != loop2) {
				n--;
				cur2 = cur2.next;
			}
			cur1 = n > 0 ? head1 : head2;
			cur2 = (cur1 == head1) ? head2 : head1;
			n = Math.abs(n);
			while (n > 0) {
				cur1 = cur1.next;
				n--;
			}

			while (cur1 != cur2) {
				cur1 = cur1.next;
				cur2 = cur2.next;
			}
			return cur1;
		} else {

			P1_Node mark = loop1;
			loop1 = loop1.next;
			while (loop1 != mark) {
				if (loop1 == loop2) {
					return loop1;
				}
				loop1 = loop1.next;
			}
			return null;
		}

	}
	
	//整合三个ziwent
	public static P1_Node allComp(P1_Node head1,P1_Node head2){
		P1_Node loop1 = haveCircle(head1);
		P1_Node loop2 = haveCircle(head2);
		
		if(loop1==null&&loop2==null){
			return NoCircleConvert(head1,head2);
			
		}else if(loop1!=null&&loop2!=null){
			return CircleConvert(head1,loop1,head2,loop2);
		}
		return null;
		
	}

	public static void main(String[] args) {

/*		// 测试haveCircle(),NoCircleConvert()
		P1_Node head = new P1_Node(0);
		P1_Node n1 = new P1_Node(1);
		P1_Node n2 = new P1_Node(2);
		P1_Node n3 = new P1_Node(3);
		P1_Node n4 = null;
		head.next = n1;
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		P1_Node n5 = new P1_Node(5);
		n5.next = n2;
		P1_Node head2 = n5;
		// P1_Node test1 = haveCircle(head);
		P1_Node test2 = NoCircleConvert(head, head2);
		if (test2 != null) {
			System.out.println(test2.value);
		} else {
			System.out.println("null");
		}*/
		
		
		// 1->2->3->4->5->6->7->null
				P1_Node head1 = new P1_Node(1);
				head1.next = new P1_Node(2);
				head1.next.next = new P1_Node(3);
				head1.next.next.next = new P1_Node(4);
				head1.next.next.next.next = new P1_Node(5);
				head1.next.next.next.next.next = new P1_Node(6);
				head1.next.next.next.next.next.next = new P1_Node(7);

				// 0->9->8->6->7->null
				P1_Node head2 = new P1_Node(0);
				head2.next = new P1_Node(9);
				head2.next.next = new P1_Node(8);
				head2.next.next.next = head1.next.next.next.next.next; // 8->6
				System.out.println(allComp(head1, head2).value);

				// 1->2->3->4->5->6->7->4...
				head1 = new P1_Node(1);
				head1.next = new P1_Node(2);
				head1.next.next = new P1_Node(3);
				head1.next.next.next = new P1_Node(4);
				head1.next.next.next.next = new P1_Node(5);
				head1.next.next.next.next.next = new P1_Node(6);
				head1.next.next.next.next.next.next = new P1_Node(7);
				head1.next.next.next.next.next.next = head1.next.next.next; // 7->4

				// 0->9->8->2...
				head2 = new P1_Node(0);
				head2.next = new P1_Node(9);
				head2.next.next = new P1_Node(8);
				head2.next.next.next = head1.next; // 8->2
				System.out.println(allComp(head1, head2).value);

				// 0->9->8->6->4->5->6..
				head2 = new P1_Node(0);
				head2.next = new P1_Node(9);
				head2.next.next = new P1_Node(8);
				head2.next.next.next = head1.next.next.next.next.next; // 8->6
				System.out.println(allComp(head1, head2).value);

	}

}
