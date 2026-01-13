# Time: O(n) for making the array and both operations are done in O(1)
# Space: O(n) for making the array

# While doing an in order traversal on the tree append all the elements in an array
# Then have a index pointer to do the next() and hasNext() calls.
# NOT THE CORRECT APPROACH (THIS IS NOT AN ITERATOR)
class BSTIterator:
    def helper(self,root,arr):
        if root == None:
            return
        
        self.helper(root.left,arr)
        arr.append(root.val)
        self.helper(root.right,arr)

    def __init__(self, root: Optional[TreeNode]):
        self.arr = []
        self.helper(root,self.arr)
        self.idx = 0

    def next(self) -> int:
        res = self.arr[self.idx]
        self.idx += 1
        return res
    
    def hasNext(self) -> bool:
        return self.idx < len(self.arr)

# Time: Ammortised O(1) for next and hasNext for init it will be O(h)=> worst case O(n)
# Space: O(1)

# Controlled recursion
# Do the left call first so that the stack is at the left most node
# Then when we call next we just pop the element from the end and then do a right recursive call on it
# We return False if the stack is empty else we return True
class BSTIterator:

    def __init__(self, root: Optional[TreeNode]):
        self.stack= []
        self.helper(root)

    def next(self) -> int:
        res = self.stack.pop()
        self.helper(res.right)
        return res.val

    def hasNext(self) -> bool:
        return True if self.stack else False

    def helper(self,root):
        while root:
            self.stack.append(root)
            root = root.left