public class Solution {
    public int strStr(String haystack, String needle) {
        int hLen = haystack.length();
        int nLen = needle.length();

        if (nLen == 0) return 0; 

        for (int i = 0; i <= hLen - nLen; i++) {
            int j;
            for (j = 0; j < nLen; j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    break;
                }
            }
            if (j == nLen) return i; 
        }

        return -1; 
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        String haystack1 = "sadbutsad";
        String needle1 = "sad";
        System.out.println(sol.strStr(haystack1, needle1)); 

        String haystack2 = "leetcode";
        String needle2 = "leeto";
        System.out.println(sol.strStr(haystack2, needle2)); 

        String haystack3 = "hello";
        String needle3 = "ll";
        System.out.println(sol.strStr(haystack3, needle3)); 
    }
}
