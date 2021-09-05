# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
stack = []
class BSTIterator:
    """
    TC: O(number of total elements in the tree)
    SC: O(max height of the tree)
    """
    
    def dfs(self, root):
        while root != None:
            stack.append(root)
            root = root.left
        
    def __init__(self, root: Optional[TreeNode]):
        
        self.dfs(root)
        

    def next(self) -> int:
        # if the stack is empty
        if not self.hasNext():
            return -1
        
        root = stack.pop()
        self.dfs(root.right)
        
        return root.val

    def hasNext(self) -> bool:
        if len(stack) == 0:
            return False
        return True


# Your BSTIterator object will be instantiated and called as such:
# obj = BSTIterator(root)
# param_1 = obj.next()
# param_2 = obj.hasNext()