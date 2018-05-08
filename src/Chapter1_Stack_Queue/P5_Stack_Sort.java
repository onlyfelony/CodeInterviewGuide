package Chapter1_Stack_Queue;

import java.util.Stack;

/*
 * 用一个栈实现另一个栈的排序☆
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
		}// 还原到原来的栈中

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
