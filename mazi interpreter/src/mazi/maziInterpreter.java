package mazi;

import java.util.HashMap;
import java.util.Scanner;
import java.util.StringTokenizer;

public class maziInterpreter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("============ 사용예 =============");
		System.out.println("radius = 123");
		System.out.println("z = radius * radius * 3.14");
		System.out.println("PRINT z");
		System.out.println("PRINT z + 123");
		System.out.println("READ w");
		System.out.println("PRINT w");
		System.out.println("IF 3 > 2 THEN x = 3 ELSE PRINT 2 + 3");
		System.out.println("=======반드시 띄어쓰기를 해주세요======");
		Scanner scanner = new Scanner(System.in);

		HashMap<String, Double> env = new HashMap<String, Double>();

		while (scanner.hasNext()) {
			String line = scanner.nextLine();
			StringTokenizer stz = new StringTokenizer(line);
			// double result = evalExpr(env, 0, "+", stz);
			// System.out.println("Evalute " + line + " to " + result);
			evalStmt(env, stz);
		}

	}

	public static void evalStmt(HashMap<String, Double> env, StringTokenizer stz) {

		String word = stz.nextToken();
		double result;
		if (word.equals("PRINT")) {
			result = evalExpr(env, 0, "+", stz);
			System.out.println(result);
		} else if (word.equals("READ")) {
			String variable = stz.nextToken();
			System.out.print(variable + " = ");
			Scanner scanner = new Scanner(System.in);
			if (scanner.hasNext()) {
				env.put(variable, scanner.nextDouble());
				System.out.println("변수를 넣었습니다.");
			}
		} else if (word.equals("IF")) {
			// TO DO
			// 아마 >,< 의 우선순위도 넣어줘야 할거같음. 그리고 아래와같이 하지 말고, THEN 과 ELSE
			// 가 나올때까지 스트링을 넣어준다음에 토크나이징 해야할거같음
			String conditional = "";
			while(true){
				word = stz.nextToken();
				if(word.equals("THEN")) break;
				conditional += (word+" ");
			}
			StringTokenizer conditionStz = new StringTokenizer(conditional);
			double rBool = evalExpr(env, 0, "+", conditionStz);
			//System.out.println(rBool);
			conditional = "";
			if(rBool == 1){
				while(true){
					word = stz.nextToken();
					if(word.equals("ELSE")) break;
					conditional += (word+" ");
				}
				conditionStz = new StringTokenizer(conditional);
				//System.out.println(conditional);
				evalStmt(env, conditionStz);
			}else{
				while(true){
					word = stz.nextToken();
					if(word.equals("ELSE")) break;
				}
				while(stz.hasMoreTokens()){
					word = stz.nextToken();
					conditional += (word+" ");
				}
				conditionStz = new StringTokenizer(conditional);
				//System.out.println(conditional);
				evalStmt(env, conditionStz);
			}
		} else if (Character.isLetter(word.charAt(0))) {
			String operand = stz.nextToken();

			if (operand.equals("=")) {
				env.put(word, evalExpr(env, 0, "+", stz));
				System.out.println("변수를 넣었습니다.");
			} else {
				result = evalExpr(env, env.get(word), operand, stz);
				System.out.println(result);
			}

		} else {
			result = evalExpr(env, Double.valueOf(word), stz.nextToken(), stz);
			System.out.println(result);
		}

	}

	public static double evalExpr(HashMap<String, Double> env, double operand1,
			String operator1, StringTokenizer stz) {
		double result = 0;

		// (1)
		if (stz.countTokens() == 0) {
			System.err.println("Tokens not available.");
		}
		// (2)
		else if (stz.countTokens() == 1) {
			String token = stz.nextToken();
			double operand2 = evalOperand(env, token);

			result = evalExpr(operand1, operator1, operand2);
		}
		// (3)
		else if (stz.countTokens() >= 3) {
			String tokenOperand2 = stz.nextToken();
			double operand2 = evalOperand(env, tokenOperand2);

			String operator2 = stz.nextToken();

			// (3.1)
			if (precedence(operator1) > precedence(operator2)) {
				double d = evalExpr(operand1, operator1, operand2);
				result = evalExpr(env, d, operator2, stz);
			}
			// (3.2)
			else if (precedence(operator1) < precedence(operator2)) {
				double d = evalExpr(env, operand2, operator2, stz);
				result = evalExpr(operand1, operator1, d);
			}
			// (3.3)
			else {
				// (3.3.1)
				if (associativity(operator1) == Associativity.LeftToRight) {
					double d = evalExpr(operand1, operator1, operand2);
					result = evalExpr(env, d, operator2, stz);
				}
				// (3.3.2)
				else { // Associativity.RightToLeft
					double d = evalExpr(env, operand2, operator2, stz);
					result = evalExpr(operand1, operator1, d);
				}
			}
		}
		// (4)
		else {
			System.err.println("Something wrong:");
			while (stz.hasMoreTokens()) {
				System.err.print(stz.nextToken() + " ");
			}
			System.err.println();
		}

		return result;
	}

	public static double evalOperand(HashMap<String, Double> env, String operand) {
		double result = 0;

		if (Character.isLetter(operand.charAt(0))) { // operand is a variable
			Double d = env.get(operand);
			if (d == null) {
				System.err.println("Undefined variable: " + operand);
			} else {
				result = d;
			}
		} else { // operand is a number
			result = new Double(operand);
		}

		return result;
	}

	public static double evalExpr(double operand1, String operator,
			double operand2) {
		double result = 0;

		switch (operator.charAt(0)) {
		case '+':
			result = operand1 + operand2;
			break;
		case '-':
			result = operand1 - operand2;
			break;
		case '*':
			result = operand1 * operand2;
			break;
		case '/':
			result = operand1 / operand2;
			break;
		case '>':
			if (operand1 > operand2) {
				result = 1;
			} else {
				result = 0;
			}
			break;
		case '<':
			if (operand1 < operand2) {
				result = 1;
			} else {
				result = 0;
			}
			break;
		case '=':
			if (operand1 == operand2) {
				result = 1;
			} else {
				result = 0;
			}
			break;
		default:
			System.err.println("Unsupported operator: " + operator);
		}

		return result;
	}

	public static int precedence(String operator) {
		switch (operator.charAt(0)) {
		case '=':
			return 1;
		case '>':
		case '<':
			return 2;
		case '+':
		case '-':
			return 3;
		case '*':
		case '/':
			return 4;
		default:
			System.err.println("Unsupported operator: " + operator);
			return 0;
		}
	}

	enum Associativity {
		LeftToRight, RightToLeft;
	}

	public static Associativity associativity(String operator) {
		switch (operator.charAt(0)) {
		case '+':
		case '-':
		case '*':
		case '/':
			return Associativity.LeftToRight; // Left to Right
			/*
			 * case '=': return Associativity.RightToLeft; // Right to Left
			 */

		default:
			System.err.println("Unsupported operator: " + operator);
			return Associativity.LeftToRight;
		}
	}

}
