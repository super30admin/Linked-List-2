# Definition for a binary tree node.
from typing import Optional

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class BSTIterator:

    def __init__(self, root: Optional[TreeNode]):
        self.stack = []
        self.helper(root)

    def helper(self, root):
        if not root:
            return
        self.stack.append(root)
        self.helper(root.left)
        
    def next(self) -> int:
        val = self.stack.pop()
        self.helper(val.right)
        return val.val
        

    def hasNext(self) -> bool:
        return True if len(self.stack)>0 else False

# Your BSTIterator object will be instantiated and called as such:
# obj = BSTIterator(root)
# param_1 = obj.next()
# param_2 = obj.hasNext()