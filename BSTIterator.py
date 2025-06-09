# // Time Complexity :O(N)
# // Space Complexity :O(1)
# // Did this code successfully run on Leetcode :yes
# // Any problem you faced while coding this :no

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
from collections import deque
# Lazy Traversal
class BSTIterator:
#you can do with brute force , but ehen it comes to iteratot it should be dymaic like data may be added to tree adter you did in order so that not efficient way

    def __init__(self, root: Optional[TreeNode]):
        self.stack=deque()
        self._dfs(root)
    def _dfs(self,root):
        if not root :return
        while root:
            self.stack.append(root)
            root=root.left

        

    def next(self) -> int:
        if len(self.stack):
            node=self.stack.pop()
            self._dfs(node.right)
            return node.val


    def hasNext(self) -> bool:
        return len(self.stack)!=0
        


# Your BSTIterator object will be instantiated and called as such:
# obj = BSTIterator(root)
# param_1 = obj.next()
# param_2 = obj.hasNext()
#############################################################################################################
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class BSTIterator:


    def __init__(self, root: Optional[TreeNode]):
        self.idx=0
        self.nums=[]
        self.le=0
        def inorder(root):
            if not root:return
            inorder(root.left)
            self.nums.append(root.val)
            self.le+=1
            inorder(root.right)
        inorder(root)

        

    def next(self) -> int:
        self.idx+=1
        return self.nums[self.idx-1]
        

    def hasNext(self) -> bool:
        return  self.idx<len(self.nums)
        


# Your BSTIterator object will be instantiated and called as such:
# obj = BSTIterator(root)
# param_1 = obj.next()
# param_2 = obj.hasNext()
