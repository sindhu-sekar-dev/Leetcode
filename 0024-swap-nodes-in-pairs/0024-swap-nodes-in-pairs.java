
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    
    public static ListNode deserialize(String data) {
        data = data.trim();
        if (data.equals("[]") || data.length() == 0) return null;
        data = data.substring(1, data.length() - 1);
        String[] vals = data.split(",");
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        for (String s : vals) {
            curr.next = new ListNode(Integer.parseInt(s.trim()));
            curr = curr.next;
        }
        return dummy.next;
    }

    
    public String serialize() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        ListNode curr = this;
        while (curr != null) {
            sb.append(curr.val);
            if (curr.next != null) sb.append(",");
            curr = curr.next;
        }
        sb.append("]");
        return sb.toString();
    }
}

public class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0, head);
        ListNode prev = dummy;

        while (prev.next != null && prev.next.next != null) {
            ListNode first = prev.next;
            ListNode second = first.next;

            
            first.next = second.next;
            second.next = first;
            prev.next = second;

            
            prev = first;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        ListNode head1 = ListNode.deserialize("[1,2,3,4]");
        System.out.println(sol.swapPairs(head1).serialize()); 

        ListNode head2 = ListNode.deserialize("[]");
        System.out.println(sol.swapPairs(head2) == null ? "[]" : sol.swapPairs(head2).serialize()); 

        ListNode head3 = ListNode.deserialize("[1]");
        System.out.println(sol.swapPairs(head3).serialize()); 

        ListNode head4 = ListNode.deserialize("[1,2,3]");
        System.out.println(sol.swapPairs(head4).serialize()); 
    }
}
