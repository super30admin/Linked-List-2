"""
Time - Amortixzed O(1) for next() O(1) for hasNext()
Space - O(H)
"""
class BSTIterator:

    def __init__(self, root: Optional[TreeNode]):
        self.stack = []
        self._push_left_branch(root)

    def _push_left_branch(self, node):
        while node:
            self.stack.append(node)
            node = node.left

    def next(self) -> int:
        node = self.stack.pop()
        val = node.val
        if node.right:
            self._push_left_branch(node.right)
        return val

    def hasNext(self) -> bool:
        return len(self.stack) > 0