package Chapter1_Stack_Queue;

import java.util.Stack;

/*
 * 仅用用递归函数和栈操作逆序一个栈☆☆
 */
public class P3_StackInRecursion {
	
	/*
	 * 用了两个递归函数
	 */

	//得到栈底元素并且移出栈
	public static int getBottomInt(Stack<Integer> stack) {
		if (!stack.isEmpty()) {

			int popNum = stack.pop();
			if (stack.isEmpty()) {
				return popNum;
			} else {
				int result = getBottomInt(stack);
				stack.push(popNum);
				return result;

			}

		} else {
			throw new RuntimeException("You Stack is Empty");
		}

	}
	
	
	//倒序
	public static void reverse(Stack<Integer> stack){
		if(stack.isEmpty()){
			return;
		}else{
			int bottomNum = getBottomInt(stack);
			reverse(stack);
			stack.push(bottomNum);
		}
		
	}

	public static void main(String[] args) {
		
		Stack<Integer> test = new Stack<Integer>();
		test.push(1);
		test.push(2);
		test.push(3);
		test.push(4);
		test.push(5);
		reverse(test);
		while (!test.isEmpty()) {
			System.out.println(test.pop());
		}
	}

}
