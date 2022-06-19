#Time Complexity: O(n)
#Space Complexity: O(n)
class BSTIterator:
    lst = []
    
    def __init__(self, root: Optional[TreeNode]):
        self.lst = []
        self.dfs(root)
        
    def next(self) -> int:
        el = self.lst.pop()
        self.dfs(el.right)
        return el.val
    
    def hasNext(self) -> bool:
        return len(self.lst) !=0
        
    def dfs(self,root):
        if root == None:
            return
        self.lst.append(root)
        self.dfs(root.left)
        
