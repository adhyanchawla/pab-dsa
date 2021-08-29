public class MyQueue {
    private int[]arr;
    private int size;
    private int maxSize;
    private int front;
    private int back;

    MyQueue(int len)
    {
        initialize(len);
    }

    MyQueue()
    {
        initialize(5);
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();

        if(this.front < this.back)
        {
            for(int i = this.front; i < this.back; i++)
            {
                sb.append(this.arr[i] + " ");
            }
        }
        else
        {
            for(int i = this.front; i < this.maxSize; i++)
            {
                sb.append(this.arr[i] + " ");
            }

            for(int i = 0; i < this.back; i++)
            {
                sb.append(this.arr[i] + " ");
            }
        }

        return sb.toString();
    }

    public int maxsize()
    {
        return this.maxSize;
    }

    protected void initialize(int len)
    {
        this.arr = new int[len];
        this.size = 0;
        this.maxSize = len;
        this.front = 0; 
        this.back = 0;
    }

    private void queueIsEmptyException() throws Exception{
        if(this.size == 0)
        throw new Exception("queueIsEmptyException: -1");
    }

    private void queueIsFullException() throws Exception{
        if(this.size == this.maxSize)
        throw new Exception("queueIsFullException: -1");
    }

    public boolean isEmpty()
    {
        return this.size == 0;
    }

    public int size()
    {
        return this.size;
    }

    private void add_(int data)
    {
        this.arr[this.back] = data;
        this.back = (this.back + 1) % this.maxSize; 
        this.size++;
    }

    public void add(int data) throws Exception
    {
        queueIsFullException();
        add_(data);
    }

    private int remove_()
    {
        int rm = this.arr[this.front];
        this.front = (this.front + 1) % this.maxSize;
        this.size--;
        return rm;
    }

    public int remove() throws Exception
    {
        queueIsEmptyException();
        return remove_();
    }

    public int peek() throws Exception
    {
        queueIsEmptyException();
        return this.arr[this.front];
    }
}