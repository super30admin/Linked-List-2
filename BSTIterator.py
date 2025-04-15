# This solution implements an iterator over a Binary Search Tree (BST) that returns elements in ascending order.
# It uses an explicit stack to simulate in-order traversal without recursion.
# The constructor initializes the stack with the leftmost path, and `next()` and `hasNext()` manage traversal efficiently.

# Time Complexity:
#   - `next()`: Amortized O(1) per operation over n calls (each node is pushed and popped once).
#   - `hasNext()`: O(1)
# Space Complexity: O(h), where h is the height of the BST (stack holds at most h nodes at any time).

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class BSTIterator:

    def __init__(self, root: Optional[TreeNode]):
        self.stack = []
        self.dfs(root)
    
    def dfs(self, root):
        while root:
            self.stack.append(root)
            root = root.left

    def next(self) -> int:
        root = self.stack.pop()
        self.dfs(root.right)
        return root.val

    def hasNext(self) -> bool:
        return len(self.stack) != 0


# Your BSTIterator object will be instantiated and called as such:
# obj = BSTIterator(root)
# param_1 = obj.next()
# param_2 = obj.hasNext()
