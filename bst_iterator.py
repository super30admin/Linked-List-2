"""
// Time Complexity : Avg O(1) 
// Space Complexity : O(h)  //height of the tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Your code here along with comments explaining your approach
Algorithm explanation
BF - Inorder traversal put in queue and pop one element at call of next 
Two operations - next and hasNext
- Idea is to run the dfs on leftmost side of the tree (since we want next minimum)
- At call of next - pop the top node and run dfs_left on node.right
- hasNext - just check if stack is empty or no
"""
# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class BSTIterator(object):

    def __init__(self, root):
        """
        :type root: TreeNode
        """
        self.stk = []
        self.dfs(root)

    def next(self):
        """
        @return the next smallest number
        :rtype: int
        """
        root = self.stk.pop()
        self.dfs(root.right)
        return root.val

    def hasNext(self):
        """
        @return whether we have a next smallest number
        :rtype: bool
        """
        return True if self.stk else False
    
    def dfs(self,root):
        #self.stk = [root]
        while root:
            self.stk.append(root)
            root = root.left

# Your BSTIterator object will be instantiated and called as such:
# obj = BSTIterator(root)
# param_1 = obj.next()
# param_2 = obj.hasNext()