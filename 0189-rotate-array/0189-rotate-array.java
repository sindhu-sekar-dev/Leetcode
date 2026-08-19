class Solution {
    public void rotate(int[] arr, int k) {
        int n = arr.length;
        k = k % n;
        int[] result = new int[n];
        for(int i = 0; i < arr.length; i++){
            result[(i + k) % arr.length] = arr[i];
        }
        for(int i = 0; i < n; i++){
            arr[i] = result[i];
        }
    }
}