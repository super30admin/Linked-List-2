# Time Complexity : O(n), where n is the number of nodes in the binary tree
# Space Complexity : O(h), where h is the height of the binary tree
# Did this code successfully run on Leetcode :
# Any problem you faced while coding this :

# Approach:
# We use a stack to store all the left nodes of the tree.
# When we call next(), we pop the top node from the stack and push it's right child and all its left children to the stack.
# The hasNext() function checks if there are any nodes left in the stack.
# This way, we can traverse the tree in an in-order fashion without using recursion.

# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class BSTIterator:
    # Constructor to initialize the iterator with the root of the BST
    def __init__(self, root):
        self.stack = []
        self.dfs(root)
    
    # Using DFS to traverse the left side of the tree and push all left nodes to the stack
    def dfs(self, root):
        if not root:
            return
        self.stack.append(root)
        self.dfs(root.left)

    # Function to return the next smallest number in the BST
    def next(self) -> int:
        # The next element will always be the top of the stack
        node = self.stack.pop()
        # If the popped node has a right child, we need to push all its left children to the stack
        if node.right:
            self.dfs(node.right)
        # Return the value of the popped node
        return node.val

    # Function to check if there are more elements in the BST
    def hasNext(self) -> bool:
        # If the stack is not empty, it means there are more elements to traverse
        # If the stack is empty, it means we have traversed all elements and there are no more elements left in the BST
        return True if self.stack else False
    

# Alternative approach using an array to store the in-order traversal of the BST
# This approach uses more space but is easier to understand

class BSTIterator:
    # Constructor to initialize the iterator with the root of the BST
    def __init__(self, root):
        # Using an array to store the in-order traversal of the BST
        self.arr = []
        self.dfs(root)
        # Pointer to keep track of the current position in the array
        self.p = 0
    
    # Using DFS to traverse the BST and store the in-order traversal in the array
    def dfs(self, root):
        if not root:
            return
        self.dfs(root.left)
        # Append the current node's value to the array
        # This will give us the in-order traversal of the BST
        self.arr.append(root.val)
        self.dfs(root.right)

    # Function to return the next smallest number in the BST
    def next(self) -> int:
        # The next element will always be the current position in the array
        node = self.arr[self.p]
        # Increment the pointer to move to the next element
        self.p += 1
        # Return the value of the current element
        return node  

    # Function to check if there are more elements in the BST
    def hasNext(self) -> bool:
        # If the pointer is equal to the length of the array, it means we have traversed all elements
        # If the pointer is less than the length of the array, it means there are more elements left to traverse
        if self.p == len(self.arr):
            return False
        else:
            return True