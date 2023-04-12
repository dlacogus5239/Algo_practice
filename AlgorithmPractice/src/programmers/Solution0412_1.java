package programmers;

import java.util.Stack;

public class Solution0412_1 {

	class Solution {
	    public int solution(String s) {
	        int answer = 0;
	        String nextStr = s;
	        
	        for(int i = 0 ; i < s.length(); i++){
	            if(check(nextStr)){
	                answer++;
	            }
	            nextStr = nextStr.substring(1, s.length()) + nextStr.charAt(0);

	        }
	        
	        return answer;
	    }

	    // 괄호가 맞는지 검사
	    public boolean check(String s){
	        Stack<Character> stack = new Stack<>();
	        
	        for(int i = 0; i < s.length(); i++){
	            
	            try{

	            switch(s.charAt(i)){
	                case'[' :
	                    stack.add('[');
	                    break;
	                    
	                case']' :
	                    if(stack.peek() != '['){
	                        return false;
	                    }
	                    stack.pop();
	                    break;
	                    
	                case'{' :
	                    stack.add('{');
	                    break;
	                    
	                case'}' :
	                    if(stack.peek() != '{'){
	                        return false;
	                    }
	                    stack.pop();
	                    break;
	                    
	                case'(' :
	                    stack.add('(');
	                    break;
	                    
	                case ')':
	                    if(stack.peek() != '('){
	                        return false;
	                    }
	                    stack.pop();
	                    break;
	            }
	            } catch(Exception e){
	                return false;
	            }

	        }
	        
	        return stack.isEmpty() ? true : false;
	    }
	}
}
