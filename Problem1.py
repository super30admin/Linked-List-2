# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
"""
173. Binary Search Tree Iterator
Time Complexity-Next - O(n)
hasNext - O(1)
Space Complexity - O(n)
Make a stack push elements from root to left most element in stack
If len(stack) > 0 hence for hasnext value does exist
To find next element pop top most element check if that value has right node then call dfs function we have created to push element from root to left most node
"""
class BSTIterator:

    def __init__(self, root: TreeNode):
        self.stack = []
        self.dfs(root)
        
    def dfs(self,root):
        while root != None:
            self.stack.append(root)
            root = root.left

    def next(self) -> int:
        if(not self.hasNext):
            return -1
        root = self.stack.pop()
        self.dfs(root.right)
        return root.val

    def hasNext(self) -> bool:
        return len(self.stack)

# Your BSTIterator object will be instantiated and called as such:
# obj = BSTIterator(root)
# param_1 = obj.next()
# param_2 = obj.hasNext()