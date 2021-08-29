import java.util.*;

public class Test1  extends Industry {
     
    public static void main(String[] args)
    {
        //department
        Department d = new Department();
        d.dept_number = 1;
        d.dept_name = "Paper";
        d.noOfEmployees = 10;

        //industry
        d.code = 1;
        d.name = "Indian Mills";
        d.admit();
        d.conductAudit();

    }

}
