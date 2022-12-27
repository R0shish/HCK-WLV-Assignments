package Week5_CaseStudy.Auth;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Passwords {
    private List<Map<String, String>> passwordData;

    {
        passwordData = new ArrayList<>();

        Map<String, String> admin1 = new HashMap<>();
        admin1.put("username", "Roshish");
        admin1.put("password", "admin123");
        admin1.put("role", "Admin");
        passwordData.add(admin1);

        Map<String, String> admin2 = new HashMap<>();
        admin2.put("username", "Admin");
        admin2.put("password", "admin");
        admin2.put("role", "Admin");
        passwordData.add(admin2);

        Map<String, String> landlord1 = new HashMap<>();
        landlord1.put("username", "landlord1");
        landlord1.put("password", "landlord");
        landlord1.put("role", "Landlord");
        passwordData.add(landlord1);

        Map<String, String> landlord2 = new HashMap<>();
        landlord2.put("username", "landlord2");
        landlord2.put("password", "landlord");
        landlord2.put("role", "Landlord");
        passwordData.add(landlord2);

        Map<String, String> tenant1 = new HashMap<>();
        tenant1.put("username", "tenant1");
        tenant1.put("password", "tenant");
        tenant1.put("role", "Tenant");
        passwordData.add(tenant1);

        Map<String, String> tenant2 = new HashMap<>();
        tenant2.put("username", "tenant2");
        tenant2.put("password", "tenant");
        tenant2.put("role", "Tenant");
        passwordData.add(tenant2);
    }

    public List<Map<String, String>> getPasswordData() {
        return passwordData;
    }
}
