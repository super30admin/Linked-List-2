//tc = o(1)
//sc = o(1)

//delete when head is not given
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
public class DeleteWithoutHeadPointer {
    public void delete (ListNode del){
        ListNode temp = del.next;
        del.val = temp.val;
        del.next = temp.next;
        temp = null;
    } 
    //[1,2] delete 1
}
