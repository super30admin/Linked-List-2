#TC: O(1) amortized for next and hasnext
#SC: O(height of the tree) worst case

import collections
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class BSTIterator:

    def __init__(self, root: Optional[TreeNode]):
        self.stack=collections.deque()
        while root: self.stack.append(root); root=root.left

    def next(self) -> int:
        root=self.stack.pop()
        _next=root.right
        while _next: self.stack.append(_next); _next=_next.left
        return root.val

    def hasNext(self) -> bool:
        return bool(self.stack)
        


# Your BSTIterator object will be instantiated and called as such:
# obj = BSTIterator(root)
# param_1 = obj.next()
# param_2 = obj.hasNext()