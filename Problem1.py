'''
Problem: Binary Search Tree Iterator
Time Complexity: O(n), where n is given elements
Space Complexity: O(h), h is height of the tree
Did this code successfully run on Leetcode: Yes
Any problem you faced while coding this: No
Your code here along with comments explaining your approach:
        performed controlled recursion
        maintained a stack to store nodes
'''

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

    def dfs(self, root):
        while root:
            self.stack.append(root)   
            root = root.left

    def next(self) -> int:
        node = self.stack.pop()
        if node.right:
            self.dfs(node.right)
        return node.val
        

    def hasNext(self) -> bool:
        if len(self.stack)>0:
            return True
        else:
            return False
        


# Your BSTIterator object will be instantiated and called as such:
# obj = BSTIterator(root)
# param_1 = obj.next()
# param_2 = obj.hasNext()