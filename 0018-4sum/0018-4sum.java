class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            for (int j = i + 1; j < n; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;
                long comp = (long)target - (nums[i] + nums[j]);
                int k = j + 1, l = n - 1;
                while (k < l) {
                    if (nums[k] + nums[l] == comp) {
                        ans.add(Arrays.asList(nums[i], nums[j], nums[k], nums[l]));
                        while (k < l && nums[k] == nums[k + 1]) k++;
                        while (k < l && nums[l] == nums[l - 1]) l--;
                        k++;
                        l--;
                    } else if (nums[k] + nums[l] > comp) {
                        l--;
                    } else {
                        k++;
                    }
                }
            }
        }
        return ans;
    }
}