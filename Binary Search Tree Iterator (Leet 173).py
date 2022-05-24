

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class BSTIterator:
    stack = list()
    def __init__(self, root: Optional[TreeNode]):
        self.stack = list()
        self.dfs(root)

    #Space complexity: O(1)     
    #Time complexity: O(1)
    def next(self) -> int:
        to_ret = self.stack.pop()
        self.dfs(to_ret.right)
        return to_ret.val
        

    #Space complexity: O(1)     
    #Time complexity: O(1)
    def hasNext(self) -> bool:
        return len(self.stack) > 0
    
    
    def dfs(self, root):
        while root != None:
            self.stack.append(root)
            root = root.left


# Your BSTIterator object will be instantiated and called as such:
# obj = BSTIterator(root)
# param_1 = obj.next()
# param_2 = obj.hasNext()