"""

    Student : Shahreen Shahjahan Psyche
    Time : next -> O(1) # on average
           hasNext -> O(1)
    Space : O(H) -> for my stackspace and the stack

    This code ran successfully for all the test cases in Leetcode


"""

# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class BSTIterator:

    # Initilizing
    def __init__(self, root: TreeNode):
        self.root = root
        self.curr = root
        self.stackSpace = []
        # As it is BST, my smallest number will be in leftmost child. So
        # when I am initiating the class, it will move the curr pointer
        # to the left most node and append all the nodes in a stack
        while(self.curr):
            self.stackSpace.append(self.curr)
            self.curr = self.curr.left 
            
    def next(self) -> int:
        """
        @return the next smallest number
        """
        # checking whether our iterator has gone out of bound
        if self.stackSpace:
            res = self.stackSpace.pop()
            # if my current element has right child, it need to save the 
            # nodes in the stackspace. So it is doing that
            if res.right:
                temp = res.right
                while(temp):
                    self.stackSpace.append(temp)
                    temp = temp.left
            return res.val
        else:
            return float('inf')
            

    def hasNext(self) -> bool:
        """
        @return whether we have a next smallest number
        """
        # if my stack is empty that means that I have no place to travarse
        # next
        if not self.stackSpace:
            return False
        else:
            return True


# Your BSTIterator object will be instantiated and called as such:
# obj = BSTIterator(root)
# param_1 = obj.next()
# param_2 = obj.hasNext()