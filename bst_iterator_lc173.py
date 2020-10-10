"""
Name: Srinidhi Bhat 
Did it run on LC: Yes

Time Complexity: O(n) - inorder traversal will take O(n)
Space Complexity: O(n) - extra list used to store the lists

Logic: inorder traversal of BSt gives sorted order of the elements, store that
in an additional list

maintain a global pointer, so that when next() is called
we know which element to return

for hasnext, we can compare gloabal pointers current value with length of 
array.
"""
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class BSTIterator:
    def inorder(self,root):
        if root is None:
            return
        self.inorder(root.left)
        self.nodes_sorted.append(root.val)
        self.inorder(root.right)
        
        
    def __init__(self, root: TreeNode):
        self.nodes_sorted = []
        self.pointer = -1
        
        self.inorder(root)

    def next(self) -> int:
        """
        @return the next smallest number
        """
        self.pointer+=1
        
        return self.nodes_sorted[self.pointer]
        

    def hasNext(self) -> bool:
        """
        @return whether we have a next smallest number
        """
        return self.pointer+1 < len(self.nodes_sorted)
        


# Your BSTIterator object will be instantiated and called as such:
# obj = BSTIterator(root)
# param_1 = obj.next()
# param_2 = obj.hasNext()