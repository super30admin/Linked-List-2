# https://leetcode.com/problems/binary-search-tree-iterator/

# Time complexity: O(1) 
# Space complexity: O(n)
# Explanation: Use dfs to store in right order. Then either retur next element or check if next element exists.

class BSTIterator:
    def __init__(self, root):
        self.list = []
        self.idx = 0
        self.dfs(root)

    def dfs(self, root):
        if not root:
            return
        self.dfs(root.left)
        self.list.append(root.val)
        self.dfs(root.right)

    def next(self):
        val = self.list[self.idx]
        self.idx += 1
        return val

    def hasNext(self):
        return self.idx < len(self.list)
