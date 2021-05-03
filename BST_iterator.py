# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

# Time - O(1) for both operations worst case O(H) does not happen often
# Space - O(H) always stack maintains nodes of up till H height
class BSTIterator:

    def __init__(self, root: TreeNode):
        self.st = []
        self.dfs(root)
        

    def next(self) -> int:
        # controlled recursion -- instead of dfs function for inorder originally
        # recursing on left, then pop, then right -- we control it here by doing left alone, only after popping val to be given out we move to right
        # top of stack always maintains the next element we want
        result = self.st.pop()
        
        # once we pop the node from top of stack, update what the 'next' call should point to -- recurse on right
        self.dfs(result.right)
        
        return result.val
        

    def hasNext(self) -> bool:
        if self.st:
            return True
        else:
            return False
    
    
    def dfs(self, root):
        
        # this is part of the original dfs/iterative solution for inorder -- inner while loop for left node processing alone
        while root != None:
            self.st.append(root)
            
            root = root.left
        


# Your BSTIterator object will be instantiated and called as such:
# obj = BSTIterator(root)
# param_1 = obj.next()
# param_2 = obj.hasNext()