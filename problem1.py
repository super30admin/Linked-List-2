# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

# Approach:
# The BSTIterator is implemented to simulate an in-order traversal of a Binary Search Tree (BST).
# 1. The constructor initializes a stack that stores nodes from the root down the leftmost path.
# 2. The `next()` function returns the next smallest element in the tree, popping the top element 
#    from the stack and, if the node has a right child, pushing all the left descendants of the 
#    right child onto the stack.
# 3. The `hasNext()` function checks if there are any nodes left in the stack.
# 
# Time Complexity:
# - `next()`: Average O(1). Each node is processed exactly once, and traversing the left path happens 
#   only once for each node.
# - `hasNext()`: O(1), as it just checks if the stack is non-empty.
# 
# Space Complexity:
# - O(h), where h is the height of the tree. This is the space required for the stack to store the 
#   nodes along the leftmost path of the tree.

class BSTIterator(object):

    def __init__(self, root):
        self.stack = []
        while root:
            self.stack.append(root)
            root = root.left
        

    def next(self):
        res = self.stack.pop()
        cur = res.right
        while cur:
            self.stack.append(cur)
            cur = cur.left

        return res.val
        

    def hasNext(self):
        return self.stack != []
        

# Your BSTIterator object will be instantiated and called as such:
# obj = BSTIterator(root)
# param_1 = obj.next()
# param_2 = obj.hasNext()
