# Time complexity -> O(1)
# Space complexity -> O(h) where h is the height
class BSTIterator:
    stack = []
    def __init__(self, root: Optional[TreeNode]):
        self.dfs(root)

    def next(self) -> int:
        if self.hasNext():
            temp = BSTIterator.stack.pop()
            if temp.right:
                self.dfs(temp.right)
        
            return temp.val
        
    def hasNext(self) -> bool:
        return not BSTIterator.stack == []
    
    def dfs(self,root):
        while root:
            BSTIterator.stack += [root]
            root = root.left 