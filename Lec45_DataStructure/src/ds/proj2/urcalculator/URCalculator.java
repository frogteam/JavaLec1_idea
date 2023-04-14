package ds.proj2.urcalculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

public class URCalculator {
	
	private String expr;
	private Scanner sc = null;
	
	private HashMap<String, Double> mapVar = new HashMap<String, Double>();
	private HashMap<String, Integer> hmapPrec = new HashMap<String, Integer>();  // 우선순위
	
	//Stack<Double> stackResult = new Stack<Double>();   // <-- '값'을 담을 거다?  Noooo!
														// 대입 연산이 있기 때문에 심벌(String) 을 담아야 할때도 있다...
	Stack<Object> stackResult = new Stack<Object>();
	Stack<String> stackOperator = new Stack<String>();
	
	private final String OP = "=+-/*(){}[]";
	
	
	public static final boolean OPERAND_MODE = true;
	public static final boolean OPERATOR_MODE = false;
	
	public static final Boolean SIGN_NONE = null;
	public static final Boolean SIGN_PLUS = true;
	public static final Boolean SIGN_MINUS = false;
	
	
	public URCalculator() {
		if(sc == null) {
			sc = new Scanner(System.in);
		}
		
		//TEST
		mapVar.put("aa", 10.0);
		mapVar.put("bb", 20.0);
		mapVar.put("cc", 30.0);
		
		// 우선순위
		hmapPrec.put("=", 1);
		hmapPrec.put("+", 2);
		hmapPrec.put("-", 2);
		hmapPrec.put("*", 3);
		hmapPrec.put("/", 3);
	}
	
	public static void main(String[] args) {

		URCalculator app = new URCalculator();
		app.run();
		app.close();
		
	} // end main()
	
	public void run() {
		
		String [] tokens;
		
		while(true) {
			System.out.print("> ");  // 프롬프트
			expr = sc.nextLine();    // 수식 입력
			
			tokens = expr.split("\\s+");  // 공백제거
			
			if(tokens.length == 0) continue;  // 수식이 빈 문자열이면, 재입력.
			
			switch(tokens[0]) {
			case "clear":
				doClear(Arrays.copyOfRange(tokens, 1, tokens.length));
				break;
			case "show":
				doShow(Arrays.copyOfRange(tokens, 1, tokens.length));
				break;
			case "exit":
				System.out.println("프로그램을 종료합니다");
				return;  // 프로그램 종료
			default:
				doEval(tokens);   // 수식 연산 수행
			}
		}// end while		
	} // end run()
	
	public void close() {
		if(sc != null) {
			sc.close();
			sc = null;
		}
	} // end close()
	
	
	public void doClear(String[] tokens) {
		
		if(tokens.length > 0) {
			if(tokens[0].equals("all")) {
				mapVar.clear();  // 변수 삭제
				System.out.println("모든 변수 삭제");
			}else {
				// 특정 변수 삭제
				Double val = mapVar.remove(tokens[0]);
				if(val == null) {
					System.out.println("에러:" + tokens[0] + " 변수 없슴");
				}else {
					System.out.println("변수 삭제");
				}
			}
		}else{
			// 뒤가 없으면 에러
			System.out.println("ERROR] clear 변수명/ clear all");
		}
	} // end
	
	public void doShow(String[] tokens) {
		//TEST
//		System.out.println("doShow : " + Arrays.toString(tokens));
		
		if(tokens.length > 0) {
			if(tokens[0].equals("all")) {
				// 모든 변수 보여주기
				showVar();
			}else {
				// 특정 변수 보여주기
				showVar(tokens[0]);
			}			
		}else{
			// 뒤가 없으면 에러
			System.out.println("ERROR] show 변수명/ show all");
		}
	} // end 

	// show 명령어
	public void showVar() {
		System.out.println("총 " + mapVar.size() + "개의 변수");
		int i = 1;
		for(Map.Entry<String, Double> e : mapVar.entrySet()) {
			System.out.println(i + "] " + e.getKey() + " : " + e.getValue());
			i++;
		} // end for
	} // 
	
	public void showVar(String var) {
		Double value = mapVar.get(var); 
		if(value != null) {
			System.out.println(var + " : " + value);
		}else {
			System.out.println("에러: " + var + " 이름의 변수는 없습니다");
		}
	}
	

