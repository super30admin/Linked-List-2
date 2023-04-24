'''
Approach
--------
Here we use Stack to traverse in-order since in recursion we cannot stop at a point


Complexity Analysis
-------------------
TC = O(1) for next() and O(1) for hasNext()
SC = O(h) since we maximum number of nodes = the height of the tree, at any given time
'''


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class BSTIterator:
    def iter(self, node):
        while node:
            self.stack.append(node)
            node = node.left

    def __init__(self, root: Optional[TreeNode]):
        self.root = root
        self.stack = []
        self.iter(root)
            

    def next(self) -> int:
        if self.hasNext():
            node = self.stack.pop()
            self.iter(node.right)
            return node.val
        return -1
    def hasNext(self) -> bool:
        return len(self.stack) > 0
        


# Your BSTIterator object will be instantiated and called as such:
# obj = BSTIterator(root)
# param_1 = obj.next()
# param_2 = obj.hasNext()