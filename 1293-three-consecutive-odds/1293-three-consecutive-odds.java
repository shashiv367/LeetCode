class Solution {
    public boolean threeConsecutiveOdds(int[] arr) {
         int sum=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]%2==1){
                sum++;
                if(sum==3){
                    return true;
                }
            }
            else{
                sum=0;
            }
        }
        return false;
    }
}