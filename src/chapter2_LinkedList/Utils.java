package chapter2_LinkedList;
/*
 * ��ӡ����
 */
public class Utils {

	//��ӡ��������
	public static void printLinkedList(P1_Node head) {
		System.out.print("Linked List: ");
		while (head != null) {
			System.out.print(head.value + " ");
			head = head.next;
		}
		System.out.println();
	}
	
	//��ӡ˫������
	public static void printDoubleLinkedList(P2_DoubleNode head) {
		System.out.print("Double Linked List: ");
		P2_DoubleNode end = null;
		while (head != null) {
			System.out.print(head.value + " ");
			end = head;
			head = head.next;
		}
		System.out.print("| ");
		while (end != null) {
			System.out.print(end.value + " ");
			end = end.last;
		}
		System.out.println();
	}
	//��ӡ����������
	public static void printCircularList(P1_Node head) {
		if (head == null) {
			return;
		}
		System.out.print("Circular List: " + head.value + " ");
		P1_Node cur = head.next;
		while (cur != head) {
			System.out.print(cur.value + " ");
			cur = cur.next;
		}
		System.out.println("-> " + head.value);
	}
}
