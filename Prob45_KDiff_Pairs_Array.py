#Time Complexity : O(n)
#Space Complexity : O(n)
#Did this code successfully run on Leetcode : yes
#Any problem you faced while coding this : no

class Solution:
    def findPairs(self, nums: List[int], k: int) -> int:
            ct = Counter(nums)
            res = 0
            if k == 0:
                for v in ct.values():
                    res += v > 1
            else:
                for n in ct:
                    res += k + n in ct
            return res
        