# Iterator is the one which access ONLY the next value, it won't worry about the rest of the values.
# we cannot use array here since using array it will not fullfill the concept of iterator because in array we have access to all the elements through it's index.

# Time Complexity:  Avg. O(1)
# Space Complexity: O(H) -  Height of Recursive Stack
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class BSTIterator(object):

    def __init__(self, root):
        """
        :type root: TreeNode
        """
		# use of stack and  dfs funciton
        self.stack = []
        self.dfs(root)

    def next(self):
        """
        :rtype: int
        """
		# pop the result from the stack and see if it has right node if it does again call dfs and return result.val from stack
        result = self.stack.pop()
        self.dfs(result.right)
        return result.val

    def hasNext(self):
        """
        :rtype: bool
        """
		# check stack length 
        return len(self.stack) != 0
    
    # iterative method of dfs append left node of the tree into the stack 
    def dfs(self, root):
        while root != None:
            self.stack.append(root)
            root = root.left
