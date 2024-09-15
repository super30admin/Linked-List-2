#binary search tree iterator
# // Time Complexity : O(1) asymptotically
# // Space Complexity : O(H) - height of the tree
# // Did this code successfully run on Leetcode :yes
# // Any problem you faced while coding this :no

class BSTIterator(object):

    def __init__(self, root):
        self.stack=[]
        self._dfs(root)
        
        """
        :type root: TreeNode
        """
    def _dfs(self, root):                                   #copy all the left nodes of the tree
        while(root):
            self.stack.append(root)                         
            root=root.left
        
        

    def next(self):
        root = self.stack.pop()                                         #pop the currernt top of the stack
        self._dfs(root.right)                                           #check if there is a right, if ues, add that then add all the left after that
        return root.val
        

    def hasNext(self):
        return self.stack