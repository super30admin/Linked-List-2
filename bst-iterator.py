# Time O(n)
# Space O(n)
class BSTIterator:

    def __init__(self, root: Optional[TreeNode]):
        self.stack = []
        self.dfs(root)
    
    def dfs(self, root):
        while root != None:
            self.stack.append(root)
            root = root.left

    def next(self) -> int:
        res = self.stack.pop()
        self.dfs(res.right)
        return res.val

    def hasNext(self) -> bool:
        return False if len(self.stack) == 0 else True
