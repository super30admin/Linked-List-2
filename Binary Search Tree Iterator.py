# time complexity is o(1)
# space complexity is o(n), where n is the size of the input
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class BSTIterator:

    def __init__(self, root: Optional[TreeNode]):
        self.stack = list()
        self.dfs(root)
        
    def dfs(self, root):
        while(root != None):
            self.stack.append(root)
            root = root.left
        
    def next(self) -> int:
        curr = self.stack.pop()
        temp = curr.val
        self.dfs(curr.right)
        return temp

    def hasNext(self) -> bool:
        return len(self.stack) > 0
        


# Your BSTIterator object will be instantiated and called as such:
# obj = BSTIterator(root)
# param_1 = obj.next()
# param_2 = obj.hasNext()