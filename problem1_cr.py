# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class BSTIterator:
    
    def inorder(self, root):
        while root != None:
            self.stack.append(root)
            root = root.left
    
    def __init__(self, root: TreeNode):
        self.stack = []
        if root == None: return root
        self.inorder(root)             
        
            
    def next(self) -> int:
        root = self.stack.pop()
        self.inorder(root.right)
        return root.val
        

    def hasNext(self) -> bool:
        # print(self.stack)
        if not self.stack:
            return False
        return True


# Your BSTIterator object will be instantiated and called as such:
# obj = BSTIterator(root)
# param_1 = obj.next()
# param_2 = obj.hasNext()

#Time complexity is O(h) since we are iterating over the height in the worst case scenario and average O(1)
#Space complexity is O(h)
#Controlled recursion approach is used