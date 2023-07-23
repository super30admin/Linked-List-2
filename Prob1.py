# Time complexity : O(1), for next and hasnext functions. For 75% of the nodes, the time complexity is O(1)
# Space complexity : O(1)
# In method 2, we keep going left, whenever a next() call is made, we pop the topmost element and then check if topmost.right exists, if it does we had them to the stack. Essentially, process the right child at each level, only if needed. - LAZY EVALUATION

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class BSTIterator:
    
    # Method 1 - Flatten the BST and use an array. But this won't work in an interview.
    # def __init__(self, root: Optional[TreeNode]):
    #     self.arr=[]
    #     self.inorder(root)
    #     self.index=-1
    # def inorder(self,root):
    #     if not root:
    #         return
    #     self.inorder(root.left)
    #     self.arr.append(root.val)
    #     self.inorder(root.right)

    # def next(self) -> int:
    #     self.index+=1
    #     return self.arr[self.index]

    # def hasNext(self) -> bool:
    #     return len(self.arr)-1>self.index

    #Method 2 - Controlled Recursion
    def __init__(self, root: Optional[TreeNode]):
        self.st=[]
        self.leftmost_inorder(root)
    
    def leftmost_inorder(self,root):
        while root:
            self.st.append(root)
            root=root.left

    def next(self) -> int:
        top=self.st.pop()

        if top.right:
            self.leftmost_inorder(top.right)
        return top.val
    
    def hasNext(self) -> bool:
        return len(self.st)>0



# Your BSTIterator object will be instantiated and called as such:
# obj = BSTIterator(root)
# param_1 = obj.next()
# param_2 = obj.hasNext()