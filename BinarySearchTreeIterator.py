# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

# Approaoch: 

# 1) BSTIterator(): we will initialize a stack for dfs and a call to dfs() with root as an argument will be carried out. What dfs() does is it keeps going to extreme left of root that is passed and also appends every left element encountered in the stack. 

# 2) next(): for next() we will just pop the top most element from the stack which will be left most element in that branch and check for its right child. If right child is not empty then we will traverse again to the very left element in the branch and carry out the whole dfs() again  
# Time complexity: O(h); h = height of the tree

# 3) hasNext(): for this we just need to check if the stack is empty or not becuase every time we call next() first thing we do is return the top most element from stack.
# Time complexity: O(1)

# Space complexity:  O(h) ; h = height of the tree


class BSTIterator:

    def __init__(self, root: TreeNode):
        self.stack = []
        self.dfs(root)

    def next(self) -> int:
        node = self.stack.pop()
        if node.right != None:
            self.dfs(node.right)
            
        return node.val

    def hasNext(self) -> bool:
        return len(self.stack) != 0
    
    def dfs(self, root):
        while root:
            self.stack.append(root)
            root = root.left


# Your BSTIterator object will be instantiated and called as such:
# obj = BSTIterator(root)
# param_1 = obj.next()
# param_2 = obj.hasNext()