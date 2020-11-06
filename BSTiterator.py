#Time Complexity : O(n) where n is number of elements in the tree
#Space Complexity : O(h)

#Did this code successfully run on Leetcode : Yes
#Three line explanation of solution in plain english: Since the smallest node is always the left most node, keep iterating till there is a left. Keeping the smallest value at the top of the stack. When the next() function is called, pop the stack, which will give the smallest node, which will be the next node and then check if there is a right child of it, if there is then iterate towards left most again and do the same thing again and again. You will always have the next element at the top of the stack this way.

#Your code here along with comments explaining your approach


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class BSTIterator:

    def __init__(self, root: TreeNode):
        self.stack = []
        self.dfs(root)

    def next(self) -> int:
        """
        @return the next smallest number
        """
        top = self.stack.pop()
        if top.right:
            self.dfs(top.right)
        return top.val

    def hasNext(self) -> bool:
        """
        @return whether we have a next smallest number
        """
        return self.stack

    def dfs(self, root):
        while root:
            self.stack.append(root)
            root = root.left

# Your BSTIterator object will be instantiated and called as such:
# obj = BSTIterator(root)
# param_1 = obj.next()
# param_2 = obj.hasNext()
