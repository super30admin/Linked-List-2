# Leetcode problem link : https://leetcode.com/problems/binary-search-tree-iterator/
# Time Complexity : O(n)
#  Space Complexity : O(1) 
#  Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach
'''
        Basic approach : O(n) => Create an array with inorder traversal of the array and keep track of current index
    
        Optimized approach: O(maxdepth) space => The smallest element in BST is the lftmost one so we can push all the elements till the leftmost one in stack and keep popping every element and check for its right subtree and push its left branch elements. Repeat.
    '''  

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class BSTIterator:

    def __init__(self, root: TreeNode):
        self.stack = []
        self._dfs(root)
    
    def _dfs(self,root):
        while root:
            self.stack.append(root)
            root = root.left

    def next(self) -> int:
        """
        @return the next smallest number
        """
        if not self.hasNext:
            return -1
        
        nextVal = self.stack.pop()
        if (nextVal.right):
            self._dfs(nextVal.right)
        
        return nextVal.val
        

    def hasNext(self) -> bool:
        """
        @return whether we have a next smallest number
        """
        return len(self.stack) != 0
# Your BSTIterator object will be instantiated and called as such:
# obj = BSTIterator(root)
# param_1 = obj.next()
# param_2 = obj.hasNext()