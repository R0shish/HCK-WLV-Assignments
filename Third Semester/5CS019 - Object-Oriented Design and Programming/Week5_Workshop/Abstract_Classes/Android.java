package Week5_Workshop.Abstract_Classes;

abstract class Google {
    abstract boolean googleSignup(String email, String password);
}

abstract class Android extends Google {
    abstract void goToPlaystore();
}

class Blackberry extends Android {

    @Override
    void goToPlaystore() {
        System.out.println("Opening Playstore!");
    }

    @Override
    boolean googleSignup(String email, String password) {
        // Implement login check
        return true;
    }
}

class SmartTV extends Android {
    @Override
    void goToPlaystore() {
    }

    @Override
    boolean googleSignup(String email, String password) {
        return false;
    }

}

class Main {
    public static void main(String[] args) {
        Blackberry v1 = new Blackberry();
        v1.goToPlaystore();
        if (v1.googleSignup("", "")) {
            System.out.println("Logged In!");
        } else {
            System.out.println("Wrong Credentials!");
        }
    }
}