# Binary Search Tree Iterator

# Time Complexity : O(N)
# Space Complexity : O(N)
# Did this code successfully run on Leetcode : Yes, with Runtime: 80 ms and Memory Usage: 20.5 MB 
# Any problem you faced while coding this : Initally yes, After class understanding no.
# Your code here along with comments explaining your approach
# Approach
"""
Using Recursive approach, By maintaining stack and traversing inorder such that
elements can be returned in sorted order. Starting with root and removing element
from stack when next() is called such that smallest element to largest element at
the end is returned. Helper function dfs will essentially add all the nodes in the l
eftmost branch of the tree rooted at the given node root to the stack and it will keep on doing so 
until there is no left child of the root node. hasNext checks whether the stack is empty or not.

"""
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class BSTIterator:
    def __init__(self, root: TreeNode):
        self.s=[] # Initializing an Empty Stack
        self.dfs(root) # calling recursive function
        
    def dfs(self,root:TreeNode):
        while(root is not None):
            self.s.append(root) 
            root=root.left
    def next(self) -> int:
        popped=self.s.pop()
        if(popped.right is not None):
            self.dfs(popped.right)
        return popped.val

    def hasNext(self) -> bool:
        return len(self.s)>0
   


# Your BSTIterator object will be instantiated and called as such:
# obj = BSTIterator(root)
# param_1 = obj.next()
# param_2 = obj.hasNext()


