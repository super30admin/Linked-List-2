# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
# Approach:
# The BSTIterator uses a stack to simulate the in-order traversal of the BST.
# During initialization, the leftmost branch of the tree is pushed onto the stack.
# The `next` method pops the top of the stack, processes the node, and pushes the leftmost branch of the right child.
# The `hasNext` method checks if the stack is non-empty, indicating more nodes to process.

# Time Complexity: 
# next(): O(1) on average, O(h) in the worst case (where h is the height of the tree).
# hasNext(): O(1)
# Space Complexity: O(h), where h is the height of the BST (due to the stack).

# Did this code successfully run on Leetcode: Yes
# Any problem you faced while coding this: No

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class BSTIterator:

    def __init__(self, root: TreeNode):
        self.stack = []
        self._push_left_branch(root)

    def _push_left_branch(self, node: TreeNode):
        # Push all nodes from the current node to the leftmost node onto the stack
        while node:
            self.stack.append(node)
            node = node.left

    def next(self) -> int:
        # The top node of the stack is the next smallest element
        next_node = self.stack.pop()
        # If there is a right subtree, process its leftmost branch
        if next_node.right:
            self._push_left_branch(next_node.right)
        return next_node.val

    def hasNext(self) -> bool:
        # Check if the stack is non-empty
        return len(self.stack) > 0

# Example usage:
# obj = BSTIterator(TreeNode(7, TreeNode(3), TreeNode(15, TreeNode(9), TreeNode(20))))
# print(obj.next())    # return 3
# print(obj.next())    # return 7
# print(obj.hasNext()) # return True
# print(obj.next())    # return 9
# print(obj.hasNext()) # return True
# print(obj.next())    # return 15
# print(obj.hasNext()) # return True
# print(obj.next())    # return 20
# print(obj.hasNext()) # return False

# Your BSTIterator object will be instantiated and called as such:
# obj = BSTIterator(root)
# param_1 = obj.next()
# param_2 = obj.hasNext()