"""
The idea is to define a stack and initially store left children of root if exists.
Then in the hasnext(), return popped value from the stack and before returning check if it has right child
if yes, append the right child and check if has left tree.
TC: O(1), since it is a design problem, we take average time complexity. 
"""

from typing import Optional

# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class BSTIterator:

    def __init__(self, root: Optional[TreeNode]):
        self.stack = []
        self.add_left_children(root)

    def add_left_children(self, node):
        if not node:
            return
        self.stack.append(node)
        self.add_left_children(node.left)

    def next(self) -> int:
        if self.hasNext():
            node = self.stack.pop()
            self.add_left_children(node.right)

        return node.val

    def hasNext(self) -> bool:
        if self.stack:
            return True
        else:
            return False

# Your BSTIterator object will be instantiated and called as such:
# obj = BSTIterator(root)
# param_1 = obj.next()
# param_2 = obj.hasNext()