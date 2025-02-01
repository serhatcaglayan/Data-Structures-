package myNode.Queue;
import myNode.*;

public class Queue {
    
    int size ;
    int numberOfNodes ;
    int front;
    int rear;
    Node[] nodes;

    Queue()
    {
        this.size = 10;
        this.numberOfNodes =0;
        this.front =0;
        this.rear = 0;
        this.nodes = new Node[this.size];
    }

    public boolean enqueue(Node node)
    {
        if(this.numberOfNodes < this.size)
        {
            nodes[this.rear]=node.deepCopy();
            numberOfNodes++;
             this.rear = (this.rear + 1) % this.size; 

            return true;
        }
        return false;
    }

    public Node dequeue()
    {
        if(this.numberOfNodes == this.size) return null;

        Node val = nodes[this.front];
        numberOfNodes --;
        nodes[this.front] = null;
        this.front = (this.front + 1) % this.size;
        return val;

    }

}
