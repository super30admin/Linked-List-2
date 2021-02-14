# Time complexity: O(n)
# Space complexity: O(h) #maximum height
# Worked on leetcode: yes
# We use DFS to reach the left most node. During this, we keep on putting the element in the stack, and if
# a node does not have a left/ right child, we pop out that node from the stack.

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
        if self.hasNext():
            root = self.stack[-1]  # need to pop out also
            self.stack = self.stack[:-1]
            self.dfs(root.right)
            return root.val

        else:
            return -1

    def hasNext(self) -> bool:
        if len(self.stack) > 0:
            return True
        else:
            return False

    def dfs(self, root):
        while (root != None):
            self.stack.append(root)
            root = root.left

# Your BSTIterator object will be instantiated and called as such:
# obj = BSTIterator(root)
# param_1 = obj.next()
# param_2 = obj.hasNext()