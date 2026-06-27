## Problem1 (https://leetcode.com/problems/binary-search-tree-iterator/)
# ==========================================
# Time and Space Complexity Analysis
# ==========================================
# Time Complexity:
# - __init__(root): O(h), where h is the height of the tree. It traverses down 
#   the left spine of the tree to initialize the stack.
# - next(): Amortized O(1). Although calling self.inorder(root.right) can 
#   theoretically take O(h) time in the worst case, each node in the entire BST 
#   is pushed to and popped from the stack exactly once during the full traversal. 
#   Therefore, the average time per next() call across the whole tree is O(1).
# - hasNext(): O(1). It's a simple length check on the stack.
#
# Space Complexity: 
# - O(h), where h is the height of the tree. At any given time, the stack only 
#   stores nodes along a single path from the root down to a leaf. It never 
#   stores the entire tree at once, making it highly memory efficient.
# ==========================================

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class BSTIterator:
    def __init__(self, root: Optional[TreeNode]):
        # Initialize the stack that will simulate our recursive call stack.
        self.stack = []
        # Populate the stack with the left-most path starting from the root.
        # This ensures the smallest element is at the top of the stack.
        self.inorder(root)

    def inorder(self, root: Optional[TreeNode]):
        # This helper method pushes the current node and all its left children 
        # onto the stack. We don't process the right children yet; we wait 
        # until the parent node is popped in next().
        if root is not None:
            self.stack.append(root)
            self.inorder(root.left)

    def next(self) -> int:
        # The top of the stack always holds the next smallest element in the BST.
        root = self.stack.pop()
        
        # Before returning the value, we need to prepare the stack for future calls.
        # If the popped node has a right subtree, the next smallest elements 
        # will be the left-most path of that right subtree.
        self.inorder(root.right)
        
        return root.val

    def hasNext(self) -> bool:
        # If the stack has elements, there are still nodes left to traverse.
        return len(self.stack) > 0

# Your BSTIterator object will be instantiated and called as such:
# obj = BSTIterator(root)
# param_1 = obj.next()
# param_2 = obj.hasNext()