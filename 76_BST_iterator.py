# Time complexity - hasNext() - O(1), next() - O(1) avg (becoz for 75% of nodes it's O(1), for rest 25%, 
# it's O(h) or O(n/2))
# Space complexity - hasNext() - O(1), next() - O(1)

# Approach - Have a dfs function that appends elements (node.left) in stack when TreeNode is initialized. 
# For hasNext, only need to check if stack has any elements. For next, pop the top element first, perform 
# dfs on element.right (because stack needs to get updated with right elements of that node), 
# and then return value of element.

from typing import Optional
# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class BSTIterator:
    def __init__(self, root: Optional[TreeNode]):
        self.st = []
        self.dfs(root)
        
    def dfs(self, root: Optional[TreeNode]) -> None:
        while root != None:
            self.st.append(root)
            root = root.left

    def next(self) -> int:
        popped = self.st.pop()
        self.dfs(popped.right)
        return popped.val        

    def hasNext(self) -> bool:
        return len(self.st) > 0

# Your BSTIterator object will be instantiated and called as such:
# obj = BSTIterator(root)
# param_1 = obj.next()
# param_2 = obj.hasNext()