# Time Complexity : O(N) Not sure
# Space Complexity : O(1)

# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : I don't know whether this is optimised solution

# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class BSTIterator:

    def __init__(self, root: TreeNode):
        self.ans = []
        
        def traverse(node):
            if node:
                traverse(node.left)
                self.ans.append(node.val)
                traverse(node.right)            
        
        traverse(root)
        print(self.ans)

    def next(self) -> int:
        """
        @return the next smallest number
        """
        start = self.ans[0] 
        self.ans.pop(0)
        return start
        

    def hasNext(self) -> bool:
        """
        @return whether we have a next smallest number
        """
        return self.ans
        


# Your BSTIterator object will be instantiated and called as such:
# obj = BSTIterator(root)
# param_1 = obj.next()
# param_2 = obj.hasNext()