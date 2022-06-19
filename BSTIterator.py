
"""Approach0: Use a list or some other datastructure in your constructor to traverse and store all contents of the tree
and then return 1 item at a time from that. But a valid iterator needs to be able to handle dynamic nature of underlying data
structure. In this case Binary tree. So storing binary tree nodes in the list would not be sufficient. And invalid iterator."""

"""Approach 1: Controlled recursion using external stack
Use a dynamic iterator. We need to do inorder traversal for this iterator implementation. So use DFS to go to left subtree leaf. 
When user does call for next(), we check if stack hasNext() and then pop that value, push its right to stack using self.dfs(r.right)
and return value of r.
This way if anything apart from initial left subtree changes, iterator can still handle that dynamically, as it is at most storing just
one left most path and everything else is not stored in the stack. 

Iterator is data structure so we take amortized TC and SC.
TC O(1) for both next and hasNext
SC O(1) for both next and hasNext
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
        self.dfs(root)
    
    def dfs(self, root):
        while root:
            self.stack.append(root)
            root = root.left

    def next(self) -> int: # O(1) in best case, in worst case O(h) for dfs call
        if self.hasNext():
            r = self.stack.pop()
            self.dfs(r.right)
            return r.val

    def hasNext(self) -> bool:  # O(1)
        return len(self.stack) != 0


# Your BSTIterator object will be instantiated and called as such:
# obj = BSTIterator(root)
# param_1 = obj.next()
# param_2 = obj.hasNext()