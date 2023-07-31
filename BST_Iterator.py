# Time Complexity :O(1)
# Space Complexity :O(H)
# Did this code successfully run on Leetcode : Yes

# Any problem you faced while coding this :

# Your code here along with comments explaining your approach



from collections import deque
class BSTIterator:

    def __init__(self, root: Optional[TreeNode]):
        self.st= deque([])
        self.node=root
        self.dfs(self.node)

    def next(self) -> int:
        node=self.st.pop()
        self.dfs(node.right)
        return node.val
        pass

    def hasNext(self) -> bool:
        l=len(self.st)
        if(l):
            return True
        return False
        pass
    
    def dfs(self, node):
        while(node):
            self.st.append(node)
            node=node.left