import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class Student{
    private String FirstName;
    private String LastName;
    private int Score;
    private int Id;

    public Student(String firstName, String lastName, int score, int id) {
        FirstName = firstName;
        LastName = lastName;
        Score = score;
        Id = id;
    }

    public int getScore() {
        return Score;
    }

    @Override
    public String toString() {
        return FirstName+"-"+LastName+"-"+Score+"-"+Id;
    }
}

public class Main {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);
        String str_n = sc.nextLine();
        String[] a = str_n.split("-");
        ArrayList<String> list1 = new ArrayList<String>();
        ArrayList<String> list2 = new ArrayList<String>();
        ArrayList<Student> list = new ArrayList<Student>();
        int n = Integer.parseInt(a[0]);
        String FirstName = a[1];
        String LastName = a[2];
        for(int i = 0; i < n ; i++ ){
            String x = sc.nextLine();
            String[] b = x.split("-");
            if(b[0].compareTo(FirstName)==0){
                list1.add(x);
                if(b[1].equalsIgnoreCase(LastName)){
                    list2.add(x);
                    int score = Integer.parseInt(b[2]);
                    int id = Integer.parseInt(b[3]);
                    list.add(new Student(b[0],b[1],score,id));
                }
            }
        }
        System.out.println(list1.toString());
        System.out.println(list2.toString());
        list.sort(Comparator.comparing(Student::getScore).reversed());
        System.out.println(list.toString());

    }
}