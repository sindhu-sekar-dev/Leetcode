import java.util.ArrayList;
import java.util.List;

public class Solution {
    private static final String[] KEYPAD = {
        "",     
        "",     
        "abc",  
        "def",  
        "ghi",  
        "jkl",  
        "mno",  
        "pqrs", 
        "tuv",  
        "wxyz"  
    };

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.length() == 0) return result;

        backtrack(result, new StringBuilder(), digits, 0);
        return result;
    }

    private void backtrack(List<String> result, StringBuilder combination, String digits, int index) {
        if (index == digits.length()) {
            result.add(combination.toString());
            return;
        }

        int digit = digits.charAt(index) - '0';
        String letters = KEYPAD[digit];

        for (char c : letters.toCharArray()) {
            combination.append(c);
            backtrack(result, combination, digits, index + 1);
            combination.deleteCharAt(combination.length() - 1); 
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        String digits1 = "23";
        String digits2 = "2";

        System.out.println(sol.letterCombinations(digits1)); 
        System.out.println(sol.letterCombinations(digits2)); 
    }
}
