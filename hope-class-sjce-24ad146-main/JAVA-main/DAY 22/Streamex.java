import java.util.List;
class Emp{
    String name;
    int salary;
    Emp(String name,int salary){
        this.name=name;
        this.salary=salary; 
    }
    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return name;
    }
    public String getName(){return name;}
    public double getSalary(){ return salary;}
    
}

public class Streamex {
    public static void main(String[] args) {
        List <Integer> nums = List.of(2,3,4,5,6);
        List <Integer> multiof2 = nums.stream().map((i)->i*2).toList();
        System.out.println(multiof2);
        
        List <Integer> evenNums = nums.stream().filter((i)->i%2==0).toList();
        System.out.println(evenNums);

        int total= multiof2.stream().reduce(0,(a,b)->a+b);
        System.out.println(total);

        List <Emp> emps = List.of(new Emp("Sri",20000),new Emp("Sakthi",30000));
        List <String> empName = emps.stream().map((i)-> i.getName()).toList();
        System.out.println(empName);

        List <Emp> empsal = emps.stream().filter((i)-> i.getSalary()>20000).toList();
        System.out.println(empsal);
        
    }
}