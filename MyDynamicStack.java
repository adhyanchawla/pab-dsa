public class MyDynamicStack extends MyStack{
    
    public MyDynamicStack()
    {
        super();
    }
    
    public MyDynamicStack(int size)
    {
        //used to inherit public properties of parent class
        super(size);
    }

    // @Override
    // public int maxsize(){
    //     return maxsize * 2;
    // }

    @Override
    public void push(int data) throws Exception
    {
        if(super.size() == super.maxsize())
        {
            int[] temp = new int[super.size()];
            int idx = super.size()-1;
            while(super.size() != 0)
            {
                temp[idx--] = super.pop();
            }

            super.initialize(super.maxsize() * 2);

            for(int ele : temp)
            {
                super.push(ele);
            }
        }
        super.push(data);
    }
}
