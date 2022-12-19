package Week4_CaseStudy;

import java.time.LocalDate;
import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class User {
    private String fullName;
    private String mobileNumber;
    private String password;
    private String dateOfBirth;

    public User() {
    }

    public User(String fullName, String mobileNumber, String password, String dateOfBirth) {
        this.fullName = fullName;
        this.mobileNumber = mobileNumber;
        this.password = password;
        this.dateOfBirth = dateOfBirth;
    }

    public String getFullName() {
        return fullName;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public String getPassword() {
        return password;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setFullName(String fullName) {
        if (fullName.length() < 4) {
            throw new InvalidInputException("Please input your full name.");
        }
        this.fullName = fullName;
    }

    public void setMobileNumber(String mobileNumber) {
        final String regex = "^0\\d{9}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(mobileNumber);

        if (!matcher.matches()) {
            throw new InvalidInputException("Please enter a valid mobile number. Must start with 0 and be 10 digits.");
        }
        this.mobileNumber = mobileNumber;
    }

    public void setPassword(String password, String confirmPassword) {
        final String regex = "^[a-zA-Z]+[@&][0-9]+$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(password);

        if (!matcher.matches()) {
            throw new InvalidInputException(
                    "Please enter a strong valid password. Must have alphabets followed by @ or & followed by numerics.");
        }
        if (!password.equals(confirmPassword)) {
            throw new InvalidInputException(
                    "The passwords do not match. Please try again!");
        }
        this.password = password;
    }

    public void setDateOfBirth(String dateOfBirth) {
        DateTimeFormatter format1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter format2 = DateTimeFormatter.ofPattern("MM/dd/yyyy");

        try {
            LocalDate.parse(dateOfBirth, format1);
        } catch (DateTimeParseException e) {
            try {
                LocalDate.parse(dateOfBirth, format2);
            } catch (DateTimeParseException err) {
                throw new InvalidInputException(
                        "Please enter a valid date of birth. Input must be in format (DD/MM/YYYY) or (MM/DD/YYYY)");
            }
        }

        if (getAge(dateOfBirth) < 21) {
            throw new InvalidInputException(
                    "Please enter a valid date of birth. Age must be atleast 21.");
        }
        this.dateOfBirth = dateOfBirth;
    }

    public int getAge(String dateOfBirth) {
        int year = Integer.parseInt(dateOfBirth.split("/")[2]);
        int currentYear = Integer.parseInt(Year.now().toString());

        return (currentYear - year);
    }
}
