"""
Intuition: An iterator should NOT process all elements at a single pass
It can only process a few elements or a single element.

#####################################################################
Next Function
Amortized Time Complexity : O(1) 
Space Complexity : O(1)
#####################################################################
HasNext Function
Time Complexity : O(1) 
Space Complexity : O(1)
#####################################################################
HasNext Function
Time Complexity : O(1) 
Space Complexity : O(1)
"""

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class BSTIterator:

    def __init__(self, root: TreeNode):
        self.stack = []
        self.dfs(root)
    def next(self) -> int:
        node = self.stack.pop(-1)
        self.dfs(node.right)
        return node.val
    def hasNext(self) -> bool:
        return not len(self.stack)==0

    def dfs(self, node):
        while node != None:
            self.stack.append(node)
            node = node.left
        return 
        


# Your BSTIterator object will be instantiated and called as such:
# obj = BSTIterator(root)
# param_1 = obj.next()
# param_2 = obj.hasNext()