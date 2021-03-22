# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None
# Time Complexity: O(n)
# Space Complexity: O(1)
class BSTIterator:

    def __init__(self, root: TreeNode):
        self.stack = []
        self.helper(root)
    def helper(self, root):
        while root != None:
            self.stack.append(root)
            root = root.left

    def next(self) -> int:
        pop_elem  = self.stack.pop()
        if(pop_elem.right):
            self.helper(pop_elem.right)
        return pop_elem.val
    
    def hasNext(self) -> bool:
        return len(self.stack) > 0
        
