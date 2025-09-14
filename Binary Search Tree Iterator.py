# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

'''
Iterative BST - As we need controlled recursion. 
Iterator should just keep the next element ready. As the real-time data streaming can 
get updated dynamically, iterator should not travverse through the entire tree all at 
once. 
Time Complexity: h= height of tree
    - Constructor: O(h) - One time operation
    - next: O(h) or Ammortized O(1) 
    - hasNext: O(1)
Space Complexity: 
    - bst_stack: O(h)
'''
class BSTIterator:

    def __init__(self, root: Optional[TreeNode]):
        self.bst_stack = [] 
        self.__inOrder(root)        

    def next(self) -> int:
        next_node = self.bst_stack.pop()
        self.__inOrder(next_node.right)
        return next_node.val

    def hasNext(self) -> bool:
        return len(self.bst_stack)!=0

    # private void helper function
    def __inOrder(self,node) -> None:
        while node!=None:
            self.bst_stack.append(node)
            node=node.left



# Your BSTIterator object will be instantiated and called as such:
# obj = BSTIterator(root)
# param_1 = obj.next()
# param_2 = obj.hasNext()



