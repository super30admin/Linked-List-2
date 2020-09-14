# // Time Complexity : O(maxdepth)
# // Space Complexity : O(n)
# // Did this code successfully run on Leetcode : Yes 
# // Any problem you faced while coding this : No

# // Your code here along with comments explaining your approach: 

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

# Iterative approach
class BSTIterator:
    
    #initiate empty stack and our dfs on root
    def __init__(self, root: TreeNode):
        self.stack = []
        self.dfs(root)

    #Pop the top element on the stack which would be the leftmost node you are at.
    # Check if the popped node has a right value?
    # If it does, call dfs on it's right node and finally return 
    # The value of the next smallest number found
    def next(self) -> int:
        """
        @return the next smallest number
        """
        retVal = self.stack.pop()
        if retVal.right != None:
            self.dfs(retVal.right)
        
        return retVal.val
        
    #if the stack is not empty, there exists a next value so return True
    def hasNext(self) -> bool:
        """
        @return whether we have a next smallest number
        """
        if self.stack:
            return True
        return False
    
    # this iterates through the tree till the left most node and keeps adding nodes to the stack until we reach the lead node(root!=None)
    def dfs(self, root:TreeNode):
        while root != None:
            self.stack.append(root)
            root = root.left
        


# Your BSTIterator object will be instantiated and called as such:
# obj = BSTIterator(root)
# param_1 = obj.next()
# param_2 = obj.hasNext()