# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class BSTIterator:
    """Iterator over the nodes of a binary search tree (BST) that returns values in the ascending order."""
  
    def __init__(self, root: TreeNode):
        self.stack = []
        while root:
            self.stack.append(root)
            root = root.left

    def next(self) -> int:
        current_node = self.stack.pop()
        node = current_node.right
        while node:
            self.stack.append(node)
            node = node.left
        return current_node.val

    def hasNext(self) -> bool:
        return len(self.stack) > 0
