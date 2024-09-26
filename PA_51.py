#LC 173 - Binary Search Tree Iterator
#Time Complexity - O(n)
#Space Complexity - O(h)
# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class BSTIterator(object):

    def __init__(self, root):
        """
        :type root: TreeNode
        """
        self.stack = []
        self.dfs(root)    
    
    def dfs(self,root):
        while root:
            self.stack.append(root)
            root = root.left
    
    def next(self):
        """
        @return the next smallest number
        :rtype: int
        """
        ans = self.stack.pop()
        self.dfs(ans.right)
        return ans.val
        

    def hasNext(self):
        """
        @return whether we have a next smallest number
        :rtype: bool
        """
        return len(self.stack) > 0


# Your BSTIterator object will be instantiated and called as such:
# obj = BSTIterator(root)
# param_1 = obj.next()
# param_2 = obj.hasNext()