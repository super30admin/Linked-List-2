"""
TC: O(N) {worst case O(N) but average case would be O(1)}
SC: O(H) {Where H is the height of the tree, we are only storing the nodes uptill height of the tree, worst case it could be N for a skewed tree}

Approach:

We initialize a stack and add all the left most values, ie the smallest values from the BST to it.
When the call for next is done, we pop the smallest from the top of the stack and then append the right value (ie) the second smallest
value to the stack (or multiple next small values from the BST)
For the has_next, we just see if the stack is empty or not

The problem ran successfully on LeetCode.
"""

from typing import Optional, List
# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class BSTIterator:

    def __init__(self, root: Optional[TreeNode]):
        self.stack = []
        self.helper(root)
    
    
    def helper(self, node):

        while node:
            self.stack.append(node)
            node = node.left
        
    def next(self) -> int:
        res = self.stack.pop()
        self.helper(res.right)
        return res.val
        
    def hasNext(self) -> bool:
        return len(self.stack) > 0

# Your BSTIterator object will be instantiated and called as such:
# obj = BSTIterator(root)
# param_1 = obj.next()
# param_2 = obj.hasNext()