class Student {
    private String name;
    private int roll_no;
    private double english_marks;
    private double maths_marks;
    private double science_marks;
    private double total_marks;

    public Student(String name, int roll_no, double english_marks, double maths_marks, double science_marks) {
        this.name = name;
        this.roll_no = roll_no;
        this.english_marks = english_marks;
        this.maths_marks = maths_marks;
        this.science_marks = science_marks;
        this.total_marks = calcTotal(english_marks, maths_marks, science_marks);
    }

    double calcTotal(double english_marks, double maths_marks, double science_marks) {
        return english_marks + maths_marks + science_marks;
    }

    void display() {
        System.out.println("Name : " + this.name);
        System.out.println("Roll No : " + this.roll_no);
        System.out.println("English : " + this.english_marks);
        System.out.println("Maths : " + this.maths_marks);
        System.out.println("Science : " + this.science_marks);
        System.out.println("Total : " + this.total_marks);
    }

    public static void main(String[] args) {
        Student student = new Student(
                "Roshish", 21, 70, 80, 90);
        student.display();

    }
}