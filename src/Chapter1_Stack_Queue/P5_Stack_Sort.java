package Chapter1_Stack_Queue;

import java.util.Stack;

/*
 * ��һ��ջʵ����һ��ջ�������
 */
public class P5_Stack_Sort {
	public static void sortStack(Stack<Integer> oldStack) {
		Stack<Integer> newStack = new Stack<Integer>();
		while (!oldStack.isEmpty()) {
			int numPop = oldStack.pop();

			while (!newStack.isEmpty() && numPop > newStack.peek()) {
				oldStack.push(newStack.pop());
			}

			newStack.push(numPop);
		}

		while (!newStack.isEmpty()) {
			oldStack.push(newStack.pop());
		}// ��ԭ��ԭ����ջ��

	}

	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(3);
		stack.push(1);
		stack.push(6);
		stack.push(2);
		stack.push(5);
		stack.push(4);
		sortStack(stack);
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());

	}

}
