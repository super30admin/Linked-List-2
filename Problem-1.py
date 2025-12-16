# Time Complexity : O(n) for constructor due to full traversal, O(1) for each next() and hasNext().
# Space Complexity :O(n)
# Did this code successfully run on Leetcode :yes
# Any problem you faced while coding this :no


# Your code here along with comments explaining your approach
# Use a stack to simulate inorder traversal of the BST.
# Always push the leftmost path so the smallest element is on top.
# On next(), pop the node and process its right subtree.

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class BSTIterator:

    def __init__(self, root: Optional[TreeNode]):
        self.stack = []
        self.dfs(root)
    def dfs(self,root):
        while root:
            self.stack.append(root)
            root= root.left
    def next(self) -> int:
        temp = self.stack.pop()
        self.dfs(temp.right)
        return temp.val

    def hasNext(self) -> bool:
        return len(self.stack) != 0

        


# Your BSTIterator object will be instantiated and called as such:
# obj = BSTIterator(root)
# param_1 = obj.next()
# param_2 = obj.hasNext()