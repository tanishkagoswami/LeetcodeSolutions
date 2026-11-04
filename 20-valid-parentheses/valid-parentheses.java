import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public boolean isValid(String s) {
        // Edge case: odd length strings can never be valid paired brackets
        if (s.length() % 2 != 0) {
            return false;
        }
        
        Deque<Character> stack = new ArrayDeque<>();
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            // If it's an opening bracket, push its expected closing partner onto the stack
            if (c == '(') {
                stack.push(')');
            } else if (c == '{') {
                stack.push('}');
            } else if (c == '[') {
                stack.push(']');
            } 
            // If it's a closing bracket, check if stack is empty or top doesn't match
            else {
                if (stack.isEmpty() || stack.pop() != c) {
                    return false;
                }
            }
        }
        
        // If the stack is empty, all opening brackets matched successfully
        return stack.isEmpty();
    }
}