package chapter2_LinkedList;

/*
 * ����������ĳֵ���ֳ����С���м���ȡ��ұߴ����ʽ
 *    ���� :Ҫ��ʱ�临�Ӷ�O(n) �ռ临�Ӷ�O(1)���
 */
public class P8_ListPartition {

	/*
	 * ������ :ʱ�临�Ӷ�O(n) �ռ临�Ӷ�O(1) <�ü����������ֳ���������>
	 */

	public static P1_Node listPartition2(P1_Node head, int pivot) {
		// ���������ֳ�3����:С��pivot������pivot������pivot
		// ÿ���ּ�¼��ͷ��β
		P1_Node sHead = null;
		P1_Node sTail = null;
		P1_Node eHead = null;
		P1_Node eTail = null;
		P1_Node hHead = null;
		P1_Node hTail = null;

		P1_Node next = null;
		while (head != null) {
			next = head.next;
			head.next = null;// �ѵ�ǰ���head��ɵ������

			if (head.value < pivot) {
				if (sHead == null) {
					sHead = head;
					sTail = head;
				} else {
					sTail.next = head;
					sTail = head;
				}
			} else if (head.value == pivot) {
				if (eHead == null) {
					eHead = head;
					eTail = head;
				} else {
					eTail.next = head;
					eTail = head;
				}
			} else {
				if (hHead == null) {
					hHead = head;
					hTail = head;
				} else {
					hTail.next = head;
					hTail = head;
				}
			}
			head = next;
		}

		// ��3����ϲ�
		if (sTail != null) {
			sTail.next = (eHead == null) ? hHead : eHead;
		}
		if (eTail != null) {
			eTail.next = hHead;
		}

		return (sHead != null) ? sHead : ((eHead != null) ? eHead : hHead);

	}

	/*
	 * ����һ :ʱ�临�Ӷ�O(n) �ռ临�Ӷ�O(n) <������ת��Ϊ���飬�����黮��Ϊ����>
	 *  <<���ܱ�֤����ԭ�������˳��>>
	 */

	public static P1_Node listPartition1(P1_Node head, int pivot) {
		
		int i = 0;
		P1_Node cur = head;
		while(cur!=null){
			i++;
			cur = cur.next;
		}//�����õ�������
		
		P1_Node arr[] = new P1_Node[i];
		cur = head;
		for(i = 0;i<arr.length;i++){
			arr[i]=cur;
			cur = cur.next;
		}//�������������
		
		arrPartition(arr,pivot);//��������
		
		for(i = 0;i<arr.length-1;i++){
			arr[i].next=arr[i+1];
		}
		arr[i].next = null;//���������ӳ�����
		
		return arr[0];
	}
	
	//�����黮��Ϊ���� ע�⵱right�������ʱ��i����
	private static void arrPartition(P1_Node[] arr, int pivot) {
		int left = -1;
		int right = arr.length;
		int i=0;
		
		while(i!=right){
			if(arr[i].value<pivot){
				left++;
				swap(arr,left,i);
				i++;
			}else if(arr[i].value>pivot){
				right--;
				swap(arr,right,i);
			}else{
				i++;
			}
		}
	}

	//���������е�����Ԫ��
	private static void swap(P1_Node[] arr, int x, int y) {
		P1_Node temp = arr[x];
		arr[x] = arr[y];
		arr[y] = temp;
	}

	public static void main(String[] args) {
		P1_Node head1 = new P1_Node(7);
		head1.next = new P1_Node(9);
		head1.next.next = new P1_Node(1);
		head1.next.next.next = new P1_Node(8);
		head1.next.next.next.next = new P1_Node(5);
		head1.next.next.next.next.next = new P1_Node(2);
		head1.next.next.next.next.next.next = new P1_Node(5);
		Utils.printLinkedList(head1);
		 head1 = listPartition1(head1, 4);
		//head1 = listPartition2(head1, 5);
		Utils.printLinkedList(head1);
	}

}
