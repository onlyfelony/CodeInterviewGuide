package Chapter1_Stack_Queue;

import java.util.Stack;

/*
 * 用两个栈实现队列(add,poll,peek) ☆☆
 */
public class P2_StackToQueue {

	public static class MyQueue {
		private Stack<Integer> stackPush;
		private Stack<Integer> stackPop;

		public MyQueue() {
			stackPush = new Stack<Integer>();
			stackPop = new Stack<Integer>();

		}

		public void add(int num) {
			stackPush.push(num);

		}

		public int poll() {

			sameCode();
			return stackPop.pop();

		}

		public int peek() {
			
			sameCode();
			return stackPop.peek();

		}
		
		
		
		public void sameCode(){
			
			if (stackPop.isEmpty()) {
				if (stackPush.isEmpty()) {
					throw new RuntimeException("You Queue is Empty!");
				} else {
					while (!stackPush.isEmpty()) {
						stackPop.push(stackPush.pop());
					}
				}

			}
			
		}

	}

	public static void main(String[] args) {

		
		MyQueue test = new MyQueue();
		test.add(1);
		test.add(2);
		test.add(3);
		System.out.println(test.peek());//1
		System.out.println(test.poll());//1
		System.out.println(test.peek());//2
		System.out.println(test.poll());//2
		test.add(0);
		System.out.println(test.peek());//3
		System.out.println(test.poll());//3
		System.out.println(test.peek());//0
		System.out.println(test.poll());//0
	}

}
