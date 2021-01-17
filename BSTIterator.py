# Time Complexity : O(N)
# Space Complexity : O(N)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach
# Initialize a stack and perform inorder traversal on BST in init() and push it to the stack, it will contain a sorted list.
# In the next function, if the stack is not empty, pop the first element from the stack
# In the hasNext function, check if the stack is not empty return True else return False


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class BSTIterator:
    def __init__(self, root: TreeNode):
        self.stack = []

        def inorder(root):
            res = []
            stack = [(root, False)]
            while stack:
                node, visited = stack.pop()
                if node:
                    if visited:
                        res.append(node.val)
                    else:
                        stack.append((node.right, False))
                        stack.append((node, True))
                        stack.append((node.left, False))
            return res

        self.stack = inorder(root)
        print(self.stack)

    def next(self) -> int:
        if self.stack:
            return self.stack.pop(0)

    def hasNext(self) -> bool:
        if self.stack:
            return True
        return False


# Your BSTIterator object will be instantiated and called as such:
# obj = BSTIterator(root)
# param_1 = obj.next()
# param_2 = obj.hasNext()