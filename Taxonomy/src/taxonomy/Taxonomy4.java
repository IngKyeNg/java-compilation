package taxonomy;

import java.util.function.BiPredicate;
import java.util.*;
import java.util.stream.Collectors;

public class Taxonomy4 {
    public static void main(String[] args) {
        
        long count;
        
        Staff[] staff2017 = new Staff[]{
            new Lecturer("Ali",2356,550F),
            new Clerk("Azizi",1255,25F),
            new Manager("Ahmad",4500,550F),
            new HRManager("Abdullah",5445),
            new SalesManager("Abu",5660,650F,800F),
        };
        ShowAllStaffInfo(staff2017);
        
        List<Staff> allStaff = Arrays.asList(staff2017);
        
        System.out.println("=============Poor Staff==============");
        List<Staff> poorStaff = allStaff.stream().filter(
                    (Staff s)->s.Salary<3000).collect(Collectors.toList());
        poorStaff.forEach((Staff s)->System.out.printf("Name:%-12s\tSalary:$%.2f%n", s.Name,s.Salary));
        
        System.out.println("=============Copy==============");
        List<String> names = allStaff.stream().map(
                    (Staff s)->s.Name).distinct().collect(Collectors.toList());
        names.forEach(System.out::println);

        System.out.println("=============Richest Staff==============");
        Staff richestStaff = allStaff.stream().reduce(
                    (Staff s1, Staff s2)->(s1.Salary>s2.Salary)?s1:s2).get();
        System.out.println("Richest Staff is "+richestStaff.Name);   
    }

    static void ShowAllStaffInfo(Staff[] items){
        for(Staff staff:items){
            System.out.printf("Name:%-12s\tSalary:$%.2f%n",
                    staff.Name,staff.Salary);
        }
        System.out.println();
    }
     
}
