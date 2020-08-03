"""
Problem:
https://leetcode.com/problems/binary-search-tree-iterator/

Approach: 

1. Maintian a global stack and initially perform dfs on left of the root and put the let children in the stack
2. when next() function is called, pop from the stack, call the dfs() on the right child or the pooped node, then return popppedItem.vale
3. in the hasNext() function, just check if the stack is empty or not

"""

# Time Complexity : O(n) where n is the no of nodes in the BST
# Space Complexity : O(1) amortized cost 
# Did this code successfully run on Leetcode : yes	
# Any problem you faced while coding this : No


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class BSTIterator:
    st = []
    
    def dfs(self,root):
        while(root!=None):
            self.st.append(root)
            root = root.left

    def __init__(self, root: TreeNode):
        self.dfs(root)
    

    def next(self) -> int:
        """
        @return the next smallest number
        """
        poppedItem = self.st.pop()
        self.dfs(poppedItem.right)
        return poppedItem.val
        

    def hasNext(self) -> bool:
        """
        @return whether we have a next smallest number
        """
        return True if len(self.st)>0 else False
        

  