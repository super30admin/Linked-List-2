# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
#time complexity:O(n)
#Space complexity::O(n)
# Initialize an empty array that will contain the nodes of the binary search tree in the sorted order.
# We traverse the binary search tree in the inorder fashion and for each node that we process, we add it to our array nodes. Note that before processing a node, its left subtree has to be processed (or recursed upon) and after processing a node, its right subtree has to be recursed upon.
# Once we have all the nodes in an array, we simply need a pointer or an index in that array to implement the two functions next and hasNext. Whenever there's a call to hasNext, we simply check if the index has reached the end of the array or not. For the call to next function, we simply return the element pointed by the index. Also, after a the next function call is made, we have to move the index one step forward to simulate the progress of our iterator.
class BSTIterator:

    def __init__(self, root: TreeNode):
        self.q=[]
        self.dfs(root)

    def next(self) -> int:
        """
        @return the next smallest number
        """
        curr=self.q.pop()
        self.dfs(curr.right)
        return curr.val
        

    def hasNext(self) -> bool:
        """
        @return whether we have a next smallest number
        """
        if not self.q:
            return False
        else:
            return True
        
    def dfs(self,root):
        while root:
            self.q.append(root)
            root=root.left


# Your BSTIterator object will be instantiated and called as such:
# obj = BSTIterator(root)
# param_1 = obj.next()
# param_2 = obj.hasNext()
