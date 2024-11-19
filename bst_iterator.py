"Time Complexity is O(1)"

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class BSTIterator:

    def __init__(self, root: Optional[TreeNode]):
        # Initialize a stack to simulate in-order traversal
        self.stack = []
        # Push all the left children of the root onto the stack
        self._push_left(root)

    def _push_left(self, node: Optional[TreeNode]):
        # Helper function to push all left children onto the stack
        while node:
            self.stack.append(node)
            node = node.left

    def next(self) -> int:
        # Pop the smallest node from the stack
        node = self.stack.pop()
        # If the popped node has a right child, push all its left children
        if node.right:
            self._push_left(node.right)
        return node.val

    def hasNext(self) -> bool:
        # Return True if there are nodes left in the stack
        return len(self.stack) > 0



# Your BSTIterator object will be instantiated and called as such:
# obj = BSTIterator(root)
# param_1 = obj.next()
# param_2 = obj.hasNext()