#time complexity :O(n)
#space complexity : O(1)
# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class BSTIterator(object):
    
    

    def __init__(self, root):
        self.myst = []
        self.dfs(root)
        
        """
        :type root: TreeNode
        """
        

    def next(self):
        res = self.myst.pop()
       
        self.dfs(res.right)
        return res.val
        """
        :rtype: int
        """
        

    def hasNext(self):
        if len(self.myst) == 0:
            return False
        
        return True
            
        """
        :rtype: bool
        """
    def dfs(self,root):
        while root is not None:
            self.myst.append(root)
            root = root.left
        


# Your BSTIterator object will be instantiated and called as such:
# obj = BSTIterator(root)
# param_1 = obj.next()
# param_2 = obj.hasNext()