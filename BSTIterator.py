# Time Complexity : 
'''
1. goLeft
    # bestCase: O(1) there is no left
    # worstCase: O(N) skewed binary tree to left like linkedlist

2. next
    # bestCase: O(1) skewed binary tree to left like linkedlist
        Because all the work will be done in the constructor itself. In this method all we will have to do
        is pop out elements 
    # worstCase: top of stack having a right and the right having a really long tail to the left.

3. hasNext:O(1)

#####################
Over all ammortisation leads to O(1)
'''
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