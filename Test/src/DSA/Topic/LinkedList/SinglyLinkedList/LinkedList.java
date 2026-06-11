package DSA.Topic.LinkedList.SinglyLinkedList;

public class LinkedList {
    // Assume kiya h ki initially head null hi h
    Node head = null;
    // Insert at beginning
    public void insertAtBeginning(int item){
        // ye newNode naam se node banaya h matlab object
        Node newNode = new Node(item);
        // agar head ka next hi null nikla to
        // newnode daal do aur uska refrence head me daal do
        if (head==null){
            head = newNode;
            return;
        }
        // jo bhi head h usko newnode ke next me daal do
        newNode.next = head;
        // aur new node ko hi head bana do
        head = newNode;
    }
    // Insert at End
    public void insertAtEnd(int item){
        Node newNode = new Node(item);
        // agar head ka next hi null nikla to
        // newnode daal do aur uska refrence head me daal do
        if (head==null){
            head = newNode;
            return;
        }
        // important
        // temp isiliye liya kyunki hum head ko
        // har baar move nhi kr na chahte to
        // ab hum temp ko move krenge
        Node temp = head;
        // temp ka next null nhi h
        // to temp ko badhate jao
        while (temp.next != null){
            temp  = temp.next;
        }
        // aur jese hi next null mile to seedha waha apna
        // newnode daal do aur temp ke next me new node reference daal do
        temp.next = newNode;
    }
    // Insert At Middle
    public void insertAtSpecificPosition(int item, int position){
        // new node bana h jo hum insert krenge
        Node newNode = new Node(item);
        // ye invalid position batayega
        if (position<0){
            System.out.println("Invalid Position");
            return;
        }
        // agar zero pr hi daalna h new node ko to isse dal jayega
        if (position==0){
            newNode.next = head;
            head = newNode;
            return;
        }
        // hum move ke rhe specific position se pehle tak
        Node temp = head;
        int index = 0;
        while (temp.next != null){
            if (index == position-1){
                break;
            }
            temp = temp.next;
            index++;
        }
        if (temp.next == null){
            System.out.println("Position out of bound");
            return;
        }
        newNode.next = temp.next;
        temp.next = newNode;
    }
    // Print the Data
    public void printData(){
        if (head==null){
            System.out.println("Linked List is empty :");
            return;
        }
        Node temp = head;
        while (temp != null){
            if (temp.next == null){
                System.out.print(temp.data);
            }else {
                System.out.print(temp.data+" -> ");
            }
            temp = temp.next;
        }
    }
    //Delete from beginning
    public void deleteFromBegining(){
        head = head.next;
    }
    // Delete from End
    public void deleteFromEnd(){
        if (head.next == null){
            head = null;
            return;
        }
            Node temp = head;
        while (temp.next.next!=null){
            temp = temp.next;
        }
        temp.next = null;
    }
    // Delete from Specific Position
    public void deleteFromSpecificPosition(int position){
        if (position == 0){
            head = head.next;
            return;
        }
        Node temp = head;
        for (int i=0; i<position-1 && temp!=null; i++){
            temp = temp.next;
        }
        if(temp==null || temp.next==null){
            System.out.println("Position out of bound");
            return;
        }
        temp.next = temp.next.next;
    }
    // Search data Present or Not
    public boolean searchData(int data){
        Node temp = head;
        while (temp!=null){
            if (temp.data == data){
                return true;
            }
            temp = temp.next;
        }
        return false;
    }
}
