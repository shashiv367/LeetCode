class Solution {
    public int xorOperation(int n, int start) {
        int xorData = start;
        for(int i=1;i<n;i++){
            xorData ^= (start + 2 * i);
        }
    return xorData;
    }
}