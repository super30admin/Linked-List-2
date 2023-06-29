# Time Complexity :O(n)
# Space Complexity :O(h)
# Leet Code: Yes

class BSTIterator:

    def __init__(self, root: 'Optional[TreeNode]'):
        self.stack = []
        self._leftmost_inorder(root)

    def _leftmost_inorder(self, root):
        while root:
            self.stack.append(root)
            root = root.left

    def next(self) -> int:
        topmost_node = self.stack.pop()

        if topmost_node.right:
            self._leftmost_inorder(topmost_node.right)

        return topmost_node.val

    def hasNext(self) -> bool:
        return len(self.stack) > 0