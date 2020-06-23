# Time Complexity : Average O(1) for next and hasNext
# Space Complexity : O(h), where h is the max height of the tree.
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no

# Your code here along with comments explaining your approach
class BSTIterator(object):
    # this problem utilises a dfs method to get one branch at a time
    # and return from the stack while performing dfs for every node popped.

    def __init__(self, root):
        self.stack = []
        self.dfs(root)

    # getting the smallest num and performing dfs on it
    def next(self):
        node = self.stack.pop()
        self.dfs(node.right)
        return node.val

    # check if stack is empty
    def hasNext(self):
        return len(self.stack) != 0

    # getting all of the left branch for a given node
    def dfs(self, root):
        while root != None:
            self.stack.append(root)
            root = root.left
