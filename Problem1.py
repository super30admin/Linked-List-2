# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class BSTIterator:

    def __init__(self, root: Optional[TreeNode]):
        self.stack = []
        while root:
            self.stack.append(root)
            root = root.left

    def next(self) -> int:
        root = self.stack.pop()
        x = root.right
        while x:
            self.stack.append(x)
            x = x.left
        return root.val

    def hasNext(self) -> bool:
        return len(self.stack) > 0
