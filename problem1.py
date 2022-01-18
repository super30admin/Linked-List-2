#Time Complexity O(H) - height of tree
#Space Complexity O(N)
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class BSTIterator:

    def __init__(self, root: Optional[TreeNode]):
        self.root = root
        self.stack = []
        self.dfs(self.root)
    def dfs(self,root):
        while root!=None:
            self.stack.append(root)
            root = root.left
        

    def next(self) -> int:
        element = self.stack.pop()
        self.dfs(element.right)
        return element.val
        

    def hasNext(self) -> bool:
        return len(self.stack) != 0
        


# Your BSTIterator object will be instantiated and called as such:
# obj = BSTIterator(root)
# param_1 = obj.next()
# param_2 = obj.hasNext()
