#Approach
#Maintain a stack to the store the left from the node
# if rnode popped has lright add all tgose right child left values to stack


#Complexities
#Time: O(1)
#Space:O(1)



# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
from typing import Optional


class BSTIterator:

    def __init__(self, root: Optional[TreeNode]):
        self.stack = []
        self.addLeft(root)

    def addLeft(self, node):
        temp = node
        while temp != None:
            self.stack.append(temp)
            temp = temp.left

    def next(self) -> int:
        poppedNode = self.stack.pop(-1)
        if poppedNode.right != None:
            self.addLeft(poppedNode.right)

        return poppedNode.val

    def hasNext(self) -> bool:
        if len(self.stack) > 0:
            return True
        else:
            return False

# Your BSTIterator object will be instantiated and called as such:
# obj = BSTIterator(root)
# param_1 = obj.next()
# param_2 = obj.hasNext()