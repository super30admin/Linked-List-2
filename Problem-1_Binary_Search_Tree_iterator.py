# APPROACH  
# Time Complexity : O(h), h: height of BST, amortised: O(1)
# Space Complexity : O(h)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : None
#
#
# Your code here along with comments explaining your approach
# 1. Since it's an iterator, wont store the entire inorder traversal in extra space. Instead do one step at a time.
# 2. Initialise the stack by going till leftmost node of tree (smallest element of BST)
# 3. Each time next() is called, element is popped from stack and we run the traversal from it's right child till leftmost node of that subtree is reached
# 4. hasNext() checks the length of the stack


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class BSTIterator:

    def __init__(self, root: TreeNode):
        self.stack = []
        self.helper(root)
        
        
    def next(self) -> int:
        """
        @return the next smallest number
        """
        root = self.stack.pop()
        self.helper(root.right)
        
        return root.val
        

    def hasNext(self) -> bool:
        """
        @return whether we have a next smallest number
        """
        if len(self.stack) > 0:
            return True
        else:
            return False
        
        
    def helper(self, root):
        while root is not None:
            self.stack.append(root)
            root = root.left
                


# Your BSTIterator object will be instantiated and called as such:
# obj = BSTIterator(root)
# param_1 = obj.next()
# param_2 = obj.hasNext()
