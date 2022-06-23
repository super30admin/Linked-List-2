'''
Time Complexity: O(n) for next function and O(1) for hasnext function
Space Complexity: O(h) where h is the height of the tree
Run on Leetcode: YES
Problem faced: Controlling recursion manually
'''
from typing import Optional

# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

#Solution
class BSTIterator:
    myStack = []
    def dfs(self, root: Optional[TreeNode]):
        while root != None:
            self.myStack.append(root)
            root = root.left
    def __init__(self, root: Optional[TreeNode]):
        self.dfs(root)

    def next(self) -> int:
        curr = self.myStack.pop()
        self.dfs(curr.right)
        return curr.val

    def hasNext(self) -> bool:
        return len(self.myStack) > 0