# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class BSTIterator:

    def __init__(self, root: Optional[TreeNode]):
        self.q = []
        self.dfs(root)
        
    def dfs(self,root):
        if(root == None):
            return
        
        self.q.append(root)
        self.dfs(root.left)

    def next(self) -> int:
        curr = self.q.pop()
        self.dfs(curr.right)
        return curr.val
        
        
        

    def hasNext(self) -> bool:
        if(self.q):
            return True
        else:
            return False
        


# Your BSTIterator object will be instantiated and called as such:
# obj = BSTIterator(root)
# param_1 = obj.next()
# param_2 = obj.hasNext()