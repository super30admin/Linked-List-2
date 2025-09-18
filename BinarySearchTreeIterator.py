# Time Complexity : O(N) where N is the number of nodes in the linked list
# Space Complexity : O(N) 
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach:
# We will do an inorder traversal of the BST and store the values in a list.
# We will maintain a pointer to the current index in the list.
# For next(), we will return the value at the current index and increment the index.
# For hasNext(), we will check if the current index is less than the length of the list.

from typing import Optional
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class BSTIterator:

    def __init__(self, root: Optional[TreeNode]):
        self.inorder = []
        self.i = 0
        def ino(root):
            if not root:
                return None
            ino(root.left)
            self.inorder.append(root.val)
            ino(root.right)
        ino(root)
    
    def next(self) -> int:
        res = self.inorder[self.i]
        self.i += 1
        return res
        

    def hasNext(self) -> bool:
        return self.i < len(self.inorder)
        


# Your BSTIterator object will be instantiated and called as such:
# obj = BSTIterator(root)
# param_1 = obj.next()
# param_2 = obj.hasNext()
