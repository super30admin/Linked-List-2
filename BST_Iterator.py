// Time Complexity : O(H) for next function.
// Space Complexity : O(H)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach: dfs for left elements and popping




# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class BSTIterator:

    def __init__(self, root: TreeNode):
        self.st = []
        self.dfs(root)

    def next(self) -> int:
        """
        @return the next smallest number
        """
        ans:TreeNode = self.st.pop()
        if ans.right != None:
            self.dfs(ans.right)
            
        return ans.val

    def hasNext(self) -> bool:
        """
        @return whether we have a next smallest number
        """
        return self.st
    
    def dfs(self, root):
        while root != None:
            self.st.append(root)
            root = root.left
            
