# BST Iterator
# Time complexity : O(1) --> Average
# Space comlpexity : O(h)
# Leetcode : Solved and submitted

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class BSTIterator:

    # In the init function, we define an empty stack and call the dfs function with the root 
    def __init__(self, root: Optional[TreeNode]):
        self.stack = []
        self.dfs(root)
    
    # In this dfs function, we interate the root until there is no left node left or left node is null and push that element onto the stack
    def dfs(self, root):
        while root is not None:
            self.stack.append(root)
            root = root.left

    # next function pops the top element of the stack and returns it, while also calls thd dfs function on the right side of the popped values
    # so any root value will come only once in the iteration
    # This iteration is dynamic as we store the root or node itself and not just its value as reference can dynamically change
    def next(self) -> int:
        node = self.stack.pop()
        self.dfs(node.right)
        return node.val

    # This function checks if the stack is empty or not, which means that we have another node to iterate over or not
    def hasNext(self) -> bool:
        if len(self.stack) == 0:
            return False
        return True

# Your BSTIterator object will be instantiated and called as such:
# obj = BSTIterator(root)
# param_1 = obj.next()
# param_2 = obj.hasNext()
