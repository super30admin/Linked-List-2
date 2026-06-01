class BSTIterator:
    def __init__(self, root):
        self.st = []
        self.dfs(root)

    def dfs(self, root):
        while root:
            self.st.append(root)
            root = root.left

    def next(self):
        temp = self.st.pop()
        self.dfs(temp.right)
        return temp.val

    def hasNext(self):
        return len(self.st) > 0

# Time: O(1), amortized
# Space: O(h)