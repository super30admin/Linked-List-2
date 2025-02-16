# Problem 1 : Binary Search Tree Iterator
# Time Complexity : 
'''
__init__ function - O(h)
next - O(1)
hasNext - O(1)

'''
# Space Complexity :
'''
__init__ - O(h)
next - O(h)
hasNext - O(1)
'''
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this :
'''
None
'''

# Your code here along with comments explaining your approach
from typing import Optional
# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class BSTIterator:

    def __init__(self, root: Optional[TreeNode]):
        # initialize the stack with all the nodes from root to left most node of the root
        self.stack = []

        while (root):
            self.stack.append(root)
            root = root.left
        

    def next(self) -> int:
        # top element of the stack will be the next smallest element so pop it from stack
        next_node = self.stack.pop()
        # If there is a right child of the node then push all the nodes from the right node to left most leaf node in the stack
        node = next_node.right
        while (node):
            self.stack.append(node)
            node = node.left
        # return the value of the smallest element
        return next_node.val
        

    def hasNext(self) -> bool:
        # if the length of the stack is greater than zero then return false else return true
        return len(self.stack) > 0
        


# Your BSTIterator object will be instantiated and called as such:
# obj = BSTIterator(root)
# param_1 = obj.next()
# param_2 = obj.hasNext()