package Week5_CaseStudy.SystemUser;

class LandlordNotFoundException extends RuntimeException {
    public LandlordNotFoundException() {
        super("Currently, there are no any landlords!");
    }
}

class TenantNotFoundException extends RuntimeException {
    public TenantNotFoundException() {
        super("Currently, there are no tenants!");
    }
}

class TenantBillNotFoundException extends RuntimeException {
    public TenantBillNotFoundException() {
        super("Tenant Bill not found!");
    }
}

class ReportNotFoundException extends RuntimeException {
    public ReportNotFoundException() {
        super("Currently, there are no reports for this tenant!!");
    }
}
