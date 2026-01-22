# Time Complexity : O(1) amortized for next() and hasNext(), O(h) for initialization where h is height
# Space Complexity : O(h) for the stack
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Approach: Use a stack to store nodes for controlled inorder traversal.
# Initialize by pushing all left nodes from root. For next(), pop from stack, push all left nodes of right child.
# hasNext() checks if stack is non-empty.

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class BSTIterator:
    def __init__(self, root: Optional[TreeNode]):
        self.stack = []
        # Push all left nodes from root
        self._push_all_left(root)
    
    def _push_all_left(self, node):
        while node:
            self.stack.append(node)
            node = node.left
    
    def next(self) -> int:
        # Pop the smallest element
        node = self.stack.pop()
        # Push all left nodes of the right child
        if node.right:
            self._push_all_left(node.right)
        return node.val
    
    def hasNext(self) -> bool:
        return len(self.stack) > 0
