"""
TC: leftmost_inorder_fun O(N)
     next O(1)
     hasNext O(1)
Space Complexity:O(h)

But problem statement says that the maximum space complexity of either of the functions should be O(h) where h is the height of the tree and for a well balanced BST, the height is usually O(NlogN).
"""

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class BSTIterator_CR:

    def __init__(self, root: TreeNode):
        self.inorder=[]
        self.leftmost_inorder_fun(root)
     
    
    def leftmost_inorder_fun(self,root):
        while root:
            self.inorder.append(root)
            root=root.left
            
    def next(self) -> int:
        """
        @return the next smallest number
        """
        top_node=self.inorder.pop()
        if top_node.right:
             self.leftmost_inorder_fun(top_node.right)
        return top_node.val

    def hasNext(self) -> bool:
        """
        @return whether we have a next smallest number
        """
        return len(self.inorder)>0


# Your BSTIterator object will be instantiated and called as such:
# obj = BSTIterator(root)
# param_1 = obj.next()
# param_2 = obj.hasNext()