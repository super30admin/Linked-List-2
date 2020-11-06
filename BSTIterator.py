"""
TC: inorder O(N)
     next O(1)
     hasNext O(1)
Space Complexity:O(N)

But problem statement says that the maximum space complexity of either of the functions should be O(h) where h is the height of the tree and for a well balanced BST, the height is usually O(NlogN).
"""

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class BSTIterator:

    def __init__(self, root: TreeNode):
        self.inorder=[]
        self.idx=-1
        self.inorder_fun(root)
     
    
    def inorder_fun(self,root):
        if not root:
            return 
        self.inorder_fun(root.left)
        self.inorder.append(root.val)
        self.inorder_fun(root.right)
        
    def next(self) -> int:
        """
        @return the next smallest number
        """
        self.idx += 1
        return self.inorder[self.idx]

    def hasNext(self) -> bool:
        """
        @return whether we have a next smallest number
        """
        return self.idx + 1 < len(self.inorder)


# Your BSTIterator object will be instantiated and called as such:
# obj = BSTIterator(root)
# param_1 = obj.next()
# param_2 = obj.hasNext()