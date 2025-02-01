package Stack;
import myNode.Node;;

public class Stack {

    Node[] nodes;
    int size;
    int top;

    public Stack()
    {
        this.size = 10;
        nodes = new Node[this.size];
        top = -1;
    }

    public boolean push(Node node)
    {
        if(this.top <this.size)
        {
            this.top++;
            nodes[this.top] = node.deepCopy();
            return true;

        }
       return  false;
    }

    public Node pop()
    {
        if(nodes[this.top] == null)
        {
            return null;
        }
        Node node = nodes[this.top];
        nodes[this.top] = null;
        this.top--;
        return node;
    }

    @Override
    public String toString() 
    {
        String str = "";
        for (int i = 0; i < nodes.length ; i++)
        {
            if(nodes[i]!= null)
            {
                str += nodes[i].toString() + "\n";
            }
        }
        return str;

    }
    
}
