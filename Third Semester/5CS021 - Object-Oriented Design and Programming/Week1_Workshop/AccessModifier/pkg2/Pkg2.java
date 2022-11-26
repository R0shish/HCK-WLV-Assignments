package Week1_Workshop.AccessModifier.pkg2;

// import package 1
import Week1_Workshop.AccessModifier.pkg1.Pkg1;

public class Pkg2 {
    void display() {
        Pkg1 pkg1 = new Pkg1("Package 1", "First Package", "Roshish", "2.0.0");
        // default access modifier -> only accessible in the package where declared
        // not accessible from other packages
        // System.out.println(pkg1.name);

        // public access modifier -> accessible from anywhere
        System.out.println(pkg1.description);

        // private variable only accessible in the class it is declared.
        // System.out.println(pkg1.author);

        // protected variable only accessible in the package and sub-classes where
        // declared.
        // System.out.println(pkg1.version);
    }
}
