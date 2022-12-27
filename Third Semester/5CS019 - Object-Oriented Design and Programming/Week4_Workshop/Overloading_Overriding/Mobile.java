package Week4_Workshop.Overloading_Overriding;

import java.math.BigInteger;

class Mobile {
    final private String imeiNumber;
    final private String modelNumber;
    final private String screenSize;
    final private String batteryCapacity;

    public Mobile(String imeiNumber, String modelNumber, String screenSize, String batteryCapacity) {
        this.imeiNumber = imeiNumber;
        this.modelNumber = modelNumber;
        this.screenSize = screenSize;
        this.batteryCapacity = batteryCapacity;
    }

    public Mobile(int imeiNumber, int modelNumber, int screenSize, int batteryCapacity) {
        this.imeiNumber = String.valueOf(imeiNumber);
        this.modelNumber = String.valueOf(modelNumber);
        this.screenSize = String.valueOf(screenSize);
        this.batteryCapacity = String.valueOf(batteryCapacity);
    }

    public String getImeiNumber() {
        return imeiNumber;
    }

    public String getModelNumber() {
        return modelNumber;
    }

    public String getScreenSize() {
        return screenSize;
    }

    public String getBatteryCapacity() {
        return batteryCapacity;
    }

    void voice_call(BigInteger phoneNumber) {
        System.out.println("Calling the phone number: " + phoneNumber);
    }

    void voice_call(String email) {
        System.out.println("Calling the user with email: " + email);
    }

    void video_call(BigInteger phoneNumber) {
        System.out.println("Video calling the phone number: " + phoneNumber);
    }

    void video_call(String email) {
        System.out.println("Video calling the user with email: " + email);
    }

}

class Samsung extends Mobile {
    final private String cameraMegapixel;

    public Samsung(int imeiNumber, int modelNumber, int screenSize, int batteryCapacity, int cameraMegapixel) {
        super(imeiNumber, modelNumber, screenSize, batteryCapacity);
        this.cameraMegapixel = String.valueOf(cameraMegapixel);
    }

    public Samsung(String imeiNumber, String modelNumber, String screenSize, String batteryCapacity,
            String cameraMegapixel) {
        super(imeiNumber, modelNumber, screenSize, batteryCapacity);
        this.cameraMegapixel = cameraMegapixel;
    }

    public String getCameraMegapixel() {
        return cameraMegapixel;
    }
}

class Iphone extends Mobile {
    final private String iosVersion;

    public Iphone(String imeiNumber, String modelNumber, String screenSize, String batteryCapacity,
            String iosVersion) {
        super(imeiNumber, modelNumber, screenSize, batteryCapacity);
        this.iosVersion = iosVersion;
    }

    public Iphone(int imeiNumber, int modelNumber, int screenSize, int batteryCapacity,
            int iosVersion) {
        super(imeiNumber, modelNumber, screenSize, batteryCapacity);
        this.iosVersion = String.valueOf(iosVersion);
    }

    public String getIosVersion() {
        return iosVersion;
    }

    @Override
    void video_call(BigInteger phoneNumber) {
        System.out.println("FaceTiming the phone number: " + phoneNumber);
    }

    @Override
    void video_call(String email) {
        System.out.println("FaceTiming the user with email: " + email);
    }
}

class Consumer {
    public static void main(String[] args) {
        final Samsung galaxy = new Samsung("1020394959697", "M31", "6.1", "3600", "12");

        final Iphone xs = new Iphone("1202101201202", "XS", "5.9", "3000", "16.1.2");

        BigInteger phoneNumber = new BigInteger("9822877994");
        String email = "roshish152002@gmail.com";

        galaxy.voice_call(phoneNumber);
        galaxy.video_call(email);

        xs.voice_call(email);
        xs.video_call(phoneNumber);
    }
}
