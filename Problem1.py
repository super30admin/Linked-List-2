#Time Complexity: O(n)
#Space Complexity: O(1)
#LeetCode: Yes

class BSTIterator:
    def __init__(self, root):
        self.root = root
        self.stack = []
        self.dfs(self.root)

    def next(self):
        node = self.stack.pop()
        self.dfs(node)
        return node.val

    def hasNext(self):
        if self.stack:
            return True
        return False

    def dfs(self, root):
        while root:
            self.stack.append(root)
            root = root.left

