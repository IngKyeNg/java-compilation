package taxonomy;

interface SortCriteria{
    boolean Swap(Object lhs, Object rhs);
}

public class Taxonomy2 {

    static void Sort(Sortable[] items, SortCriteria sc) {
        int n = items.length;
        for(int x=0; x<n-1; x++) {
            for(int y=0;y<(n-1-x);y++){
                if(sc.Swap(items[y],items[y+1])){
                    Sortable item = items[y];
                    items[y] = items[y+1];
                    items[y+1] = item;
                }
            }
        }
    }
    public static void main(String[] args) {
        Staff[] staff2017 = new Staff[]{
            new Lecturer("Ali",2356,550F),
            new Clerk("Azizi",1255,25F),
            new Manager("Ahmad",4500,550F),
            new HRManager("Abdullah",5445),
            new SalesManager("Abu",5660,650F,800F),
        };
        ShowAllStaffInfo(staff2017);

        Sort(staff2017,
            new SortCriteria(){
                @Override public boolean Swap(Object lhs, Object rhs){
                    return ((Staff)lhs).getMonthlySalary()>
                            ((Staff)rhs).getMonthlySalary();
                }
        });
        
        ShowAllStaffInfo(staff2017);
        
        Sort(staff2017,
            (lhs,rhs)->
                ((Staff)lhs).getMonthlySalary()>
                ((Staff)rhs).getMonthlySalary()
        );
        ShowAllStaffInfo(staff2017);

        Sort(staff2017,
            (lhs,rhs)->
                ((Staff)lhs).getMonthlySalary()<
                ((Staff)rhs).getMonthlySalary()
        );
        ShowAllStaffInfo(staff2017);
        
        Sort(staff2017,
            (lhs,rhs)->
                ((Staff)lhs).Name.compareTo(((Staff)rhs).Name)>0
        );
        ShowAllStaffInfo(staff2017);        
    }
    static void ShowAllStaffInfo(Staff[] items){
        for(Staff staff:items){
            System.out.printf("Name:%-12s\tMonthly Salary:$%.2f%n",
                    staff.Name,staff.getMonthlySalary());
        }
        System.out.println();
    }
}
