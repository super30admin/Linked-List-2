# 173. Binary Search Tree Iterator
#  https://leetcode.com/problems/binary-search-tree-iterator/

# Time Complexity: O(1)
# Space Complexiety: O(1)

# Logic: We will have a global stack that at any instant will have the entire left branch. 
# When next() is called we pop the stack and fill in the right branch. 
# hasNext() will check the length of the global stack.

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class BSTIterator:

    def __init__(self, root: Optional[TreeNode]):
        self.temp_stack = list()
        self._helper(root)
        
        
    def _helper(self,root):
        if root:
            self.temp_stack.append(root)
            self._helper(root.left)
    
    
    def next(self) -> int:
        nextval = self.temp_stack.pop()
        self._helper(nextval.right)
        
        return nextval.val

    def hasNext(self) -> bool:
        if len(self.temp_stack) != 0:
            return True
        return False

# Your BSTIterator object will be instantiated and called as such:
# obj = BSTIterator(root)
# param_1 = obj.next()
# param_2 = obj.hasNext()