#Time complexity O(n), space complexityO(n)

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class BSTIterator:
#initializing data structure
    def __init__(self, root: Optional[TreeNode]):
        self.stack=[]
        self.dfs(root)

    def next(self) -> int:
        root = self.stack.pop()        
        self.dfs(root.right)
        
        return root.val

    def hasNext(self) -> bool:
        return len(self.stack)>0
        
 #inorder tarversal       
    def dfs(self,root):
        
        if root is None:
            return None
        self.stack.append(root)
        self.dfs(root.left)
        


# Your BSTIterator object will be instantiated and called as such:
# obj = BSTIterator(root)
# param_1 = obj.next()
# param_2 = obj.hasNext()
