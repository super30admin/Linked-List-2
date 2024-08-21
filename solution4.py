# space: O(1)
# time: O(1)

# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    x_depth = 0
    y_depth = 0
    parent_x = None
    parent_y = None
    def isCousins(self, root, x, y):
        self.helper(root, 0, x, y, None)
        return (self.x_depth == self.y_depth) and (self.parent_x != self.parent_y)

    def helper(self, root, depth, x,y, parent):
        if root is None:
            return
        if root.val == x:
            self.x_depth = depth
            self.parent_x = parent
        if root.val == y:
            self.y_depth = depth
            self.parent_y = parent
        self.helper(root.left, depth+1, x,y, root)
        self.helper(root.right, depth+1, x,y, root)