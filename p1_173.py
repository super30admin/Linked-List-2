# 173. Binary Search Tree Iterator

# TC:
    # Constructor: O(h) where h is the height of the tree - we only traverse the left branch initially
    # next(): Amortized O(1) - each node is pushed and popped exactly once during the entire iteration
    # hasNext(): O(1) - just checking if the stack is empty

# SC: O(h) where h is the height of the tree - in the worst case, we store all nodes along the left branch

# Did this code successfully run on Leetcode: Yes

# Approach :
# This implementation uses an iterative approach with a stack to simulate in-order traversal:
# In the constructor:
    # Initialize an empty stack to track nodes
    # Call _leftmost_inorder to push all leftmost nodes to the stack
# The _leftmost_inorder helper method:
    # Takes a root node and pushes all nodes along the leftmost branch onto the stack
    # This creates the initial path for in-order traversal
# The next() method:
    # Pops the top node from the stack (the next smallest element)
    # If this node has a right child, adds all leftmost nodes of the right subtree to the stack
    # Returns the value of the popped node
# The hasNext() method:
    # Simply checks if the stack has any elements left

from typing import List, Optional

# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class BSTIterator:
    def __init__(self, root: Optional[TreeNode]):
        # Initialize an empty stack to simulate in-order traversal
        self.stack = []
        # Initialize the pointer to a non-existent smallest number
        self._leftmost_inorder(root)
    
    def _leftmost_inorder(self, root):
        # Push all nodes in the leftmost path onto the stack
        # This helps us track the in-order traversal path
        while root:
            self.stack.append(root)
            root = root.left
    
    def next(self) -> int:
        # Pop the next smallest element (top of stack)
        node = self.stack.pop()
        
        # If this node has a right child, add all left children of the right child
        # This prepares the stack for the next elements in in-order traversal
        if node.right:
            self._leftmost_inorder(node.right)
        
        # Return the value of the current node
        return node.val
    
    def hasNext(self) -> bool:
        # If stack has elements, there are more nodes to process
        return len(self.stack) > 0