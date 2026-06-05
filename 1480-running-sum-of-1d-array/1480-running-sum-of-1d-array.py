class Solution:
    def runningSum(self, nums: List[int]) -> List[int]:
        run = []
        ints = 0

        for item in nums:
            ints += item  #ints = ints + item
            run.append(ints)
        return run