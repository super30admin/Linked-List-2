## Problem1 (https://leetcode.com/problems/binary-search-tree-iterator/)
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class BSTIterator:

    def __init__(self, root: TreeNode):
        dummy = TreeNode(-1)
        
        def helper(node):
            if not node:
                return None, None
            ll, lr = helper(node.left)
            rl, rr = helper(node.right)
            if lr: lr.right = node
            node.left = lr
            node.right = rl
            if rl: rl.left = node
            if not ll: ll = node
            if not rr: rr = node
            return ll, rr
        
        start, end = helper(root)
        dummy.right = start
        
        self.cur = dummy

    def next(self) -> int:
        self.cur = self.cur.right
        return self.cur.val

    def hasNext(self) -> bool:
        if self.cur.right:
            return True
        return False
    
    #Time Complexity: O(1)
    #Space complexity: O(1)