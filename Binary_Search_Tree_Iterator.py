# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class BSTIterator:
    stack = []
    def __init__(self, root: TreeNode):
        self.dfs(root)
        

    def next(self) -> int:
        if not self.hasNext():
            return -1
        
        popped = BSTIterator.stack.pop()
        self.dfs(popped.right)
        return popped.val
        
    
    def hasNext(self) -> bool:
        
        if BSTIterator.stack:
            return True
        return False
        
        
    def dfs(self,root):
        
        while root:
            BSTIterator.stack.append(root)
            root = root.left
            
    
# Your BSTIterator object will be instantiated and called as such:
# obj = BSTIterator(root)
# param_1 = obj.next()
# param_2 = obj.hasNext()
