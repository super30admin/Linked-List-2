class BSTIterator:

    def __init__(self, root: TreeNode):
        self.s=[]
        self.dfs(root)
        
    def next(self) -> int:
        curr=self.s.pop()
        self.dfs(curr.right)
        return curr.val
    
    def hasNext(self) -> bool:
        return self.s
    
    def dfs(self,root):
        while root:
            self.s.append(root)
            root=root.left