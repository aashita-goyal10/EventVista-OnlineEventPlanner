package com.eventVista.vendorPackage;

public class VendorPackage {
    private int vendorPackageId;
    private String vendorPackageType;// basic/premium/classic
    private double cost;
    private String listOfServices;

    public VendorPackage(int vendorPackageId, String vendorPackageType, double cost, String listOfServices) {
        this.vendorPackageId = vendorPackageId;
        this.vendorPackageType = vendorPackageType;
        this.cost = cost;
        this.listOfServices = listOfServices;
    }

    public int getVendorPackageId() {
        return vendorPackageId;
    }

    public void setVendorPackageId(int vendorPackageId) {
        this.vendorPackageId = vendorPackageId;
    }

    public String getVendorPackageType() {
        return vendorPackageType;
    }

    public void setVendorPackageType(String vendorPackageType) {
        this.vendorPackageType = vendorPackageType;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String getListOfServices() {
        return listOfServices;
    }


    public void setListOfServices(String listOfServices) {
        this.listOfServices = listOfServices;
    }
}
