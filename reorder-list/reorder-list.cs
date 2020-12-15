            return;
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast!=null && fast.next!=null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        Console.Out.WriteLine("slow is {0}",slow.val);
        Console.Out.WriteLine(fast);
​
        
        fast = reverse(slow.next);
        slow.next=null;
        slow = head;
        
        while(fast!=null)
        {
            ListNode temp = slow.next;
            slow.next = fast;
            fast = fast.next;
            slow.next.next = temp;
            slow = temp;
        }
        
        
        
    }
    
    private ListNode reverse(ListNode head)
    {
        if(head==null || head.next==null)
        {
            return head;
        }
        ListNode reversed = reverse(head.next);
        head.next.next= head;
        head.next=null;
        return reversed;
    }
}
