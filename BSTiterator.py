#// Time Complexity : O(n) 
# // Space Complexity : O(n)   
# // Did this code successfully run on Leetcode : yes
# // Any problem you faced while coding this : yes understanding the lazy loading and controlled recursion was a bit difficult

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
    
    def dfs(self,root):
        while root != None:
            self.stack.append(root)
            root = root.left


    def next(self) -> int:
        temp = self.stack.pop()
        if temp.right:
            self.dfs(temp.right)
        return temp.val
        

    def hasNext(self) -> bool:
        if self.stack:
            return True
        else:
            return False


# Your BSTIterator object will be instantiated and called as such:
# obj = BSTIterator(root)
# param_1 = obj.next()
# param_2 = obj.hasNext()

# Approach:
# we are using controlled recursion here to iterate over the BST
