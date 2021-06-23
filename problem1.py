# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class BSTIterator:

    def __init__(self, root: TreeNode):
        self.stack = []
        self.count = 0
        if root == None: return root
        
        def inorder(root):
            if root == None:
                return 
            inorder(root.left)
            self.stack.append(root.val)
            #print(self.stack)
            inorder(root.right)
        inorder(root)
            
    def next(self) -> int:
        if self.count >= len(self.stack):
            return False
        else:
            temp = self.stack[self.count]
            self.count +=1
            return temp
        

    def hasNext(self) -> bool:
        print(self.count)
        if self.count < len(self.stack) and self.stack[self.count] is not None:
            return True
        return False


# Your BSTIterator object will be instantiated and called as such:
# obj = BSTIterator(root)
# param_1 = obj.next()
# param_2 = obj.hasNext()


#Brute force with O(n) time and O(1) space