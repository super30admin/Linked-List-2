""""// Time Complexity : O(1)
// Space Complexity : Worst case-O(h), Average case-O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
"""

# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class BSTIterator:

    def __init__(self, root: Optional[TreeNode]):
        self.st = []
        self.helper(root)

    def helper(self, root):
        while root:
            self.st.append(root)
            root = root.left

    def next(self) -> int:
        x = self.st.pop()
        self.helper(x.right)
        return x.val

    def hasNext(self) -> bool:
        return len(self.st) != 0

# Your BSTIterator object will be instantiated and called as such:
# obj = BSTIterator(root)
# param_1 = obj.next()
# param_2 = obj.hasNext()