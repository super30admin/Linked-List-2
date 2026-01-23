"""
time = amortized 0(1)
space - o(n)
we maintain a stack and do a dfs from root and add only the left elements as left side has vales lower than root, this way top of the stack has the lowest value at start
when we pop the top of the stack, we then take its right node and add its left sided children to the stack. This way the next value will be all nodes smaller than the right side of the popped element
and then right element it self.
This way we get at max height of tree nodes in stack. time is amortized o(1) as we push height elements onto the stack and pop each element once only resulting in h/h operations.
"""
from typing import Optional
# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class BSTIterator:

    def _add(self, node):
        while node:
            self.stack.append(node)
            node = node.left

    def __init__(self, root: Optional[TreeNode]):
        self.stack = []
        self._add(root)

        

    def next(self) -> int:
        node = self.stack.pop()
        self._add(node.right)
        return node.val

    def hasNext(self) -> bool:
        return len(self.stack) > 0

        

