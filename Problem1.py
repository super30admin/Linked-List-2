"""
// Time Complexity : o(h) at constructor level, but avg - o(1), worst - o(h) 
// Space Complexity : o(h), stack size
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

--> controlled inorder traversal

// Your code here along with comments explaining your approach
"""


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class BSTIterator:

    def __init__(self, root: TreeNode):
        self.st = []
        self.dfs(root) #initialize the stack
        

    def next(self) -> int:
        """
        @return the next smallest number
        """
        root = self.st.pop() #get current node, which will be at the top of the stack
        self.dfs(root.right) #add the right child
        return root.val
        

    def hasNext(self) -> bool:
        """
        @return whether we have a next smallest number
        """
        if self.st: #if a next smallest number exist, the stack will have elements in it
            return True
        return False
    
    def dfs(self, root): #own function, to maintain stack at each instance 
        
        while root:
            self.st.append(root)
            root = root.left
            
        


# Your BSTIterator object will be instantiated and called as such:
# obj = BSTIterator(root)
# param_1 = obj.next()
# param_2 = obj.hasNext()