package Chapter1_Stack_Queue;

import java.util.LinkedList;

/*
 * ���ɴ������ֵ������
 *   ��Ŀ��
 *   ��һ����������arr��һ����СΪw�Ĵ��ڴ����������߻������ұߣ�����ÿ�����ұ߻���һ��λ��
 */
public class P7_WindowMax {
	
	public static int[] getWindowMax(int [] arr,int w){
		
		if(arr==null||w<1||arr.length<w){
			return null;
		}
		
		LinkedList<Integer> qmax = new LinkedList<Integer>();
		int res[] = new int[arr.length-w+1];
		
		for(int i=0;i<arr.length;i++){
			while(!qmax.isEmpty()&&(arr[qmax.peekLast()]<=arr[i])){
				qmax.pollLast();
				
			}
			qmax.addLast(i);
			
			if(qmax.peekFirst()==i-w){
				qmax.pollFirst();
			}
			
			if(i-w+1>=0){
				res[i-w+1]=arr[qmax.peekFirst()];
			}
			
		}
		
		
		
		return res;
	}
	
	public static void printArray(int[] arr) {
		for (int i = 0; i != arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
	

	public static void main(String[] args) {
		int[] arr = { 4, 3, 5, 4, 3, 3, 6, 7 };
		int w = 3;
		printArray(getWindowMax(arr, w));
	}

}
