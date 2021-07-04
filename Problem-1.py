# Time Complexity :O(1)
# Space Complexity :O(h)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no


# Your code here along with comments explaining your approach
class BSTIterator(object):

    def __init__(self, root):
        """
        :type root: TreeNode
        """
        #create a stack and put in it all noods from root till farthest left
        self.stack = []
        self.dfs(root)
        

    def next(self):
        """
        @return the next smallest number
        :rtype: int
        """
        #if next is asked pop it and dfs its right subtree
        sol = self.stack.pop()
        self.dfs(sol.right)
        return sol.val
        

    def hasNext(self):
        """
        @return whether we have a next smallest number
        :rtype: bool
        """
        #if stack is empty return false else return true
        return self.stack
    
    def dfs(self,root):
        while root:
            self.stack.append(root)
            root = root.left