package chapter2_LinkedList;

/**
 * ����һ����������ͷ���head��ʵ�ֵ������ѡ������� Ҫ�󣺶���ռ临�Ӷ�ΪO(1)
 */
public class P16_SelectedSort {

	public static P1_Node selectSort(P1_Node head) {
		if (head == null || head.next == null) {
			return head;
		}

		P1_Node left = head;// ���ź��򲿷�
		P1_Node pl = null;//leftǰ��һ�����
		P1_Node pre = null;// ��ǰ����ǰ��һ�����
		P1_Node mp = null;// ��С����ǰ��һ�����
		P1_Node cur = head;// ��ǰ���
		P1_Node min = left;// ��С���
		P1_Node nehead = null;// ��ͷ���

		while (left != null) {

			while (cur != null) {

				if (cur.value < min.value) {
					min = cur;
					mp = pre;
				}
				pre = cur;
				cur = cur.next;
			}

			if (mp != null) {
				mp.next = min.next;

				min.next = left;

			}
			if (nehead == null) {
				nehead = min;
			} else {
				pl.next = min;
			}
			pl = min;

			left = min.next;
			pre = min;
			cur = left;
			min = left;
			mp = null;

		}

		return nehead;

	}

	public static void main(String[] args) {
		P1_Node head = null;
		head = selectSort(head);
		Utils.printLinkedList(head);

		head = new P1_Node(1);
		head = selectSort(head);
		Utils.printLinkedList(head);

		head = new P1_Node(1);
		head.next = new P1_Node(2);
		head = selectSort(head);
		Utils.printLinkedList(head);

		head = new P1_Node(2);
		head.next = new P1_Node(1);
		head = selectSort(head);
		Utils.printLinkedList(head);

		head = new P1_Node(1);
		head.next = new P1_Node(2);
		head.next.next = new P1_Node(3);
		head = selectSort(head);
		Utils.printLinkedList(head);

		head = new P1_Node(1);
		head.next = new P1_Node(3);
		head.next.next = new P1_Node(2);
		head = selectSort(head);
		Utils.printLinkedList(head);

		head = new P1_Node(2);
		head.next = new P1_Node(1);
		head.next.next = new P1_Node(3);
		head = selectSort(head);
		Utils.printLinkedList(head);

		head = new P1_Node(2);
		head.next = new P1_Node(3);
		head.next.next = new P1_Node(1);
		head = selectSort(head);
		Utils.printLinkedList(head);

		head = new P1_Node(3);
		head.next = new P1_Node(1);
		head.next.next = new P1_Node(2);
		head = selectSort(head);
		Utils.printLinkedList(head);

		head = new P1_Node(3);
		head.next = new P1_Node(2);
		head.next.next = new P1_Node(1);
		head = selectSort(head);
		Utils.printLinkedList(head);

		head = new P1_Node(3);
		head.next = new P1_Node(1);
		head.next.next = new P1_Node(4);
		head.next.next.next = new P1_Node(2);
		head = selectSort(head);
		Utils.printLinkedList(head);
	}

}
