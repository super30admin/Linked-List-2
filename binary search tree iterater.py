#time complexity: O(1)
#space complexity: O(h)


class BSTIterator:

    def __init__(self, root: Optional[TreeNode]):
        self.stack = []
        self.dfs(root)
        

    def next(self) -> int:
        result = self.stack.pop()
        self.dfs(result.right)
        return result.val
        

    def hasNext(self) -> bool:
        return bool(self.stack)

    def dfs(self, root):
        while root:
            self.stack.append(root)
            root = root.left
