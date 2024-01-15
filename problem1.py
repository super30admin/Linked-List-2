# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : yes



# Definition for a binary tree node.
class TreeNode:
     def __init__(self, val=0, left=None, right=None):
         self.val = val
         self.left = left
         self.right = right
class BSTIterator:

    def __init__(self, root: [TreeNode]):
        self.stc = []
        self.pushleft(root)
    
    def pushleft(self, node):
        while node:
            self.stc.append(node)
            node = node.left

    def next(self) -> int:
        node = self.stc.pop()
        if node.right:
            self.pushleft(node.right)
        return node.val
        

    def hasNext(self) -> bool:
        return len(self.stc) > 0
        


# Your BSTIterator object will be instantiated and called as such:
# obj = BSTIterator(root)
# param_1 = obj.next()
# param_2 = obj.hasNext()