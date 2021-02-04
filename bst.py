# Time Complexity : O(1) on average , O(h) worst case.
# Space Complexity: O(h) : h: height of the tree
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class BSTIterator:

    def __init__(self, root: TreeNode):
        self.list1 = []
        self._helper(root)        

    def next(self) -> int:
        temp = self.list1.pop()
        self._helper(temp.right)
        return temp.val
        
    def hasNext(self) -> bool:
        return len(self.list1) > 0
    
    def _helper(self, root):
        if root is None:
            return

        self.list1.append(root)
        self._helper(root.left)

# Your BSTIterator object will be instantiated and called as such:
# obj = BSTIterator(root)
# param_1 = obj.next()
# param_2 = obj.hasNext()