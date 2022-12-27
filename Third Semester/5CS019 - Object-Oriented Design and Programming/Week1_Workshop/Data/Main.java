package Week1_Workshop.Data;

class Data {
    // private variable
    private String name;

    // getter method to get the value of private variable
    public String getName() {
        return this.name;
    }

    // setter method to set the value of private variable
    public void setName(String name) {
        this.name = name;
    }
}

class Main {
    public static void main(String[] main) {
        // create an object of Data
        Data d = new Data();

        // access private variable and field from another class
        d.setName("Program");

        // printing the name in the console
        System.out.println(d.getName());
    }
}