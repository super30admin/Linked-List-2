from typing import Optional
from collections import deque
# Time Complexity : The given two methods takes an average time O(1)
# Space Complexity : O(h), where h is the height of the binary search tree
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : Nothing Specific

# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class BSTIterator:
    def LeftDFS(self,root)->None:
        while(root!=None):
            self.s.append(root)
            root=root.left
    def __init__(self, root: Optional[TreeNode]):
        self.s=deque()
        self.LeftDFS(root)
        #print(self.s)

    def next(self) -> int:
        top=self.s[-1]
        self.s.pop()
        self.LeftDFS(top.right)
        return top.val

    def hasNext(self) -> bool:
        return (len(self.s)!=0)


# Your BSTIterator object will be instantiated and called as such:
# obj = BSTIterator(root)
# param_1 = obj.next()
# param_2 = obj.hasNext()