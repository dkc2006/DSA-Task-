class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder result = new StringBuilder();
        int balance = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                if (balance > 0) {
                    result.append(c);
                }
                balance++;
            } else {
                balance--;
                if (c == ')') {
                    if (balance > 0) {
                        result.append(c);
                    }
                }
            }
        }
        return result.toString();
    }
}