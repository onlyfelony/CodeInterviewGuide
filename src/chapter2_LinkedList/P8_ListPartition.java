package chapter2_LinkedList;

/*
 * 将单向链表按某值划分成左边小、中间相等、右边大的形式
 *    进阶 :要求时间复杂度O(n) 空间复杂度O(1)☆☆
 */
public class P8_ListPartition {

	/*
	 * 方法二 :时间复杂度O(n) 空间复杂度O(1) <用几个变量划分成三个链表>
	 */

	public static P1_Node listPartition2(P1_Node head, int pivot) {
		// 把这个链表分成3部分:小于pivot，等于pivot，大于pivot
		// 每部分记录下头，尾
		P1_Node sHead = null;
		P1_Node sTail = null;
		P1_Node eHead = null;
		P1_Node eTail = null;
		P1_Node hHead = null;
		P1_Node hTail = null;

		P1_Node next = null;
		while (head != null) {
			next = head.next;
			head.next = null;// 把当前结点head变成单个结点

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

		// 将3个表合并
		if (sTail != null) {
			sTail.next = (eHead == null) ? hHead : eHead;
		}
		if (eTail != null) {
			eTail.next = hHead;
		}

		return (sHead != null) ? sHead : ((eHead != null) ? eHead : hHead);

	}

	/*
	 * 方法一 :时间复杂度O(n) 空间复杂度O(n) <将链表转换为数组，将数组划分为三区>
	 *  <<不能保证按照原来链表的顺序>>
	 */

	public static P1_Node listPartition1(P1_Node head, int pivot) {
		
		int i = 0;
		P1_Node cur = head;
		while(cur!=null){
			i++;
			cur = cur.next;
		}//遍历得到链表长度
		
		P1_Node arr[] = new P1_Node[i];
		cur = head;
		for(i = 0;i<arr.length;i++){
			arr[i]=cur;
			cur = cur.next;
		}//把链表放入数组
		
		arrPartition(arr,pivot);//划分数组
		
		for(i = 0;i<arr.length-1;i++){
			arr[i].next=arr[i+1];
		}
		arr[i].next = null;//将数组连接成链表
		
		return arr[0];
	}
	
	//将数组划分为三区 注意当right区扩大的时候i不变
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

	//交换数组中的两个元素
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
