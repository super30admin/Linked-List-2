#Time Complexity: O(1) for all functions
#Space Complexity: O(1)
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class BSTIterator:

    def __init__(self, root: Optional[TreeNode]):
        self.stack=[]
        self.dfs(root)
      
    def dfs(self,root):
        while root!=None:
            self.stack.append(root)
            root=(root.left)
        
    def next(self) -> int:
        curr=self.stack.pop()
        self.temp=curr.val
        self.dfs(curr.right)
        return self.temp

    def hasNext(self) -> bool:
        return len(self.stack)!=0


# Your BSTIterator object will be instantiated and called as such:
# obj = BSTIterator(root)
# param_1 = obj.next()
# param_2 = obj.hasNext()