package Chapter1_Stack_Queue;

import java.util.Stack;

/*
 * 设计一个有getMin功能的栈☆
 * 要求：
 *   1.pop,push,getMin操作的时间复杂度都是O(1)
 *   2.设计的栈可以用现成的栈结构
 */
public class P1_getMin {

	// 第一种方法
	public static class MyStack1 {
		private Stack<Integer> stackData;// 数据栈
		private Stack<Integer> stackMin;// 放每一步最小值的栈
		
		

		public MyStack1() {
			this.stackData = new Stack<Integer>();
			this.stackMin = new Stack<Integer>();
		}

		public void push(int num) {
			stackData.push(num);
			if (stackMin.isEmpty()) {
				stackMin.push(num);

			} else if (num <= stackMin.peek()) {
				// 小于等于是因为如果有重复的当前最小值压栈，对应之后出栈的逻辑
				stackMin.push(num);

			}
		}

		public int pop() {

			if (stackData.isEmpty()) {
				throw new RuntimeException("You Stack is Empty!");
			} else {
				int num = stackData.pop();
				if (num == stackMin.peek()) {
					stackMin.pop();
				}

				return num;
			}
		}

		public int getMin() {

			if (stackMin.isEmpty()) {
				throw new RuntimeException("You Stack is Empty!");
			} else {
				return stackMin.peek();
			}

		}

	}

	// 第二种方法
	public static class MyStack2 {
		private Stack<Integer> stackData;// 数据栈
		private Stack<Integer> stackMin;// 放每一步最小值的栈

		public MyStack2() {
			this.stackData = new Stack<Integer>();
			this.stackMin = new Stack<Integer>();
		}
/*
 * 		public void push(int newNum) {
			if (this.stackMin.isEmpty()) {
				this.stackMin.push(newNum);
			} else if (newNum < this.getmin()) {
				this.stackMin.push(newNum);
			} else {
				int newMin = this.stackMin.peek();
				this.stackMin.push(newMin);
			}
			this.stackData.push(newNum);
		}
 * 
 * 
 * 
 * 
 * */

		public void push(int num) {
			stackData.push(num);
			if (stackMin.isEmpty()) {
				stackMin.push(num);

			} else if (num <=stackMin.peek()) {
				// 小于等于是因为如果有重复的当前最小值压栈，对应之后出栈的逻辑
				stackMin.push(num);

			} else {
				// 把当前最小值重复压栈
				stackMin.push(stackMin.peek());
			}
		}

		public int pop() {

			if (stackData.isEmpty()) {
				throw new RuntimeException("You Stack is Empty!");
			} else {

				stackMin.pop();//同步出栈
				return stackData.pop();
			}
		}

		public int getMin() {

			if (stackMin.isEmpty()) {
				throw new RuntimeException("You Stack is Empty!");
			} else {
				return stackMin.peek();
			}

		}

	}

	public static void main(String[] args) {

		MyStack1 stack1 = new MyStack1();
		stack1.push(3);
		System.out.println(stack1.getMin());
		stack1.push(4);
		System.out.println(stack1.getMin());
		stack1.push(1);stack1.push(1);
		System.out.println(stack1.getMin());
		System.out.println(stack1.pop());
		System.out.println(stack1.getMin());

		System.out.println("=============");

		MyStack2 stack2 = new MyStack2();
		stack2.push(3);
		System.out.println(stack2.getMin());//3
		stack2.push(4);
		System.out.println(stack2.getMin());//3
		stack2.push(1);stack2.push(1);
		System.out.println(stack2.getMin());//1
		System.out.println(stack2.pop());//1
		System.out.println(stack2.getMin());//1
		
		
	}

}
