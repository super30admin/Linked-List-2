# Time Complexity : Add - O(n)
# Space Complexity :O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
'''
1. I have used a control Recursion
2. On instantiation the left childern are pushed on to stack
3. When next is called the element is popped, and then its right child is pushed if it is not None

'''


from collections import deque
class BSTIterator:

    def __init__(self, root: TreeNode):
        
        self.stack = deque()
        if root:
            self.stack.append(root)
        
        while root is not None:
            root = root.left
            if root:
                self.stack.append(root)
            
    
    def _helper(self, root):
        
        while root is not None:
            self.stack.append(root)
            root = root.left

    def next(self) -> int:
        """
        @return the next smallest number
        """
        if self.stack:
            root = self.stack.pop()
            if root.right:
                self._helper(root.right)

            return root.val
        
        

    def hasNext(self) -> bool:
        """
        @return whether we have a next smallest number
        """
        
        if self.stack:
            return True
        return False
        

