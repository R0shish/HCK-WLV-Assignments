package Week3_Tutorial.Payroll;

public class Payroll_Reciever {
    public static void main(String[] args) {
        Payroll payroll = new Payroll("Roshish", 20);
        payroll.setPayRate(20);
        payroll.setHoursWorked(2);
        System.out.println(payroll.getGrossPay());
    }
}