	public void doEval(String[] tokens) {
		
		LinkedList<String> listTok = new LinkedList<String>();
		
		// token 분리 하여 list 에 저장
		for (int i = 0; i < tokens.length; i++) {
			StringTokenizer tokenizer = new StringTokenizer(tokens[i], OP, true);	
			while(tokenizer.hasMoreTokens()) {
				listTok.add(tokenizer.nextToken());
			}
		} // end for
		
		// operatnd stack, operator stack 준비
		stackResult.clear();
		stackOperator.clear();
		
		
		Boolean token_mode = OPERAND_MODE;      // 토큰모드 : 피연산자 부터..
		Boolean current_sign = SIGN_NONE;       // 부호 : 없슴
		
		
		
//		String tok = null;
//		String prevTok = null;
//		for(int i = 0; i < listTok.size(); i++) {
//			prevTok = tok;    // 이전 token 기억.  왜
//			tok = listTok.get(i);
			
			
		for(String tok : listTok) {
			
			// ■ operator 라면?
			if("+-*/".indexOf(tok) >= 0) {
				// 연산의 경우
				// 연산자 우선순위.
				// operator스택에 기존 operator 처리 (자신보다 우선순위가 같거나 큰 것들을 다 pop() 하여 처리 한뒤 push됨)
						
				// 피연산자 모드 인데 + - 가 들어오면.. 이건 부호 연산자다
				if(token_mode == OPERAND_MODE && "+-".indexOf(tok) >= 0) {
					
					switch(tok) {
					case "+":
						if(current_sign == SIGN_NONE) current_sign = SIGN_PLUS;   // None 인 경우 만 plus 로
						break;
					case "-":
						if(current_sign == SIGN_NONE) current_sign = SIGN_MINUS;   // None 인 경우 만 plus 로
						else current_sign = !current_sign;  // 그 외의 경우는 부호 변경
						break;
					}
					
				}else {
					// '연산자 모드'
					while(true){
						if(stackOperator.size() == 0) {
							stackOperator.push(tok);
							break;
						}		
						
						if("+-*/".indexOf(stackOperator.peek()) == -1) {   // 기존에 있던게 연산자가 아니라면
							stackOperator.push(tok);   // 연산자 push 하고 종료
							break;
						}
						
						// 우선순위 비교.  기존것보다 자기(tok)가 크면
						if(hmapPrec.get(stackOperator.peek()) < hmapPrec.get(tok)) {
							stackOperator.push(tok);   // 연산자 push 하고 종료
//						isOperandTurn = false;
							break;						
						}
						
						// pop 하여 연산 수행
						Double result = operate(stackOperator.pop());
						if(result == null) return;   // 연산수행중 에러 나면 종료.
						
					}
					// 끝나면, '피연산자 모드' 전환
					token_mode = OPERAND_MODE;   
				}
				
			}else if(tok.equals("=")) {
				// 대입연산자의 경우  결합방향이 반대이기 때문에
				stackOperator.push(tok);  // 연산자 push 하고 종료?
				
				
				// 끝나면, '피연산자 모드'
				token_mode = OPERAND_MODE;   

				
			}else if("([{".indexOf(tok) >= 0) {
				// 여는 괄호
				stackOperator.push(tok);    // 여는 괄호는 그냥 push 하면 된다.
			}else if("}])".indexOf(tok) >= 0) {
				// 닫는 괄호
				// 쌍이 맞는 것 만날때까지 pop 하면서 operate 수행
				// )  -->  (
				// }  -->  {
				// ]  -->  [
				// 이 쌍이 안 맞으면 not well-formed 이다
				
				while(true) {
					if(stackOperator.size() == 0) {   // 더 없다면?
						System.out.println("ERROR] not well-formed");
						return;  // 종료
					}
					
					if("=+-*/".indexOf(stackOperator.peek()) > 0) {   // 기존에 있던게 연산자라면
						Double result = operate(stackOperator.pop());
						if(result == null) return;   // 연산수행중 에러 나면 종료.
						continue;
					}
					
					// 이제 남은건 괄호 뿐이어야 하고, 반드시 쌍이 맞아야 한다
					String op = stackOperator.pop();
					if(tok.equals(")") && op.equals("(")) break;
					if(tok.equals("]") && op.equals("[")) break;
					if(tok.equals("}") && op.equals("{")) break;
					
					// 쌍이 안맞았으니 에러
					System.out.println("ERROR] not well-formed");
					return;  // 종료
				} // end while
				
			}else {
				// ■ 값 인 경우?
				Double value = null;
				try {		
					// 숫자 리터럴이면 그대로 값을 push
					value = Double.parseDouble(tok);
					
					// stackResult.push(value);
					if(current_sign == SIGN_NONE || current_sign == SIGN_PLUS) {						
						stackResult.push(value);    // 부호 그대로 저장
					}else if(current_sign == SIGN_MINUS) {
						stackResult.push(-value);   // 부호 반대로 저장
					}
					
				}catch(NumberFormatException e) {				
					// ■ 변수인 경우?
					// 참조 될지 선언될지 모르기에 걍. 토큰 문자열을 push
//					stackResult.push(tok);   // String
					
					if(current_sign == SIGN_NONE) {	  // 부호가 없었다면
						stackResult.push(tok);   // String (변수이름으로 저장)
						
					}else if(current_sign == SIGN_PLUS) {  // + 부호상태이면
						// 변수'값'을 꺼내서 push
						value = getOperandValue(tok);
						if(value != null) {
							stackResult.push(value);  // 부호 그대로 값을 저장
						}else {
							System.out.println("ERROR] variable " + tok + " not defined");
						}
						
					}else if(current_sign == SIGN_MINUS) {  // - 부호상태이면
						//
						value = getOperandValue(tok);
						if(value != null) {
							stackResult.push(-value);  // 부호 바뀐 '값'을 저장
						}else {
							System.out.println("ERROR] variable " + tok + " not defined");
						}
					} // end if
				
				} // end try-catch
				
				// 값이 끝나면, '연산자 모드'
				token_mode = OPERATOR_MODE;   
				current_sign = SIGN_NONE;       // <- 부호는 다시 원위치
				
			} // end (연산, =, 괄호, 값)
							
			
		} // end for (토큰 추출 완료)
		
		
		// 더이상 뽑아낼 토큰이 없다
		// 그러면 이제 하나하나 뽑아내면서 처리하면 된다.
		while(stackOperator.size() > 0) {
			String op = stackOperator.pop();
			
			// 만약 op 가 연산자가 아니면 not well-formed
			if("=+-*/".indexOf(op) == -1) {
				System.out.println("ERROR] not well-formed");
				return;  // 종료
			}

			if( operate(op) == null) return;  // 연산 결과 에러면 종료
		}
		
		// 맨 마지막에 Stack 에 남아있는 하나의 값이 결과값이다"
		// 반드시 하나만 남아있어야 한다
		if(stackResult.size() != 1) {
			System.out.println("ERROR] 연산식 오류");
			return;
		}
		
		// 최종 결과 출력
		Object lastOperand = stackResult.pop();
		Double result = getOperandValue(lastOperand);
		
		if(result != null) {
			System.out.println(result);
		}else {
			System.out.println("ERROR] variable " + (String)lastOperand + " not defined");
		}
	
		
	} // end 

	
	/**
	 * 
	 * @param operator
	 * @return  성공하면 Double 값 리턴, 에러나면 null 리턴
	 */
	public Double operate(String operator) {
		// operand 에서 뽑아낼 2개가 있는가?
		if(stackResult.size() < 2) {
			System.out.println("ERROR] 연산자에 필요한 피연산자가 없습니다");
			return null; 
		}
		
		Object popOp2 = stackResult.pop();
		Object popOp1 = stackResult.pop();
		Double result = null;
		
		Double operand1 = getOperandValue(popOp1);
		Double operand2 = getOperandValue(popOp2);
		
		// operand1, operand2 는  Double 일수도 있고, String 일수도 있다.
		
		// 산술 연산의 걍우 두 피연산자는 반드시 참조될수 있는 값을 가지고 있어야 한다.  즉  두 operand 모두 null 이어서는 안된다!
		if("+-*/".indexOf(operator) >= 0){
			if(operand1 == null) {
//				System.out.println("ERROR] " + operator + " op unknown operand1 " + (String)popOp1);
				
				System.out.println("ERROR] variable " + (String)popOp1 + " not defined");
				
				return null;
			}
			
			if(operand2 == null) {
//				System.out.println("ERROR] " + operator + " op unknown operand2 " + (String)popOp2);
				
				System.out.println("ERROR] variable " + (String)popOp2 + " not defined");
				return null;				
			}
			
			switch(operator) {
			case "+":
				result = operand1 + operand2;
				break;
			case "-":
				result = operand1 - operand2;
				break;
			case "*":
				result = operand1 * operand2;
				break;
			case "/":
				if(operand2 == 0.0) {
					System.out.println("ERROR] Divide by Zero");
					return null;
				}
				result = operand1 / operand2;
				break;
			} // end switch
			
		}else if("=".equals(operator)){
			// 대입연산의 경우 좌측이 변수 이어야 하고, 
			// 우측은 '값'이어야 한다. (즉 null 이면 안된다)
			if(operand2 == null) {
				System.out.println("ERROR] " + operator + " op unknown operand2 " + (String)popOp2);
				return null;				
			}
			
			
			result = operand2;  // 일단 대입연산의 결과는 대입된 값이다.
			
			// 좌측은 변수이어야 한다.  즉 문자열이어야 한다
			if(!(popOp1 instanceof String)) {
				System.out.println("ERROR] " + operator + " op may have invalid lvalue " + popOp1);
				return null;				
			}
			
			// 변수였다면?  
			// 기존에 없던 변수였다면. 새로 생길것이고 있었다면 업데이트 될것이다
			mapVar.put((String)popOp1, result);
		}
		
		if(result != null) stackResult.push(result);   // 결과값 다시 push
		
		return result; 
	} // end operate()
	
	/**
	 * 숫자 혹은 변수이면 값을.  모르는 이름이면 null 을.
	 * @param operand
	 * @return  Double : 숫자값, 혹은 변수 값 / null : 아직 선언 안된 변수.    
	 */
	public Double getOperandValue(Object operand) {
		if(operand instanceof Double) {
			return (Double)operand;   // Double 이면 걍 그 값이 operand 값
		}else {
			return mapVar.get((String)operand);   // 대입이 안된거면 null 일수도 있다
		}
	} // end getOperandValue()

	
	
	

} // end class

