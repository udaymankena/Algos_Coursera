package com.javayadu.week2;
import com.javayadu.week2.Stack.Stack;

public class ArithmeticOperation {
	
	/* This is an implementation of Djkistra's two stack approach for performing arithmetic operations
	 * ### Algorithm ###
	 * Maintain two stacks, one each for operands and operators
	 * Keep pushing operators and operands to the respective stacks as you encounter them
	 * Ignore left paranthesis
	 * When a right paranthesis is found, push pop two operands and one operator, perform the operation and push result to stack
	 * repeat
	 * #################
	 * */
	
	private boolean isOperator(char operand) {
		return (operand == '+' || operand == '-' || operand == '*' || operand == '/'); 
	}
	
	private boolean isLeftParanth(char operand) {
		return operand == '(';
	}
	
	private boolean isrightParanth(char operand) {
		return operand == ')';
	}
	
	public int eval_ae(String ae) {
		Stack<Character> operator_st = new Stack();
		Stack<Integer> operand_st = new Stack();
		String prev = "";
		for(int i=0; i< ae.length();i++) {
			
			if(isOperator(ae.charAt(i))) 
				operator_st.push(ae.charAt(i));
			else if(isLeftParanth(ae.charAt(i)))
				continue;
			else if(isrightParanth(ae.charAt(i))) {
				if(operator_st.isEmpty()) {
					break;
				}
				int operand_1 = operand_st.pop();
				int operand_2 = operand_st.pop();
				char operator = operator_st.pop();
				int operation_res = operation(operand_1, operand_2, operator);
				System.out.println("pushing to stack: " + operation_res);
				operand_st.push(operation_res);
				
			}
			else { // when the current character is an integer, get all the digits of the number
				   // ex: 234*4+78 --> if the current integer is 2, get 234
				String operand_whole = ae.charAt(i) + "";
				int j = i+1;
				while(j < ae.length() && (int) ae.charAt(j) >= 48 && (int) ae.charAt(j) <= 57) {
					operand_whole += ae.charAt(j);
					j++;
				}
				System.out.println("current_int: " + operand_whole);
				operand_st.push(Integer.parseInt(operand_whole));
				i = j-1;
			}
		}
		
		while(!operator_st.isEmpty()) {
			int operand_1 = operand_st.pop();
			int operand_2 = operand_st.pop();
			char operator = operator_st.pop();
			int operation_res = operation(operand_1, operand_2, operator);
			System.out.println("pushing to stack: " + operation_res);
			operand_st.push(operation_res);
			
		}
		return operand_st.pop();
	}
	
	private int operation(int operand_1,int operand_2,char operator) {
		switch(operator) {
		case '+': return operand_2 + operand_1;
		case '-': return operand_2 - operand_1;
		case '*': return operand_2 * operand_1;
		case '/': return operand_2 / operand_1;
		default: return 0;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String ae = "1+2*(3+4)-(10/2)";
		//String ae = "1+2+3";
		ArithmeticOperation aop = new ArithmeticOperation();
		System.out.println(aop.eval_ae(ae));
		
	}

}
