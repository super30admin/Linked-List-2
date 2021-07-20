
# a class to define a node with 
# data and next pointer
class Node():

    # constructor to initialize a new node
    def __init__(self, val = None):
        self.data = val
        self.next = None

# push a node to the front of the list
def push(head, val):

    # allocate new node
    newnode = Node(val)

    # link the first node of the old list to the new node
    newnode.next = head.next

    # make the new node as head of the linked list 
    head.next = newnode

# function to print the list
def print_list(head):

    temp = head.next
    while(temp != None):
        print(temp.data, end = ' ')
        temp = temp.next
    print()

# function to delete the node
# the main logic is in this
def delete_node(node):

    prev = Node()

    if(node == None):
        return
    else:
        while(node.next != None):
            node.data = node.next.data
            prev = node
            node = node.next

        prev.next = None


if __name__ == '__main__':

    # allocate an empty header node
    # this is a node that simply points to the
    # first node in the list
    head = Node()

    # construct the below linked list
    # 1->12->1->4->1
    push(head, 1)
    push(head, 4)
    push(head, 1)
    push(head, 12)
    push(head, 1)

    print('list before deleting:')
    print_list(head)

    # deleting the first node in the list
    delete_node(head.next)

    print('list after deleting: ')
    print_list(head)

# This code is contributed by Adith Bharadwaj
