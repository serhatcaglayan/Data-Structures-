



public class BST {
    Node root;
    public static class Node
    {
        int data;
        Node leftChild, rightChild ;

        public Node(int data)
        {
            this.data = data;
            leftChild = rightChild = null;
        }
    }
    public static void main(String[] args) {
        
        BST bst = new BST();
        bst.root = new Node(50);
        

       

       bst.insertRecursive(bst.root, 25);
       bst.insertRecursive(bst.root, 60);
       bst.insertRecursive(bst.root, 15);

      
       
        
        
    }

    void inorderTraversal(Node node) // Left-Data-Right
    {        
        if(node == null) return;
        inorderTraversal(node.leftChild);
        System.out.print(node.data + " ");
        inorderTraversal(node.rightChild);
    }
    void preorderTraversal(Node node) 
    {
        if(node == null) return;
        System.out.print(node.data + " ");
        preorderTraversal(node.leftChild);
        preorderTraversal(node.rightChild);
    }
    void postorderTraversal(Node node)
    {
        if(node == null) return;
        postorderTraversal(node.leftChild);
        postorderTraversal(node.rightChild);
        System.out.print(node.data + " ");
    }



     void insert(int data)
    {
        Node newNode = new Node(data);

        if(this.root == null)
        {
            this.root = newNode;
            
        }else
        {
            Node currentNode = this.root;
            Node parent = null;

            while(currentNode != null)
            {
                if(newNode.data < currentNode.data)
                {
                    parent = currentNode;
                    currentNode = currentNode.leftChild;
                }
                else
                {
                    parent = currentNode;
                    currentNode = currentNode.rightChild;
                }
            }
            if(newNode.data < parent.data)
            {
                parent.leftChild = newNode;
            }
            else
            {
                parent.rightChild = newNode;
            }

        }

    }

    Node insertRecursive(Node root, int data) {
        if (root == null) {
            return new Node(data);
        }

        if (data < root.data) {
            root.leftChild = insertRecursive(root.leftChild, data);
        } else if (data > root.data) {
            root.rightChild = insertRecursive(root.rightChild, data);
        }

        return root;
    }

    Node findNodeRecursive (Node root, int key)
    {
        if(root == null || root.data == key)
        {
            return root;
        }
        if(root.data < key)
        {
            return findNodeRecursive(root.rightChild, key);
        }
        else
        {
            return findNodeRecursive(root.leftChild, key);
        }
        
    } 

    Node remove(Node root,int key)
    {
        if(root == null)
        {
            return root;
        }
        if(key < root.data)
        {
            root.leftChild = remove(root.leftChild, key);
        }
        else if(key > root.data)
        {
            root.rightChild = remove(root.rightChild, key);
        }
        else
        {
            if(root.leftChild == null)
            {
                return root.rightChild;
            }
            else if(root.rightChild == null)
            {
                return root.leftChild;
            }
           // else
           // {
                // two child
               // root.data = FindMax(root.right).data;
               // root.right = Remove(root.right,root.value);
           // }
        }
        return root;
    }



    Node findNode(int key)
    {
        Node currentNode = this.root;
        
        while(currentNode != null)
        {
            if(currentNode.data == key)
            {
                return currentNode;
            }
            else
            {
                if(key < currentNode.data)
                {
                    currentNode = currentNode.leftChild;
                }
                else
                {
                    currentNode = currentNode.rightChild;
                }
            }
        }
        return null;
    }

    int maxDepth(Node root)
    {
        if(root == null)
        {
            return 0;
        }
        int leftDepth = maxDepth(root.leftChild);
        int rightDepth = maxDepth(root.rightChild);
        return leftDepth > rightDepth ? leftDepth +1 : rightDepth +1 ;
    }

    /*
     En derindeki düğümü bulma

     void Node deepstNode(Node root)
     {
        Node temp ;
        if(root == null) return;

        var q = Queue<Node>;

        q.enQueue(root);

        while(q.Count>0)
        {
        temp = q.deQueue();
        if(temp.left != null) q.Enqueque(temp.left);
        if(temp.right != null) q.Enqueque(temp.right);

        }
        return temp;
     }

     Yaprak sayısı bulma

      int numberLeaf (Node root)
      {
      int count = 0;
      if(root == null) return count;

      var q = new Queue<Node>;
      q.Enqueque(root);
      while(q.Count>0)
      {
      var temp  = q.DeQueue();
      if(temp.left == null && temp.right == null) count++;
      if(temp.left != null) q.Enqueque(temp.left);
      if(temp.right != null) q.Enqueque(temp.right);

      }
      
      }


      
      
     */
    







}
