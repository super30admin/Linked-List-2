# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class BSTIterator:

    def dfs(self,root):
        while root:
            self.st.append(root)
            root=root.left
    
    def __init__(self, root: Optional[TreeNode]):
        self.st=[]
        self.dfs(root)

    def next(self) -> int:
        ret=self.st.pop()
        self.dfs(ret.right)
        return ret.val
        

    def hasNext(self) -> bool:
        return len(self.st)>0
        


# Your BSTIterator object will be instantiated and called as such:
# obj = BSTIterator(root)
# param_1 = obj.next()
# param_2 = obj.hasNext()