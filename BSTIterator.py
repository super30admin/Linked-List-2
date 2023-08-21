# Time Complexity: next() - O(1) hasNext() - O(h)
# Space Complexity: O(h)

class BSTIterator:

    def __init__(self, root: Optional[TreeNode]):
        self.stack = []
        self.root = root
        self.dfs(self.root)

    def next(self) -> int:
        root = self.stack.pop()
        self.dfs(root.right)
        return root.val
        
    def hasNext(self) -> bool:
        return not len(self.stack)==0
        
    def dfs(self,root):
        while root:
            self.stack.append(root)
            root = root.left