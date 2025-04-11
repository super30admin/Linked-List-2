# Time Complexity : O(1)
# Space Complexity : O(h) where h is the height of the tree
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

from typing import Optional


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class BSTIterator:
    def __init__(self, root: Optional[TreeNode]):
        self.st = []
        self.dfs(root)
    def dfs(self,root):
        while root:
            self.st.append(root)
            root = root.left

    def next(self) -> int:
        temp = self.st.pop()
        self.dfs(temp.right)
        return temp.val

    def hasNext(self) -> bool:
        return len(self.st) != 0
        