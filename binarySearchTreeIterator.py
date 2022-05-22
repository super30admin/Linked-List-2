'''
Time Complexity : hasNext 0(1); next() 0(1) --> avg cases 
Space Complexity : 0(h) i.e. height of the tree
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
'''
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class BSTIterator:

    def __init__(self, root: Optional[TreeNode]):
        # Initialize a recursion stack
        self.stack = []
        self.inorderDfs(root)
    
    def inorderDfs(self,node):
        while node != None:
            # push current node to the stack
            self.stack.append(node)
            node = node.left
            continue
    
    def next(self) -> int:
        if len(self.stack) > 0:
            
            # Pop the node from the stack
            node = self.stack.pop()
            
            # dfs on rhs of the node
            self.inorderDfs(node.right)
            
            return node.val

    def hasNext(self) -> bool:
        # Check if my stack is empty
        if len(self.stack) == 0:
            return False
        else:
            return True

# Your BSTIterator object will be instantiated and called as such:
# obj = BSTIterator(root)
# param_1 = obj.next()
# param_2 = obj.hasNext()