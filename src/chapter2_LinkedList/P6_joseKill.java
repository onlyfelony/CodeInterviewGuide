package chapter2_LinkedList;
/*
 * 环形单链表的约瑟夫问题：
 *    链表有n个结点，每次报到m的结点就删除
 *    进阶:要求时间复杂度O(n)
 */
public class P6_joseKill {
	
	//本题的关键就在于找到幸存结点当前编号和幸存结点在未删除m结点时编号的关系
	//由getNum(int i, int m)这个递归函数求得
	public static P1_Node joseP(P1_Node head,int m){
		
		if(head==null||head.next==head||m<1){
			return head;
			
		}
		//求链表中结点个数n (时间复杂度O(n))
		int n =1;P1_Node cur = head;
		while(cur.next!=head){
			n++;
			cur = cur.next;
		}
		//递归求解幸存结点初始编号 (时间复杂度O(n))
		int killNum = getNum(n,m);
		
		//遍历链表找到幸存结点
		int i =1;
		while(i<killNum){
			i++;
			head = head.next;
		}
		head.next = head;
	return head;	
		
	}
	
	
    //1.当前只有一个结点时,幸存结点编号为1
	//2.当前有i个结点时,幸存结点编号为getNum(i,m)
     //删除结点s之后，这个幸存结点编号变成了getNum(i-1,m) 
	//两者之间有递推关系
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
