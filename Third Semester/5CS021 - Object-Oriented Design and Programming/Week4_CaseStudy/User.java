package Week4_CaseStudy;

import java.time.Year;
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
        final String regex = "\\d{2}/\\d{2}/\\d{4}";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(dateOfBirth);

        int year = Integer.parseInt(dateOfBirth.split("/")[2]);
        int currentYear = Integer.parseInt(Year.now().toString());

        if (!matcher.matches() || (currentYear - year) < 21) {
            throw new InvalidInputException(
                    "Please enter a valid date of birth. Input must be in format (DD/MM/YYYY) or (MM/DD/YYYY) and age must be atleast 21.");
        }
        this.dateOfBirth = dateOfBirth;
    }
}
