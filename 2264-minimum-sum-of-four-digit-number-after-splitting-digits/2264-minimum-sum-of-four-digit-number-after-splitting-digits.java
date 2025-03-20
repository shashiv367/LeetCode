class Solution {
    public int minimumSum(int num) {
        int out[] = new int[4];
        for(int i =0; i<out.length;i++){
            out[i] = num % 10;
            num = num /10;
        }
        Arrays.sort(out);
        int result = ((out[0]*10) + out[2]) + ((out[1]*10) + out[3]);
        return result;
    }
}
