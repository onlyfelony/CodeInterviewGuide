package Chapter1_Stack_Queue;

import java.util.LinkedList;

/*
 * 最大值减去最小值小于或等于num的子数组数量☆☆☆
 */
public class P10_ArrSubNum {
	
	
	static int max_Sub_min(int arr[],int num){
		if(arr==null||num<0){
			return -1;
			
		}
		
		int total = 0;
		int sub = 0;
		int j = 0;
		LinkedList<Integer> qmax = new LinkedList<Integer>();
		LinkedList<Integer> qmin = new LinkedList<Integer>();
		
		for(int i = 0;i<arr.length;i++){
			
			while(j<arr.length){
				
				while(!qmax.isEmpty()&&arr[qmax.peekLast()]<=arr[j]){
					qmax.pollLast();
					
				}
				qmax.addLast(j);
				
				while(!qmin.isEmpty()&&arr[qmin.peekLast()]>=arr[j]){
					qmin.pollLast();
					
				}
				qmin.addLast(j);
				sub = arr[qmax.peekFirst()]-arr[qmin.peekFirst()];
				if(sub>num){
					break;
				}
				j++;
				
			}
			
				total+=j-i;
			
			if(qmax.peekFirst()==i){
				qmax.pollFirst();
			}
			
			if(qmin.peekFirst()==i){
				qmin.pollFirst();
			}
			
			
		}
		
		
	return	total;
	}
	

	public static void main(String[] args) {
		
		int[] arr = {5,6,8,2,1,3,5,0,2};
		int num = 5;
		System.out.println(max_Sub_min(arr, num));
	}

}
