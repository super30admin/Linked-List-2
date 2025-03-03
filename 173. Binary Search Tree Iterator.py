#time: O(n)
#space: O(h)
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class BSTIterator:

    def __init__(self, root: Optional[TreeNode]):
        self.st= list()
        self.dfs(root)

        

    def next(self) -> int:
        if len(self.st) != 0:
            node= self.st.pop(-1)
            self.dfs(node.right)
            return node.val
        return None
        

    def hasNext(self) -> bool:
        if len(self.st) != 0:
            return True
        else:
            return False
    
    def dfs(self,root):
        if root is None:
            return
        self.st.append(root)
        self.dfs(root.left)
        return root
        


# Your BSTIterator object will be instantiated and called as such:
# obj = BSTIterator(root)
# param_1 = obj.next()
# param_2 = obj.hasNext()
