package SinglyLinkedList;

public class SinglyLinkedList {

    Node head;

    class Node
    {
        int data;
        Node next;

        Node(int data){this.data = data ; this.next = null;}        
    }

    // Insertion at the beginning of the list

    void addBegin(int data)
    {
        Node node = new Node(data);
        if(this.head == null)
        {
            this.head = node;
        }
        else
        {
         node.next = head;
         this.head = node;   
        }
    }

    // Insertion at the end 

    void addEnd(int data)
    {
        Node node = new Node(data);
        if(head == null)
        {
            head = node;
        }
        else
        {
            Node current = head;
            while(current.next!=null)
            {
                current = current.next;
            }
            current.next = node;
        }
    }

    
    // Insertion at a given position
    
    void addIndex(int data , int index)
    {
        Node node = new Node(data);
        Node current = head;
        int count = 0;

      
        
        while(current.next != null)
        {
            
            
            if(count == index)
            {
              node.next = current.next;
              current.next = node;
            }
            else{
                System.out.println("Incorrect index");
            }
            current = current.next;
            count++;
            
        }



        // Insert at after Node

    }
    
    // Print
    
    void printList()
    {
        Node current = head;
        System.out.println("deneme");
        while(current!=null)
        {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println();
    }

    //
    void deleteNode( int d )
    {
        Node curr = head;
        if(head.data == d)
        {
            head = head.next;            
            
        }
        else
        {
            while(curr.next != null)
        {
            if(curr.next.data == d)
            {
               

                if(curr.next.next == null)
                {
                    curr.next = null;
                    return;
                }
                curr.next = curr.next.next;

            }
          
            curr = curr.next;
        }
       }   
    }




}
