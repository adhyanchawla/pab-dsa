public class Industry {

    int code;
    String name;

    public Industry(int code, String name)
    {
        this.code = code;
        this.name = name;
    }

    public Industry()
    {

    }

    public void admit(){
        System.out.println("Admit");
    }

    public void conductAudit(){
        System.out.println("Conduct Audit");
    }

    public static class Department extends Industry{
        int dept_number;  
        String dept_name;
        int noOfEmployees;
        
        public Department(){
            //super();
        }

        public Department(int dept_number, String dept_name, int noOfEmployees){
            this.dept_number = dept_number;
            this.dept_name = dept_name;
            this.noOfEmployees = noOfEmployees;
        }
    }
    
}
