# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class BSTIterator:

    def __init__(self, root: TreeNode):
        self.stack=[]
        self.addNode(root)
    def next(self) -> int:
        if self.hasNext():
            ele=self.stack.pop()
            if ele.right:
                self.addNode(ele.right)
           
            return ele.val
        return -1

    def hasNext(self) -> bool:
        if len(self.stack)==0:
            return False
        return True
    def addNode(self,root):
        if root:
            self.stack.append(root)
            if root.left:
                self.addNode(root.left)
     #Time O(1) amortized for both next and hasnext. In some case where we add left node it will be O(h), but that will not be for everycase
     #Space O(k),k =max node in stack
#     def __init__(self, root: TreeNode):
#         self.arr=[]
#         self.index=0
#         self.inorder(root)
#     def next(self) -> int:
#         if self.hasNext():
#             v=self.arr[self.index]
#             self.index+=1
#             return v
#         return -1

#     def hasNext(self) -> bool:
#         if len(self.arr)==0:
#             return False
#         if self.index<len(self.arr):
#             return True
#         return False
#     def inorder(self,root):
#         if root:
#             self.inorder(root.left)
#             self.arr.append(root.val)
#             self.inorder(root.right)
              #with Time O(n) for contructor in worst case
              #Space O(n)
        
# Your BSTIterator object will be instantiated and called as such:
# obj = BSTIterator(root)
# param_1 = obj.next()
# param_2 = obj.hasNext()
