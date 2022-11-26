package Week1_Workshop.AccessModifier.pkg1;

public class Pkg1 {
    String name;
    public String description;
    private String author;
    protected String version;

    public Pkg1(String name, String description, String author, String version) {
        this.name = name;
        this.description = description;
        this.author = author;
        this.version = version;
    }

    void display() {
        // private variable only accessible in the class.
        System.out.println(author);
    }
}

class Pkg1Child extends Pkg1 {

    public Pkg1Child(String name, String description, String author, String version) {
        super(name, description, author, version);
    }

    void display() {
        // private variable not accessible outside of the class.
        // System.out.println(author);
        // protected variable only accessible in the current package and sub-classes
        System.out.println(version);
    }
}

class Pkg1NotChild {
    Pkg1 pkg1 = new Pkg1("Package 1", "First Package", "Roshish", "2.0.0");

    void display() {
        // default access modifier -> only accessible in the current package
        System.out.println(pkg1.name);
        // private variable not accessible outside of the class.
        // System.out.println(pkg1.author);
        System.out.println(pkg1.version);
    }
}
