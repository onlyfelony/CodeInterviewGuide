package chapter2_LinkedList;

/**
 * ������Ļ��ε�����(���һ������nextָ��ͷ���)�в����½ڵ��
 *
 */
public class P18_InsertNode {
	/*
	 * <<����num<head��num>β���>>
	 */
	public static P1_Node insertNum(P1_Node head, int num) {

		P1_Node neNode = new P1_Node(num);
		if (head == null) {
			neNode.next = neNode;
			return neNode;
		}
		P1_Node pre = head;

		while (pre.next != head) {
			if (pre.value <= num && pre.next.value >= num) {
				neNode.next = pre.next;
				pre.next = neNode;
				return head;
			}

			pre = pre.next;
		}

		neNode.next = head;
		pre.next = neNode;

		return (num < head.value) ? neNode : head;

	}

	public static void main(String[] args) {
		P1_Node head = null;
		head = insertNum(head, 2);
		Utils.printCircularList(head);

		head = insertNum(head, 1);
		Utils.printCircularList(head);

		head = insertNum(head, 4);
		Utils.printCircularList(head);

		head = insertNum(head, 3);
		Utils.printCircularList(head);

		head = insertNum(head, 5);
		Utils.printCircularList(head);

		head = insertNum(head, 0);
		Utils.printCircularList(head);
	}

}
