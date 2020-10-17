# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
"""
// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
"""
class BSTIterator:

    def __init__(self, root: TreeNode):
        self.table = []
        self.inorder(root)
        
    def inorder(self, root):
        
        if root:
            self.inorder(root.left)
            self.table.append(root.val)
            self.inorder(root.right)
            

    def next(self) -> int:
        """
        @return the next smallest number
        """
        return self.table.pop(0)
        

    def hasNext(self) -> bool:
        """
        @return whether we have a next smallest number
        """
        return len(self.table) > 0
        


# Your BSTIterator object will be instantiated and called as such:
# obj = BSTIterator(root)
# param_1 = obj.next()
# param_2 = obj.hasNext()