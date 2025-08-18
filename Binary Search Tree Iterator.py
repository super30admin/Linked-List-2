# Time Complexity :O(1)
# Space Complexity :O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : None
# Your code here along with comments explaining your approach: This class implements an in-order iterator for a Binary Search Tree. The stack st holds the path of left nodes, and next() pops the next smallest node while pushing the left path of its right child. hasNext() simply checks if there are more nodes left to process.

class BSTIterator: 
    def __init__(self, root: Optional[TreeNode]):
        self.st = []
        self.dfs(root)

    def dfs(self, root):
        while root:
            self.st.append(root)
            root = root.left
        
    def next(self) -> int:
        temp = self.st.pop()
        self.dfs(temp.right)
        return temp.val

    def hasNext(self) -> bool:
        return len(self.st) > 0