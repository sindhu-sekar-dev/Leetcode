public class Solution {
    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        if (dividend == Integer.MIN_VALUE && divisor == 1) {
            return Integer.MIN_VALUE;
        }
        boolean negative = (dividend < 0) ^ (divisor < 0);
        long dvd = Math.abs((long) dividend);
        long dvs = Math.abs((long) divisor);

        long quotient = 0;

        while (dvd >= dvs) {
            long temp = dvs, multiple = 1;
            
            while (dvd >= (temp << 1)) {
                temp <<= 1;
                multiple <<= 1;
            }
            dvd -= temp;
            quotient += multiple;
        }

        return negative ? -(int) quotient : (int) quotient;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(sol.divide(10, 3));  
        System.out.println(sol.divide(7, -3));  
        System.out.println(sol.divide(-2147483648, -1)); 
        System.out.println(sol.divide(-2147483648, 2));  
    }
}
