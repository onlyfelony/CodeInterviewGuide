package chapter2_LinkedList;
/*
 * ���ε������Լɪ�����⣺
 *    ������n����㣬ÿ�α���m�Ľ���ɾ��
 *    ����:Ҫ��ʱ�临�Ӷ�O(n)
 */
public class P6_joseKill {
	
	//����Ĺؼ��������ҵ��Ҵ��㵱ǰ��ź��Ҵ�����δɾ��m���ʱ��ŵĹ�ϵ
	//��getNum(int i, int m)����ݹ麯�����
	public static P1_Node joseP(P1_Node head,int m){
		
		if(head==null||head.next==head||m<1){
			return head;
			
		}
		//�������н�����n (ʱ�临�Ӷ�O(n))
		int n =1;P1_Node cur = head;
		while(cur.next!=head){
			n++;
			cur = cur.next;
		}
		//�ݹ�����Ҵ����ʼ��� (ʱ�临�Ӷ�O(n))
		int killNum = getNum(n,m);
		
		//���������ҵ��Ҵ���
		int i =1;
		while(i<killNum){
			i++;
			head = head.next;
		}
		head.next = head;
	return head;	
		
	}
	
	
    //1.��ǰֻ��һ�����ʱ,�Ҵ�����Ϊ1
	//2.��ǰ��i�����ʱ,�Ҵ�����ΪgetNum(i,m)
     //ɾ�����s֮������Ҵ����ű����getNum(i-1,m) 
	//����֮���е��ƹ�ϵ
	public static int getNum(int i, int m) {
		if(i==1){
			return 1;
		}
		return (getNum(i-1,m)+m-1)%i+1;
	}



	public static void main(String[] args) {
		P1_Node head1 = new P1_Node(1);
		head1.next = new P1_Node(2);
		head1.next.next = new P1_Node(3);
		head1.next.next.next = new P1_Node(4);
		head1.next.next.next.next = new P1_Node(5);
		head1.next.next.next.next.next = head1;
		Utils.printCircularList(head1);
		head1 = joseP(head1, 3);
		Utils.printCircularList(head1);


	}

}
