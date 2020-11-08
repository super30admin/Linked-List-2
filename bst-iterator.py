# Time Complexity: O(1) for next()
# Space Complexity: O(height)
# Did it pass on Leetcode: Yes
# Approach:
# I am trying to simulate the recursive stack and program counter here.
# For a BST, the iterator returns ascending order so this is basically a "controlled" inorder traversal of the tree.
# When nodes are added to the recursive stack, they are visited 3 times - 
# - first time a node is seen - ARRIVAL (We would pop or process the node at this state for preorder)
# - second time in-order - INTERIM - (We would pop or process the node at this state for inorder)
# - third time - DEPARTURE - (We would pop or process the node at this state for postorder)
# I have added these states as labels while pushing to nodes to the stack.
# The advance() method simulates recursion 
# The idea is to pause exection at the "INTERIM" state and resume execution in the next() method
# (more comments in-line...)

# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class BSTIterator(object):
    
    # Labels for states
    ARRIVAL = 0
    INTERIM = 1
    DEPARTURE = 2

    def __init__(self, root):
        """
        :type root: TreeNode
        """
        # Initialize the stack
        if root is None:
            self.stack = []
        else:
            # Add root to stack and invoke advance()
            self.stack = [(root, None)]
            self.advance()

    def next(self):
        """
        @return the next smallest number
        :rtype: int
        """
        # Execution is paused at the INTERIM state
        # The node on top of the stack is the next node we want
        (node, zone) = self.stack[-1]
        
        # Add the right child to the stack and continue execution by invoking advance
        if node.right is not None:
            self.stack.append((node.right, None))
        self.advance()
        return node.val
        

    def hasNext(self):
        """
        @return whether we have a next smallest number
        :rtype: bool
        """
        return len(self.stack) > 0
    
    def advance(self):
        # Here's where the simulation happens
        while len(self.stack) != 0:
            # Check the top of the stack for a node and what state it is in
            (node,zone) = self.stack[-1]
            if zone is None: # First time we are seeing a node - set it's state to ARRIVAL
                self.stack[-1] = (node, self.ARRIVAL)
                # Push the left child with state None
                if node.left is not None:
                    self.stack.append((node.left, None))
            elif zone == self.ARRIVAL:
                # Change the state to "INTERIM"
                self.stack[-1] = (node, self.INTERIM)
                # Since we are simulating an inorder traversal, we have to pause execution at this state
                return
            elif zone == self.INTERIM:
                # Change state to "DEPARTURE" and pop node off stack
                self.stack[-1] = (node, self.DEPARTURE)
                self.stack.pop()
        


# Your BSTIterator object will be instantiated and called as such:
# obj = BSTIterator(root)
# param_1 = obj.next()
# param_2 = obj.hasNext()