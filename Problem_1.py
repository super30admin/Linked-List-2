"""
Time Complexity : O(H), height of the tree
Space Complexity :O(n)
Did this code successfully run on Leetcode :
Any problem you faced while coding this :


Your code here along with comments explaining your approach

Problem1 (https://leetcode.com/problems/binary-search-tree-iterator/)
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
        curr = root
        # Adding the left child of the tree as the HasNext function should not return False
        while curr:
            self.stack.append(curr)
            curr = curr.left
        

    def next(self) -> int:
        # taking the top element of teh stack
        root = self.stack.pop()
        
        # checking if that node has a right child or not
        if root.right:
            curr = root.right
            while curr:
                self.stack.append(curr)
                curr = curr.left
            
        return root.val
        

    def hasNext(self) -> bool:
        return len(self.stack) != 0
        


# Your BSTIterator object will be instantiated and called as such:
# obj = BSTIterator(root)
# param_1 = obj.next()
# param_2 = obj.hasNext()