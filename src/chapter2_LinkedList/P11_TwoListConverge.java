package chapter2_LinkedList;
/*
 * �����������ཻ��һϵ������ �����
 *   ����һ������ж�һ�������Ƿ��л�������У��򷵻ص�һ�����뻷�Ľ�㣬û���򷵻�null4
 *   �����������ж������޻������Ƿ��ཻ���ཻ�򷵻ص�һ���ཻ��㣬���ཻ�򷵻�null
 *   ������������ж������л������Ƿ��ཻ���ཻ�򷵻ص�һ���ཻ��㣬���ཻ�򷵻�null
 */
public class P11_TwoListConverge {

	/*
	 * ����һ��<������ָ��f,s>
	 */
	public static P1_Node haveCircle(P1_Node head){
		P1_Node f = head;
		P1_Node s = head;
		
		while(f!=null){
			if(f.next!=null){
				f = f.next.next;//fָ��ÿ��������
			}else{
				return null;
			}
			
			s = s.next;//sָ��ÿ����һ��
			if(s==f){
				break;//��һ���غϵ�ʱ��ֹͣ
			}
			
		}
		
		if(f==null){
			return null;
		}else{
			f = head;//��f��ͷ��㿪ʼ
		}
		
		while(f!=s){
			f = f.next;
			s = s.next;//f,s��ֻ�ƶ�1��
		}
		
		return f;//�ڶ����غϵ�ʱ����ǻ��ĵ�һ�����
	}
	/*
	 * �������<�Ƚ���������ĳ��ȣ��ó���������len1 - len2>
	 */
	public static P1_Node NoCircleConvert(P1_Node head1,P1_Node head2){
		if(head1==null||head2==null){
			return null;
		}
		
		int len1 = 1;
		int len2 = 1;//��¼������
		P1_Node tail1 = head1;
		P1_Node tail2 = head2;
		
		while(tail1.next!=null){
			len1++;
			tail1 = tail1.next;
		}
		
		while(tail2.next!=null){
			len2++;
			tail2 = tail2.next;
		}
		if(tail1!=tail2){
			return null;
		}
		tail1 = (len1>len2)?head1:head2;//ָ�������ͷ���
		tail2 = (tail1==head1)?head2:head1;
		int ls = Math.abs(len1-len2);
		int t = 0;
		while(tail1!=tail2){
			if(t>=ls){
				tail2 = tail2.next;
			}
			tail1 = tail1.next; t++;
		}
		
		return tail1;
	}
	
	public static void main(String[] args) {
		
		//����haveCircle(),NoCircleConvert()
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
		//P1_Node test1 = haveCircle(head);
		P1_Node test2 = NoCircleConvert(head,head2);
		if(test2!=null){
			System.out.println(test2.value);
		}else{
			System.out.println("null");
		}

	}

}
