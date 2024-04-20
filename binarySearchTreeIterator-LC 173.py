# Time Complexity = O(1), for next() and hasNext() both
# Space Complexity = O(h), where h = height of tree (personal stack)


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class BSTIterator:

    def __init__(self, root: Optional[TreeNode]):
        self.stack = []
        self.dfs(root)
        
        
    def dfs(self, root): 
        # while root is not null, keep traversing towards the left side
        while root != None:
            self.stack.append(root)
            root = root.left
           
            

    def next(self) -> int:
        result = self.stack.pop()
        # Call dfs to check on the right root
        self.dfs(result.right)
        # Return the value of the node that pops when next() is called
        return result.val
    

    def hasNext(self) -> bool:
        # did not do self.stack == None, as when last element is popped out, the stack = [] and not none val
        if len(self.stack) == 0:
            return False
        else:
            return True


# Your BSTIterator object will be instantiated and called as such:
# obj = BSTIterator(root)
# param_1 = obj.next()
# param_2 = obj.hasNext()