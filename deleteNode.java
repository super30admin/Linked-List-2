Time Complexity-O(1)
Space Complexity-O(1)

public void deleteNode(Node toDel) 
    { 
        Node temp = toDel.next;; 
        toDel.val = temp.val; 
        toDel.next = temp.next; 
        temp = null; 
    } 
