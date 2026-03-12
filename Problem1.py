# Binary Search Tree Iterator

# Time complexity -> hasNext -> O1
# Time complexity -> next -> Oh (time take to fill the buffer)
# Space Complexity -> O(h) stack size 
# Keep a buffer moving to the left most node as that is smlaaest, when getting popped if the ndode 
# has right node refill the buffer untill we find last left after that right node

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class BSTIterator:

    def __init__(self, root: Optional[TreeNode]):
        self.buffer=[]
        self.fillBuffer(root)

    def next(self) -> int:
        nextNode = self.buffer.pop()
        if nextNode.right!=None:
            self.fillBuffer(nextNode.right)
        return nextNode.val

    def hasNext(self) -> bool:
        return len(self.buffer) > 0
        
    def fillBuffer(self, node):
        self.buffer.append(node)
        if node.left!=None:
            self.fillBuffer(node.left)


# Your BSTIterator object will be instantiated and called as such:
# obj = BSTIterator(root)
# param_1 = obj.next()
# param_2 = obj.hasNext()