# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

# TC: O(1)
# SC: O(N)
# LeetCode: Y(https://leetcode.com/problems/binary-search-tree-iterator/)
# Approach: Use a stack to perform in-order traversal on the left of the root
#           That way top of the stack is the first element of inorder traversal
#           After calling next which will be on the top of the stack, it is important to add the nodes of the right subtree of that node on the stack. 
#       This is done because of the behavior of in-order traversal(Left-Root-Right)
class BSTIterator:

    def __init__(self, root: TreeNode):
        # intialize stack
        self.stack = []
        
        # populate stack by traversing the leftmost path of the tree
        self.dfs(root)
        

    def next(self) -> int:
        # next node
        poppedNode = self.stack.pop()
        
        # if there is a right subtree of the popped node then process the right subtree (order of processing nodes in Inorder Traversal)
        if poppedNode.right:
            self.dfs(poppedNode.right)
            
        return poppedNode.val
        

    def hasNext(self) -> bool:
        
        return len(self.stack) != 0
        
    def dfs(self, root) -> None:
        while root:
            self.stack.append(root)
            root = root.left
            
        


# Your BSTIterator object will be instantiated and called as such:
# obj = BSTIterator(root)
# param_1 = obj.next()
# param_2 = obj.hasNext()
