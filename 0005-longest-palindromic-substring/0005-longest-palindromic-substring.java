class Solution {
    public String longestPalindrome(String s) {
        if (s.length() < 2) return s;
        
        int start = 0, maxLen = 1;
        
        for (int i = 0; i < s.length(); i++) {
            int[] odd = expand(s, i, i);       // odd center
            int[] even = expand(s, i, i + 1);  // even center
            
            if (odd[1] - odd[0] + 1 > maxLen) {
                start = odd[0];
                maxLen = odd[1] - odd[0] + 1;
            }
            if (even[1] - even[0] + 1 > maxLen) {
                start = even[0];
                maxLen = even[1] - even[0] + 1;
            }
        }
        
        return s.substring(start, start + maxLen);
    }
    
    private int[] expand(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return new int[] {left + 1, right - 1};
    }
}
