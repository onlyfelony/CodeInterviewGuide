package chapter2_LinkedList;

import java.util.HashMap;

/*
 * ���ƺ������ָ��ڵ������
 *   ���� :Ҫ��ʱ�临�Ӷ�O(n) �ռ临�Ӷ�O(1)���
 */
public class P9_CopyList {

	/*
	 * ����һ :ʱ�临�Ӷ�O(n) �ռ临�Ӷ�O(n) <��HashMap��ԭ�����������µ�������ӳ��>
	 */
	public static P9_Node copyListWithRand1(P9_Node head) {
		HashMap<P9_Node, P9_Node> map = new HashMap<P9_Node, P9_Node>();
		P9_Node cur = head;
		while (cur != null) {
			map.put(cur, new P9_Node(cur.value));
			cur = cur.next;
		}// ��ԭ������������µ�������ӳ��

		cur = head;
		while (cur != null) {
			map.get(cur).next = map.get(cur.next);
			map.get(cur).rand = map.get(cur.rand);
			cur = cur.next;
		}// �����µĽ���next��rand

		return map.get(head);

	}

	/*
	 * ������ :ʱ�临�Ӷ�O(n) �ռ临�Ӷ�O(1) <�Ѹ��ƵĽڵ����ԭ�����ĺ���>
	 */
	public static P9_Node copyListWithRand2(P9_Node head) {
		if (head == null) {
			return null;
		}

		P9_Node cur = head;
		while (cur != null) {
			P9_Node nCur = new P9_Node(cur.value);
			nCur.next = cur.next;
			cur.next = nCur;
			cur = cur.next.next;
		}// ���½ڵ����ԭ���ڵ�ĺ���

		cur = head;
		while (cur != null) {
			cur.next.rand = (cur.rand == null) ? null : cur.rand.next;
			cur = cur.next.next;
		}//�����½ڵ��rand

		
		P9_Node nHead = head.next;
		P9_Node nCur = nHead;
		cur = head;
		while(nCur.next!=null){
			cur.next = nCur.next;
			cur = cur.next;
			nCur.next = cur.next;
			nCur = nCur.next;
		}
		cur.next = nCur.next;//����������ֿ�
		
		return nHead;
	}

	public static void main(String[] args) {
		P9_Node head = null;
		P9_Node res1 = null;
		P9_Node res2 = null;
		Utils.printRandLinkedList(head);
		res1 = copyListWithRand1(head);
		Utils.printRandLinkedList(res1);
		res2 = copyListWithRand2(head);
		Utils.printRandLinkedList(res2);
		Utils.printRandLinkedList(head);
		System.out.println("=========================");

		head = new P9_Node(1);
		head.next = new P9_Node(2);
		head.next.next = new P9_Node(3);
		head.next.next.next = new P9_Node(4);
		head.next.next.next.next = new P9_Node(5);
		head.next.next.next.next.next = new P9_Node(6);

		head.rand = head.next.next.next.next.next; // 1 -> 6
		head.next.rand = head.next.next.next.next.next; // 2 -> 6
		head.next.next.rand = head.next.next.next.next; // 3 -> 5
		head.next.next.next.rand = head.next.next; // 4 -> 3
		head.next.next.next.next.rand = null; // 5 -> null
		head.next.next.next.next.next.rand = head.next.next.next; // 6 -> 4

		Utils.printRandLinkedList(head);
		res1 = copyListWithRand1(head);
		Utils.printRandLinkedList(res1);
		
		res2 = copyListWithRand2(head);
		Utils.printRandLinkedList(res2);
		Utils.printRandLinkedList(head);
		System.out.println("=========================");
	}

}
