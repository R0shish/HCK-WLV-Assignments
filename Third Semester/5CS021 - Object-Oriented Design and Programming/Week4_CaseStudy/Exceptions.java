package Week4_CaseStudy;

class InvalidInputException extends RuntimeException {
    public InvalidInputException(String err) {
        super(err + "\nPlease re-enter your information.\n");
    };
}
