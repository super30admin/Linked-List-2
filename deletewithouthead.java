time complexity: O(1)
space complexity: O(1)


class Main{

  static node deletedNode(node head, node toBeDeleted){

    if(toBeDeleted == null)
      return null;
    else{
      if(toBeDeleted.next == null){
        System.out.print("Last node can't be freed");
        return null;
      }
      // store or swap but ( the data of current node will be deleted)
      toBeDeleted.data = toBeDeleted.next.data;
      toBeDeleted.next = toBeDeleted.next.next;
      return head;
    }
  }
 
  public static void main(String[] args){
    // creating a linked list
    node head = new node();
    head = create(2);
    head.next = create(3);
    node toBeDeleted = create(4);
    head.next.next = toBeDeleted;
    head.next.next.next = create(5);
    head.next.next.next.next = create(6);
    head.next.next.next.next.next = create(7);
 
    System.out.print("Old Linked List: ");
    node tmp = head;
    while(tmp != null){
      System.out.print(tmp.data+" ");
      tmp = tmp.next;
    }
    head = deletedNode(head, toBeDeleted);
 
    System.out.print("\n"+"New Linked List: ");
    tmp = head;
    while(tmp!=null){
      System.out.print(tmp.data+" ");
      tmp = tmp.next;
    }
  }
}