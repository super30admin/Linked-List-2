# Problem1 (https://leetcode.com/problems/binary-search-tree-iterator/)
# Time Complexity: amortized O(1) per next() call, O(h) for hasNext() and constructor
# Space Complexity: O(h), where h = height of the tree
# Approach: Don't traverse the whole tree upfront. 
# Only push the leftmost path onto a stack at any given time. 
# Each next() pops the smallest unvisited node, then pushes the leftmost path of its right subtree so the next smallest is ready.

# Definition for a binary tree node.
# class TreeNode:
#   def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class BSTIterator:
    def __init__(self, root: Optional[TreeNode]):
        self.stack = []     # stack holds nodes waiting to be visited, smallest on top
        self.dfs(root)      # prime the stack with the leftmost path from root

    def dfs(self, root):
        # keep walking left and pushing every node we pass
        # this builds the path to the smallest unvisited value in this subtree
        while root:
            self.stack.append(root)   # save this node, we will visit it later
            root = root.left          # keep going left to find something smaller

    def next(self) -> int:
        temperory = self.stack.pop()       # this is the smallest unvisited node right now
        self.dfs(temperory.right)          # its right subtree might have the next smallest value, so queue up that left path now
        return temperory.val               # give back the value we just visited

    def hasNext(self) -> bool:
        # if anything is still sitting in the stack, there's a next value to give
        return len(self.stack) > 0


# Your BSTIterator object will be instantiated and called as such:
# obj = BSTIterator(root)
# param_1 = obj.next()
# param_2 = obj.hasNext()