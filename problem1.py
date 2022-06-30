# Time Complexity : O(1)
# Space Complexity : O(height)
# Did this code successfully run on Leetcode :
# Any problem you faced while coding this :


# Your code here along with comments explaining your approach
class BSTIterator:

    def __init__(self, root: Optional[TreeNode]):
        self.stack = []
        self.explore(root)
        

    def next(self) -> int:
        node = self.stack.pop()
        self.explore(node.right)
        return node.val

    def hasNext(self) -> bool:
        return len(self.stack) != 0
    
    def explore(self,node):
        while node != None:
            self.stack.append(node)
            node = node.left 