package Chapter1_Stack_Queue;

import java.util.Stack;

/*
 * ���һ����getMin���ܵ�ջ��
 * Ҫ��
 *   1.pop,push,getMin������ʱ�临�Ӷȶ���O(1)
 *   2.��Ƶ�ջ�������ֳɵ�ջ�ṹ
 */
public class P1_getMin {

	// ��һ�ַ���
	public static class MyStack1 {
		private Stack<Integer> stackData;// ����ջ
		private Stack<Integer> stackMin;// ��ÿһ����Сֵ��ջ
		
		

		public MyStack1() {
			this.stackData = new Stack<Integer>();
			this.stackMin = new Stack<Integer>();
		}

		public void push(int num) {
			stackData.push(num);
			if (stackMin.isEmpty()) {
				stackMin.push(num);

			} else if (num <= stackMin.peek()) {
				// С�ڵ�������Ϊ������ظ��ĵ�ǰ��Сֵѹջ����Ӧ֮���ջ���߼�
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

	// �ڶ��ַ���
	public static class MyStack2 {
		private Stack<Integer> stackData;// ����ջ
		private Stack<Integer> stackMin;// ��ÿһ����Сֵ��ջ

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
				// С�ڵ�������Ϊ������ظ��ĵ�ǰ��Сֵѹջ����Ӧ֮���ջ���߼�
				stackMin.push(num);

			} else {
				// �ѵ�ǰ��Сֵ�ظ�ѹջ
				stackMin.push(stackMin.peek());
			}
		}

		public int pop() {

			if (stackData.isEmpty()) {
				throw new RuntimeException("You Stack is Empty!");
			} else {

				stackMin.pop();//ͬ����ջ
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
