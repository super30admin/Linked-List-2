# Time Complexity : O(1) Amortized
# Space Complexity : 
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


class BSTIterator:

    def __init__(self, root: Optional[TreeNode]):
        self.stack = []
        self.goLeft(root)
        
    def goLeft(self, curr):
        while curr:
            self.stack.append(curr)
            curr = curr.left
            
    def next(self) -> int:
        poppedEle = self.stack.pop()
        if poppedEle.right:
            self.goLeft(poppedEle.right)
        
        return poppedEle.val

    def hasNext(self) -> bool:
        return self.stack