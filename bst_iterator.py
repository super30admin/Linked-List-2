def __init__(self, root: Optional[TreeNode]):
        self.st=[]
        self.dfs(root)
    def dfs(self,root):
        while root:
            self.st.append(root)
            root=root.left
                                             

    def next(self) -> int:
        temp=self.st.pop()
        self.dfs(temp.right)
        return temp.val
        

    def hasNext(self) -> bool:
        return len(self.st)>0
        
