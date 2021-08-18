# Time Complexity : O(1)
# Space Complexity : O(h), where h is height of the tree
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : N/A


# Your code here along with comments explaining your approach
class BSTIterator:

    # Controlled Recursion where, we implement our stack for inorder, and maintain the current element at
    # the top of the stack
    def __init__(self, root: Optional[TreeNode]):
        self.stack = []

        # This code block maintains the next minimum element (i.e. next element for inorder)
        while root: 
            self.stack.append(root)
            root = root.left

    # We pop out the current element and maintain the stack's property of maintaining the next set of elements
    def next(self) -> int:
        top = self.stack.pop()
        
        if top.right:
            root = top.right
            while root: 
                self.stack.append(root)
                root = root.left
        return top.val
            
    # If there are next elements, they would already be in the stack
    def hasNext(self) -> bool:
        return self.stack
