# // Time Complexity : o(1)
# // Space Complexity : o(1)
# // Did this code successfully run on Leetcode : yes
# // Any problem you faced while coding this : what is controlled recursion and how to acheive it


# // Your code here along with comments explaining your approach
# idea is to have our own stack and during initialization do a dfs and pt everything into the stack so that min element is in the too
# whenever the next is called output the top element and then explore the right and put all the top elements of the right to the stack this ensures inorder tracersal
# chek the length of the stack to confirm if it is !empty

# Definition for a binary tree node.
from typing import Optional
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
# class BSTIterator:

#     def __init__(self, root: Optional[TreeNode]):
#         self.res = []
#         self.idx = -1
#         self.inorder(root)

#     def inorder(self,root):
#         if not root: return 
#         self.inorder(root.left)
#         self.res.append(root.val)
#         self.inorder(root.right)
        

#     def next(self) -> int:
#         self.idx+=1
#         return self.res[self.idx]

#     def hasNext(self) -> bool:
#         return self.idx+1<len(self.res)
        


# Your BSTIterator object will be instantiated and called as such:
# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class BSTIterator:

    def __init__(self, root: Optional[TreeNode]):
        self.stack = []
        self.dfs(root)
    
    def dfs(self,root):
        while root : 
            self.stack.append(root)
            root = root.left
        
    def next(self) -> int:
        ele = self.stack.pop()
        if ele.right:
            self.dfs(ele.right)
        return ele.val

    def hasNext(self) -> bool:
        return len(self.stack) >0
        


# Your BSTIterator object will be instantiated and called as such:
# obj = BSTIterator(root)
# param_1 = obj.next()
# param_2 = obj.hasNext()