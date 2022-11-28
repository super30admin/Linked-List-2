#Time Complexity :- O(n)
#Space Complexity:- O(n)
#Appraoch :- O(1) for next O(1) for hasNext but here since we traverse all the nodes and store it in array we take O(n) 
# time complexity and since we are using an array to store all the elements space is also O(n)

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class BSTIterator:

    def __init__(self, root: Optional[TreeNode]):
        self.arrayData = []
        self.index = -1
        self.inorder(root)

    def inorder(self,root):
        if root is None:
            return
        self.inorder(root.left)
        self.arrayData.append(root.val)
        self.inorder(root.right)

    def next(self) -> int:
        self.index +=1
        return self.arrayData[self.index]

    def hasNext(self) -> bool:
        if self.index+1 < len(self.arrayData):
            return True
        else:
            return False
        


# Your BSTIterator object will be instantiated and called as such:
# obj = BSTIterator(root)
# param_1 = obj.next()
# param_2 = obj.hasNext()




### Another optimised approach

#Time Complexity :- O(n)
#Space Complexity:- O(h) height of the tree on which side we are traversiing
#Appraoch :- Here we use stack to restrict the reursive call and when needed then only we add the next element in the tree when it has right side 



# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class BSTIterator:

    def __init__(self, root: Optional[TreeNode]):
        self.stack = []
        self.leftSideTree(root)
    
    def leftSideTree(self, root):
        while root is not None:
            self.stack.append(root)
            root = root.left

    def next(self) -> int:
        popped = self.stack.pop()
        self.leftSideTree(popped.right)
        return popped.val
        

    def hasNext(self) -> bool:
        return len(self.stack) > 0
        


# Your BSTIterator object will be instantiated and called as such:
# obj = BSTIterator(root)
# param_1 = obj.next()
# param_2 = obj.hasNext()