"""
Problem: Binary Search Tree Iterator
Approach: Do a controlled inorder on the tree where we move to next node only when we want to. Use iterative inorder traversal for this.
t.c. => O(h) where h is the height of the tree for next op and O(1) for hasNext op
s.c. => O(1)
"""
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class BSTIterator:

    def __init__(self, root: Optional[TreeNode]):
        self.stack = []
        self.root = root
        self.ptr = -1
        self.goFillLeftNodes(root)
    
    def goFillLeftNodes(self, root):
        while root:
            self.stack.append(root)
            root = root.left

    def next(self) -> int:
        parent = self.stack.pop()
        if parent.right:
            self.goFillLeftNodes(parent.right)
        return parent.val

    def hasNext(self) -> bool:
        if self.stack:
            return True
        return False
        


# Your BSTIterator object will be instantiated and called as such:
# obj = BSTIterator(root)
# param_1 = obj.next()
# param_2 = obj.hasNext()