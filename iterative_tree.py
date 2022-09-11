# // Time Complexity : O(h)
# // Space Complexity : O(1)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this :

# Create a helper function and a stack
# Loop until we reach the leaf, and push the elemtn in the stack
# Iterate to the left
# In the next function pop the top element and then call the helper with the 
# right value
# return the root.val
# In the has next just return if stack is empty of not

# // Your code here along with comments explaining your approach


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class BSTIterator:

    def __init__(self, root: Optional[TreeNode]):
        self.stack=[]
        self.go_left(root)
        
    def go_left(self,node):
        while node:
            self.stack.append(node)
            node=node.left
            
    def next(self) -> int:
        node=self.stack.pop()
        self.go_left(node.right)
        return node.val

    def hasNext(self) -> bool:
        return len(self.stack)>0


# Your BSTIterator object will be instantiated and called as such:
# obj = BSTIterator(root)
# param_1 = obj.next()
# param_2 = obj.hasNext()