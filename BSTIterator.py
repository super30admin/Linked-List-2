# Time Complexity : O(N)  //Where n is the size of the list we are iterating
#  Space Complexity : O(N)  //We are using the stack to traverse 
#  Did this code successfully run on Leetcode : Yes
#  Any problem you faced while coding this : N/A

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class BSTIterator:

    def __init__(self, root: Optional[TreeNode]):
        #Base Case
        if root is None:
            return None
        
        #Declare stack to keep track
        self.stack = [root]
        while root.left is not None:
            root = root.left
            self.stack.append(root)

    def next(self) -> int:
        #Iterate to next value and append it to stack
        node = self.stack.pop()
        res = node.val
        if node.right is not None:
            self.stack.append(node.right)
            node = node.right
            while node.left is not None:
                self.stack.append(node.left)
                node = node.left
        return res

    def hasNext(self) -> bool:
        return len(self.stack) > 0

# Your BSTIterator object will be instantiated and called as such:
# obj = BSTIterator(root)
# param_1 = obj.next()
# param_2 = obj.hasNext()