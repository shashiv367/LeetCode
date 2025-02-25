class Solution {
    public void rotateRev(int[] nums, int start,int end){

            while(start<end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;

    }
    }
    public void rotate(int[] nums, int k) {
        k = k%nums.length;
        rotateRev(nums,0,nums.length-1);
        rotateRev(nums,0,k-1);
        rotateRev(nums ,k,nums.length-1);           
    }
}