# Time Complexity : O(1) for each operation.
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : NA

# Approach is to implement the iterator using dfs solution.

class BSTIterator:
    
    def __init__(self, root: Optional[TreeNode]):
        self.l=[]
        self.dfs(root)
    
    def dfs(self, root):
        while(root!=None):
            self.l.append(root)
            root= root.left
        

    def next(self) -> int:
        curr=self.l.pop()
        if(curr.right):
            self.dfs(curr.right)
        return curr.val

    def hasNext(self) -> bool:
        if(len(self.l) != 0):
            return True
        return False