# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

#Time complexity : O(N)
#Space complexity: O(h)

#Accepted on Leetcode 

#Approach:
#Use a form of DFS (Inorder) where each time an element is popped -> move right and add the corresponding entire LST to the list
#Thus stack will never be empty and we can use the stack for next() or hasNext()

class BSTIterator:
    stack = []

    def __init__(self, root: Optional[TreeNode]):
        BSTIterator.stack = []
        self.dfs(root)

    def next(self) -> int:
        elemToReturn = BSTIterator.stack.pop()
        if elemToReturn.right != None:
            self.dfs(elemToReturn.right)
        return elemToReturn.val
        
        

    def hasNext(self) -> bool:
        return len(BSTIterator.stack) > 0


    def dfs(self,root):
        while root != None:
            BSTIterator.stack.append(root)
            root = root.left