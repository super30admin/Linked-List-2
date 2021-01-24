# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class BSTIterator:

    # We are taking stack to keep the left elements . This question could have been solved by doing inorder traversal
    # and storing them in a list and popping the elements in next and checking length of list for hasNext
    # Optimized Solution - We will use stack data structure and will keep left elements. When left element is popped, 
    # We will append right elements of the popped element tothe stack till we get to the leaf
    # Time Complexity - O(N) or the number of times next function has been called
    # Space Complexity - O(H) where H is the height of the tree . For unoptimized, its O(N)
    # This is basically iterative solution of inorder solution Inorder - Left Root Right
    def __init__(self, root: TreeNode):
        self.stack = [] 
        self.dfs(root) # To fill the stack initially
        

    def next(self) -> int:
        if (not(self.hasNext())):
            return -1
        
        node= self.stack.pop()
        if node.right:
            self.dfs(node.right)
        
        return node.val
        

    def hasNext(self) -> bool:
        return (len(self.stack) > 0)
        
    
    def dfs(self,root):
        while(root != None):
            self.stack.append(root)
            root=root.left
        


# Your BSTIterator object will be instantiated and called as such:
# obj = BSTIterator(root)
# param_1 = obj.next()
# param_2 = obj.hasNext()