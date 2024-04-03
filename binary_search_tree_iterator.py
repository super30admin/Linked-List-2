# Time Complexity : O(h) average-O(1)
# Space Complexity : O(h)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach
from typing import Optional, TreeNode
class BSTIterator:
    stack = []
    def __init__(self, root: Optional[TreeNode]):
        self.helper(root)

    def next(self) -> int:
        temp = self.stack.pop()
        self.helper(temp.right)
        return temp.val
        

    def hasNext(self) -> bool:
        return len(self.stack) != 0

    def helper(self, root):
        while root:
            self.stack.append(root)
            root = root.left