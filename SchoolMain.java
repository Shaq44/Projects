public class SchoolMain{

public static void main(String[] args){

Student student = new Student("Tim Riddle");
//System.out.println(student.generateID(4));
System.out.println("Total Fees: " + student.payFees(5000));
student.setGrade(8);
}

}
