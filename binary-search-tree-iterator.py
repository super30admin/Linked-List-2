''' Time Complexity : O(1) : amortized 
    Space Complexity : O(h) 
    Did this code successfully run on Leetcode : Yes
    Any problem you faced while coding this :  No

   Approach : Adding only elements which are needed for next()
'''
class BSTIterator:

    def __init__(self, root: Optional[TreeNode]):
        self.stack=[]
        self.dfs(root)

    def dfs(self,root):
        if root is None:
            return
        self.stack.append(root)
        self.dfs(root.left)

    def next(self) -> int:
        top = self.stack.pop()
        self.dfs(top.right)
        return top.val

    def hasNext(self) -> bool:
        return True if self.stack else False
        
