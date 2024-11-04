# Time Complexity : O(n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no
# Problem Name: Binary Search Tree Iterator


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class BSTIterator:

    def __init__(self, root: Optional[TreeNode]):
        self.idx = 0
        self.lst = []
        self.inorder(root)
    
    def inorder(self, root: Optional[TreeNode]):
        if root == None:
            return 

        self.inorder(root.left)
        self.lst.append(root.val)
        self.inorder(root.right)

    def next(self) -> int:
        result = self.lst[self.idx]
        self.idx += 1
        return result

    def hasNext(self) -> bool:
        return self.idx < len(self.lst)
        


# Your BSTIterator object will be instantiated and called as such:
# obj = BSTIterator(root)
# param_1 = obj.next()
# param_2 = obj.hasNext()