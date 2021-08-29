public class linkedlist {
    //static lagane se location milta hai
    //initially main se pehle store ho jaata hai uska address memory pe
        private class Node{
            int data = 0;
            //agle node ke address ko store krne ke liye Node type ka liya
            Node next = null;

            Node(int data){
                this.data = data;
            }
        }

        //linkedlist class ke members
        private Node head = null;
        private Node tail = null;
        private int size = 0;

        public int size()
        {
            return this.size;
        }

        public boolean isEmpty()
        {
            return this.size == 0;
        }

        private void addFirstNode(Node node)
        {
            if(this.size == 0)
            {
                this.head = newNode;
                this.tail = newNode;
            }
            else{
                node.next = this.head;
                this.head = newNode;
            }
            this.size++;
            //Node newNode = new Node(data);
            //newnode.data = data;
        }

        public void addFirst(int data)
        {
            Node newNode = new Node(data);
            addFirstNode(newNode);
        }

        private void addLastNode(Node node)
        {
            if(this.size == 0)
            {
                this.head = newNode;
                this.tail = newNode;
            }
            else{
                this.tail.next = newNode;
                this.tail = newNode;
            }
            this.size++;
        }

        public void addLast(int data)
        { 
            Node newNode = new Node(data);
            addLastNode(newNode);
            //newnode.data = data;
        }

        public void addAt(int idx, int data)
        {
            if(idx < 0 || idx > this.size)
            {
                return;
            }
            else 
            {
                Node node = new Node(data);
                addAtNode(node, idx);
            }
        }

        private void addAtNode(Node node, int idx)
        {
            if(idx == 0){
                addFirstNode(node);
            }
            else if(idx == this.size)
            {
                addFirstNode(node);
            }
            else{
                Node temp = head;
                for(int i = 1; i < idx; i++)
                {
                    temp = temp.next;
                }
                node.next = temp.next;
                temp.next = node;
                this.size++;
            }
            
        }

        //========================================================================

        private Node removeFirstNode(){
            Node node = this.head;
            if(this.size == 1)
            {
                this.head = this.tail = null;
            }
            else
            {
                this.head = this.head.next; 
            }
            this.size--;
            return node;
        }

        public int removeFirst()
        {
            if(this.size == 0)
            return -1;
            else
            {
                Node node = removeFirstNode();
                return node.data;
            }
        }

        private Node removeLastNode(){
            //Node temp = head;
            if(this.size == 1){
                Node temp = head;
                this.head = this.tail = null;
                return temp;
            }
            else
            {
                Node temp = head;
                for(int i = 1; i < this.size-1; i++)
                {
                    temp = temp.next;
                }
                Node temp1 = temp.next;
                this.tail = temp;
                return temp1;
            }
        }
        
        public int removeLast()
        {
            if(this.size == 0)
            return -1;
            else return removeLastNode().data;   
        }

        public int removeAt(int idx)
        {
            if(idx < 0 || idx >= this.size){
                return -1;
            }
            else
            {
                return removeNodeAt(idx).data;
            }
        }
        //0    1    2    3   4
        //10-->20-->30-->40-->50
        private Node removeNodeAt(int idx)
        {
            if(idx == 0)
            {
                return removeFirstNode();
                
            }
            else if(idx == this.size-1){
                return removeLastNode();
                
            }
            else 
            {
                Node temp = head;
                for(int i = 1; i < idx; i++)
                {
                    temp = temp.next;
                }
                Node temp1 = temp.next;
                temp.next = temp.next.next;
                this.size--;
                return temp1;
            }
        }

        //=============================================================================

        public int getFirst()
        {
            if(this.size == 0)
            return -1;
            else{
                return head.data;
            }
        }

        public int getLast()
        {
            if(this.size == 0)
            return -1;
            else{
                return tail.data;
            }
        }
            //0    1    2    3   4
            //10-->20-->30-->40-->50
        public int getNodeAt(int idx)
        {
            if(idx < 0 || idx >= this.size || this.size == 0)
            return -1;
            else{

                if(this.size == 1)
                {
                    return getFirst();
                }
                if(idx == this.size-1)
                {
                    return getLast();
                }
                Node temp = head;
                for(int i = 1; i < idx; i++)
                {
                    temp = temp.next;
                }
                return temp.data;
            }

        }
    }