class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
       List<List<Integer>> res = new ArrayList<>();
       Arrays.sort(nums);
       HashSet<String> hs = new HashSet<>();

       for(int i =0;i<nums.length-3;i++){
            for(int j =i+1;j<nums.length-2;j++){
                int ri = nums.length-1;
                int li = j+1;
                while(li<ri){
                    long sum =0;
                    sum+=nums[i];
                    sum+=nums[j];
                    sum+=nums[li];
                    sum+=nums[ri];
                    if(sum>target){
                        ri--;
                    }else if(sum<target){
                        li++;
                    }else{
                        StringBuilder sb = new StringBuilder();
                        sb.append(nums[i]);
                        sb.append(nums[j]);
                        sb.append(nums[li]);
                        sb.append(nums[ri]);
                        String match = sb.toString();
                        if(hs.contains(match)==false){
                            hs.add(match);
                            res.add(Arrays.asList(nums[i], nums[j], nums[li], nums[ri]));
                        }
                        ri--;
                        li++;   
                    }
                }
            }
       }
       return res;
    }
}