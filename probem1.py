# Time Complexity : O(1)
# Space Complexity : O(N)

# Did this code successfully run on Leetcode : 
# YEs

# Any problem you faced while coding this : 
# Your code here along with comments explaining your approachclass Solution:

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class BSTIterator:

    def __init__(self, root: Optional[TreeNode]):
        self.stack = []
        self.dfs(root)
        

    def next(self) -> int:
        if self.stack:
            node = self.stack.pop()
            self.dfs(node.right)
            return node.val
    def dfs(self,root):
        while root != None:
            self.stack.append(root)
            root= root.left

    def hasNext(self) -> bool:
        return len(self.stack) >0
        


# Your BSTIterator object will be instantiated and called as such:
# obj = BSTIterator(root)
# param_1 = obj.next()
# param_2 = obj.hasNext()