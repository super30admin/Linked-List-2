
# 173. Binary Search Tree Iterator

# Code:

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class BSTIterator:

    def __init__(self, root: TreeNode):
        self.stk = []
        self.dfs(root)
        
    def dfs(self, root):
        # Store the left nodes into the stack
        while root:
            self.stk.append(root)
            root=root.left
        

    def next(self) -> int:
        """
        @return the next smallest number
        """
        # left most or right's left most
        temp = self.stk.pop()
        
        if temp.right:
            self.dfs(temp.right)
        
        return temp.val
        
        
        
    # if Stack is not empty, that means we have data inside the stack. So, returns True
    def hasNext(self) -> bool:
        """
        @return whether we have a next smallest number
        """
        return len(self.stk)!=0
        


# Your BSTIterator object will be instantiated and called as such:
# obj = BSTIterator(root)
# param_1 = obj.next()
# param_2 = obj.hasNext()


# Time complexity: O(N) 
# Space complexity: O(1)
# Accepted on Leetcode: Yes.