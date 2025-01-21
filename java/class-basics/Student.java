public class Student {
    long mis;
    String name;

    public Student(long m, String n) {
        mis = m;
        name = n;
    }

    public static  void main(String[] args) {
        Student yashwant = new Student(612303039, "Yashwant");
        System.out.println("Name: " + yashwant.name);
        System.out.println("Mis: " + yashwant.mis);
    }
}