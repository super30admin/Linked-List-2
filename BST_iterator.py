# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach in three sentences only
"""
In this code we take the root node given to us and create a sorted list from it. After which we can check next and hasnext in O(1) time.
"""


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class BSTIterator:

    def __init__(self, root: Optional[TreeNode]):
        self.sorted = []

        self.index = -1

        self.inorder(root)

    def inorder(self, root):
        if root == None: return

        self.inorder(root.left)
        self.sorted.append(root.val)
        self.inorder(root.right)
        

    def next(self) -> int:
        self.index += 1
        return self.sorted[self.index]
        

    def hasNext(self) -> bool:
        return self.index + 1 < len(self.sorted)
        


# Your BSTIterator object will be instantiated and called as such:
# obj = BSTIterator(root)
# param_1 = obj.next()
# param_2 = obj.hasNext()