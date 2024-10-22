package data_structure;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Expression {
    private String value;
    private final List<Character> leftBrackets = Arrays.asList('(', '<', '[', '{');
    private final List<Character> rightBrackets = Arrays.asList(')', '>', ']', '}');

    public Expression(String input) {
        value = input;
    }

    public boolean isBalanced() {
        Stack<Character> stack = new Stack<>();
        for (char ch : value.toCharArray()) {
            if (isLeftBracket(ch)) {
                stack.push(ch);
            }
            if (isRightBracket(ch)) {
                if (stack.empty()) {
                    return false;
                }
                char top = stack.pop();
                if (isBracketMatching(top, ch)) {
                    return false;
                }
            }
        }
        return stack.empty();
    }

    private boolean isLeftBracket(Character ch) {
        return leftBrackets.contains(ch);
    }

    private boolean isRightBracket(Character ch) {
        return rightBrackets.contains(ch);
    }

    private boolean isBracketMatching(Character left, Character right) {
        return leftBrackets.indexOf(left) == rightBrackets.indexOf(right);
    }
}
