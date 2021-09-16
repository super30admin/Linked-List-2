# // Time Complexity :O(n), O(1)[next,hasnext]
# // Space Complexity :O(h),O(1)
# // Did this code successfully run on Leetcode :yes
# // Any problem you faced while coding this :no


# // Your code here along with comments explaining your approach





# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class BSTIterator:

    def __init__(self, root: Optional[TreeNode]):
        self.st=[]
        self.dfs(root)
        

    def next(self) -> int:
        result=self.st.pop()
        
        self.dfs(result.right)
        return result.val
        
        

    def hasNext(self) -> bool:
        return not (self.st==[])
    def dfs(self,root):
        while root is not None:
            self.st.append(root)
            root=root.left
        
        


# Your BSTIterator object will be instantiated and called as such:
# obj = BSTIterator(root)
# param_1 = obj.next()
# param_2 = obj.hasNext()