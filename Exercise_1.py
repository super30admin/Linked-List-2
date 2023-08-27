# Problem1 (https://leetcode.com/problems/binary-search-tree-iterator/)
# // Time Complexity :O(1)
# // Space Complexity :O(1)
# // Did this code successfully run on Leetcode :Yes
# // Any problem you faced while coding this :No


# // Your code here along with comments explaining your approach

class BSTIterator:
    def __init__(self, root):
        # creating a stack to store all elements of the BST
        self.stack = []
        # applying dfs
        self.dfs(root)

    def dfs(self, root):
        # iterate to the leftmost leaf node
        while root:
            # keep appending to stack
            self.stack.append(root)
            root = root.left

    def next(self):
        # pop the last element from the stack
        curr = self.stack.pop()
        # when popped iterate to the right most leaf node
        self.dfs(curr.right)
        return curr.val

    def hasNext(self):
        return self.stack != []
