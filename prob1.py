# Time Complexity : O(N) in worst case for next, but average O(1)
# Space Complexity : O(H) for physical recursion stack
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : Understanding the time complexity
# Your code here along with comments explaining your approach

# implement dfs using a physical stack out of the hood
# for next just return the value and do a right dfs call
# for hasNext check is the physical stack is empty or not
# using controlled recursion


from collections import deque

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class BSTIterator:
    
    def __init__(self, root):
        self.st = deque()
        self.dfs(root)
    
    def next(self):
        result = self.st.pop()
        self.dfs(result.right)
        return result.val

    def hasNext(self):
        return len(self.st) != 0
    
    def dfs(self, root):
        while root is not None:
            self.st.append(root)
            root = root.left
