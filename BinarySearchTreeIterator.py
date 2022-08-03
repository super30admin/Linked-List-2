# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class BSTIterator:
    stack = []
    def __init__(self, root: Optional[TreeNode]):
        self.s = []
        self.dfs(root)
        
    def dfs(self,root):
        if(root is None):
            return
        self.s.append(root)
        self.dfs(root.left)
        
    def next(self) -> int:
        res = self.s.pop()
        self.dfs(res.right)
        return res.val
        

    def hasNext(self) -> bool:
        if(len(self.s)==0):
            return False
        return True
        


# Your BSTIterator object will be instantiated and called as such:
# obj = BSTIterator(root)
# param_1 = obj.next()
# param_2 = obj.hasNext()