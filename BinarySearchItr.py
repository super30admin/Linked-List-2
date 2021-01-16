'''
    Time Complexity:
        O(1) on an average.
        O(h) worst case.

    Space Complexity:
        O(h)

    Did this code successfully run on LeetCode?:
        Yes

    Problems faced while coding this:
        None

    Approach:
        Iterator approach.
'''
class BSTIterator:
    def __init__(self, root: TreeNode):
        self.storage = []
        self._dfs(root)

    def next(self) -> int:
        nxt = self.storage.pop()
        self._dfs(nxt.right)
        return nxt.val

    def hasNext(self) -> bool:
        return len(self.storage) > 0

    def _dfs(self, root):
        if root is None:
            return

        self.storage.append(root)
        self._dfs(root.left)
