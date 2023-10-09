# Time Complexity: O(n)
# Space Complexity: O(1)

class BSTIterator:
    def __init__(self, root):
        self.st = []
        self._dfs(root)

    def _dfs(self, root):
        while root:
            self.st.append(root)
            root = root.left

    def next(self):
        curr = self.st.pop()
        self._dfs(curr.right)
        return curr.val

    def hasNext(self):
        return len(self.st) > 0