package Chapter1_Stack_Queue;

import java.util.Stack;

/*
 * 用栈来求解汉诺塔问题☆☆☆
 */
public class P6_Hanoi {

	// 方法一：递归求解
	public static int moveHanoi1(int num, String left, String mid,
			String right, String from, String to) {
		if (num < 1) {
			throw new RuntimeException("You Hanoi is error!");
		} else if (num == 1) {
			if (from.equals(mid) || to.equals(mid)) {
				System.out.println("Move " + num + " from " + from + " to "
						+ to);
				return 1;
			} else {
				System.out.println("Move " + num + " from " + from + " to "
						+ mid);
				System.out
						.println("Move " + num + " from " + mid + " to " + to);
				return 2;
			}

		} else {
			// 当塔的层数超过1的时候

			if (from.equals(mid) || to.equals(mid)) {
				String another = (from.equals(left) || to.equals(left)) ? right
						: left;

				int step1 = moveHanoi1(num - 1, left, mid, right, from, another);
				int step2 = 1;
				System.out.println("Move " + num + " from " + from + " to "
						+ to);
				int step3 = moveHanoi1(num - 1, left, mid, right, another, to);

				return step1 + step2 + step3;
			} else {
				int step1 = moveHanoi1(num - 1, left, mid, right, from, to);
				int step2 = 1;
				System.out.println("Move " + num + " from " + from + " to "
						+ mid);
				int step3 = moveHanoi1(num - 1, left, mid, right, to, from);
				int step4 = 1;
				System.out
						.println("Move " + num + " from " + mid + " to " + to);
				int step5 = moveHanoi1(num - 1, left, mid, right, from, to);

				return step1 + step2 + step3 + step4 + step5;

			}

		}

	}

	// 用栈实现
	public static int moveHanoi2(int num, String left, String mid, String right) {
		final String TYPE1 = "LtoM";
		final String TYPE2 = "MtoR";
		final String TYPE3 = "RtoM";
		final String TYPE4 = "MtoL";
		boolean isStart = true;//标记是否是第一步
		int reCord = num;//记录num，因为后面num会--

		Stack<Integer> stackL = new Stack<Integer>();
		stackL.push(Integer.MAX_VALUE);
		Stack<Integer> stackM = new Stack<Integer>();
		stackM.push(Integer.MAX_VALUE);
		Stack<Integer> stackR = new Stack<Integer>();
		stackR.push(Integer.MAX_VALUE);

		int step = 0;
		String preType = TYPE1;

		while (num > 0) {
			stackL.push(num--);
		}

		// 先做第一步
		stackM.push(stackL.pop());
		step++;
		System.out.println("Move " + stackM.peek() + " from " + left + " to "
				+ mid);

		while (isStart || (stackR.size() != reCord + 1)) {
		
			isStart = false;
			switch (preType) {

			case TYPE1:
				boolean result1 =action(stackM,stackR,mid,right);
				if(result1){
					preType = TYPE2;
				}else{
					preType = TYPE3;
				}
			/*	if (stackM.peek() < stackR.peek()) {
					preType = TYPE2;
					stackR.push(stackM.pop());
					System.out.println("Move " + stackR.peek() + " from " + mid
							+ " to " + right);
				} else {
					preType = TYPE3;
					stackM.push(stackR.pop());
					System.out.println("Move " + stackM.peek() + " from "
							+ right + " to " + mid);
				}*/
				break;
			case TYPE2:
/*				if (stackM.peek() < stackL.peek()) {
					preType = TYPE4;
					stackL.push(stackM.pop());
					System.out.println("Move " + stackL.peek() + " from " + mid
							+ " to " + left);
				} else {
					preType = TYPE1;
					stackM.push(stackL.pop());
					System.out.println("Move " + stackM.peek() + " from "
							+ left + " to " + mid);
				}*/
				boolean result2 =action(stackM,stackL,mid,left);
				if(result2){
					preType = TYPE4;
				}else{
					preType = TYPE1;
				}

				break;
			case TYPE3:
				boolean result3 =action(stackM,stackL,mid,left);
				if(result3){
					preType = TYPE4;
				}else{
					preType = TYPE1;
				}
				
				/*if (stackM.peek() < stackL.peek()) {
					preType = TYPE4;
					stackL.push(stackM.pop());
					System.out.println("Move " + stackL.peek() + " from " + mid
							+ " to " + left);
				} else {
					preType = TYPE1;
					stackM.push(stackL.pop());
					System.out.println("Move " + stackM.peek() + " from "
							+ left + " to " + mid);
				}*/
				break;
			case TYPE4:
				boolean result4 =action(stackM,stackR,mid,right);
				if(result4){
					preType = TYPE2;
				}else{
					preType = TYPE3;
				}
				
				
/*				if (stackM.peek() < stackR.peek()) {
					preType = TYPE2;
					stackR.push(stackM.pop());
					System.out.println("Move " + stackR.peek() + " from " + mid
							+ " to " + right);
				} else {
					preType = TYPE3;
					stackM.push(stackR.pop());
					System.out.println("Move " + stackM.peek() + " from "
							+ right + " to " + mid);
				}*/
				break;
			}
			step++;
		}

		return step;
	}

	
	public static boolean action(Stack<Integer> fS,Stack<Integer> tS,String from,String to){
		//返回true表示从from->to
		if (fS.peek() < tS.peek()) {
			//preType = TYPE2;
			tS.push(fS.pop());
			System.out.println("Move " + tS.peek() + " from " + from
					+ " to " + to);
			
			return true;
		} else {
			//preType = TYPE3;
			fS.push(tS.pop());
			System.out.println("Move " + fS.peek() + " from "
					+ to + " to " + from);
			return false;
		}
		
		
		
	}


	public static void main(String[] args) {
		int num = 3;

		// solution 1
		int steps1 = moveHanoi1(num, "left", "mid", "right", "left", "right");
		System.out.println("It will move " + steps1 + " steps.");
		System.out.println("===================================");
		int steps2 = moveHanoi2(num, "left", "mid", "right");
		System.out.println("It will move " + steps2 + " steps.");

	}

}
