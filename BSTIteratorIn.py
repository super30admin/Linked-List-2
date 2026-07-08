# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

# Your BSTIterator object will be instantiated and called as such:
# obj = BSTIterator(root)
# param_1 = obj.next()
# param_2 = obj.hasNext()

class BSTIterator:

    def __init__(self, root):
        self.stack = []
        self.dfs(root)

    def dfs(self, node):
        while node:
            self.stack.append(node)
            node = node.left

    def next(self):
        node = self.stack.pop()

        # After visiting node,
        # explore its right subtree
        self.dfs(node.right)

        return node.val

    def hasNext(self):
        return len(self.stack) > 0




# TC - O(1) Amortized
# SC - O(h)

# Operation	        Worst Case	Amortized
# next()	        O(h)	    O(1)
# hasNext()	        O(1)	    O(1)
# Initialization	O(h)	    O(h)
