import java.util.ArrayList;
import java.util.Scanner;

class Person {
    protected String name;
    protected String address;

    public Person(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String toString() {
        return name + "(" + address + ")";
    }
}

class Student extends Person {
    private ArrayList<String> courses = new ArrayList<>();
    private ArrayList<Integer> grades = new ArrayList<>();

    public Student(String name, String address) {
        super(name, address);
    }

    public void addCourseGrade(String course, int grade) {
        courses.add(course);
        grades.add(grade);
    }

    public void printGrades() {
        System.out.println("\nDaftar Nilai:");
        for (int i = 0; i < courses.size(); i++) {
            System.out.println(courses.get(i) + ": " + grades.get(i));
        }
    }

    public double getAverageGrade() {
        int total = 0;
        for (int grade : grades) {
            total += grade;
        }
        return grades.size() > 0 ? (double) total / grades.size() : 0.0;
    }

    @Override
    public String toString() {
        return "Student: " + super.toString();
    }
}

class Teacher extends Person {
    private ArrayList<String> courses = new ArrayList<>();

    public Teacher(String name, String address) {
        super(name, address);
    }

    public boolean addCourse(String course) {
        if (!courses.contains(course)) {
            courses.add(course);
            return true;
        }
        return false;
    }

    public boolean removeCourse(String course) {
        return courses.remove(course);
    }

    @Override
    public String toString() {
        return "Teacher: " + super.toString();
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Input Student
        System.out.print("Masukkan nama mahasiswa: ");
        String namaMhs = input.nextLine();
        System.out.print("Masukkan alamat mahasiswa: ");
        String alamatMhs = input.nextLine();

        Student mhs = new Student(namaMhs, alamatMhs);

        System.out.print("Berapa mata kuliah yang diambil? ");
        int jmlMk = input.nextInt();
        input.nextLine();

        for (int i = 0; i < jmlMk; i++) {
            System.out.print("Nama mata kuliah ke-" + (i + 1) + ": ");
            String mk = input.nextLine();
            System.out.print("Nilai untuk " + mk + ": ");
            int nilai = input.nextInt();
            input.nextLine();
            mhs.addCourseGrade(mk, nilai);
        }

        System.out.println("\n" + mhs);
        mhs.printGrades();
        System.out.printf("Rata-rata nilai: %.2f\n", mhs.getAverageGrade());

        // Input Teacher
        System.out.print("\nMasukkan nama dosen: ");
        String namaDosen = input.nextLine();
        System.out.print("Masukkan alamat dosen: ");
        String alamatDosen = input.nextLine();

        Teacher dosen = new Teacher(namaDosen, alamatDosen);

        System.out.print("Berapa mata kuliah yang diampu? ");
        int jmlAmpu = input.nextInt();
        input.nextLine();

        for (int i = 0; i < jmlAmpu; i++) {
            System.out.print("Nama mata kuliah yang diampu ke-" + (i + 1) + ": ");
            String mk = input.nextLine();
            boolean added = dosen.addCourse(mk);
            if (!added) {
                System.out.println("Mata kuliah sudah pernah ditambahkan.");
            }
        }

        System.out.println("\n" + dosen);

        input.close();
    }
}
