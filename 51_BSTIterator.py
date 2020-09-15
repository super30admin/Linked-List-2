# S30 Big N Problem #51 {Medium}

# LC - 173. 
# Binary Search Tree Iterator

# Time Complexity : O(n) n=no. of nodes in the tree
# Space Complexity : O(n) n=no. of nodes in the tree
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No 


# Approach
# Maintain a stack. Push the highest number at the bottom of the stack. 
# this can be done by traversing the right side of the tree first. 
# in the next(), pop the element from stack. the stack will have smallest number at top. 


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class BSTIterator:

    stack=[]
    def __init__(self, root: TreeNode):
        
        self.buildStack(root)
                
    def buildStack(self,root):
        
        if root is None:
            return 
        self.buildStack(root.right)
        self.stack.append(root.val)
        self.buildStack(root.left)
        
        
    def next(self) -> int:
        """
        @return the next smallest number
        """
        return self.stack.pop(-1)
        
    def hasNext(self) -> bool:
        """
        @return whether we have a next smallest number
        """
        
        if len(self.stack)==0:
            return False
        
        return True
        
# Your BSTIterator object will be instantiated and called as such:
# obj = BSTIterator(root)
# param_1 = obj.next()
# param_2 = obj.hasNext()