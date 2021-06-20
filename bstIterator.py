# Time Complexity : O(1) 
# Space Complexity :    O(H)
# Did this code successfully run on Leetcode : YES
# Any problem you faced while coding this : NO


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class BSTIterator:

    def __init__(self, root: TreeNode):
        self.stack = []
        self.dfs(root)

    def next(self) -> int:
        root = self.stack.pop()
        self.dfs(root.right)
        return root.val
        

    def hasNext(self) -> bool:
        if len(self.stack)==0:
            return False
        else:
            return True
        
    def dfs(self,root):
        while root:
            self.stack.append(root)
            root = root.left

# Your BSTIterator object will be instantiated and called as such:
# obj = BSTIterator(root)
# param_1 = obj.next()
# param_2 = obj.hasNext()