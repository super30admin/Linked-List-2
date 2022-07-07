# Time Complexity : O(n) O(n) for the inorder traversal
# Space Complexity : O(n) for the stack 
# Did this code successfully run on Leetcode : Yes
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class BSTIterator:

    def __init__(self, root: Optional[TreeNode]):
        self.stack = []
        self.get_inorder(root)


    def next(self) -> int:
        return self.stack.pop(0)


    def hasNext(self) -> bool:
        if self.stack:
            return True
        return False

    def get_inorder(self, node) -> None:
        if node:
            self.get_inorder(node.left)
            self.stack.append(node.val)
            self.get_inorder(node.right)



# Your BSTIterator object will be instantiated and called as such:
# obj = BSTIterator(root)
# param_1 = obj.next()
# param_2 = obj.hasNext()
