'''
1. Maintain a stack to store the leftmost nodes of the tree
2. When next() is called, pop the topmost element from the stack and call dfs on its right child
3. When hasNext() is called, check if the stack is empty or not

TC: O(1) for hasNext() and O(H) for next() as we are calling dfs on the right child of the popped element - avg O(1)
SC: O(H) - stack space in next()
'''
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class BSTIterator:

    def __init__(self, root: Optional[TreeNode]):
        self.stack = []
        self.dfs(root)

    def next(self) -> int:
        root = self.stack.pop()
        self.dfs(root.right)
        return root.val


    def hasNext(self) -> bool:
        return len(self.stack)!=0
        
    def dfs(self,root):
        while root:
            self.stack.append(root)
            root = root.left

# Your BSTIterator object will be instantiated and called as such:
# obj = BSTIterator(root)
# param_1 = obj.next()
# param_2 = obj.hasNext()