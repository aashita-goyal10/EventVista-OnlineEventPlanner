package com.eventVista.main;

import com.eventVista.exceptions.VendorAlreadyExistsException;
import com.eventVista.exceptions.VendorDoesNotExistsException;
import com.eventVista.exceptions.VendorPackageAlreadyExistsException;
import com.eventVista.exceptions.VendorPackageDoesNotExistsException;
import com.eventVista.users.Admin;
import com.eventVista.users.Vendor;
import com.eventVista.vendorPackage.VendorPackage;

public class TestMain {
    public static void main(String[] args)throws VendorPackageDoesNotExistsException,VendorPackageAlreadyExistsException,VendorDoesNotExistsException,VendorAlreadyExistsException {
        Admin a=new Admin();
        Vendor v1=new Vendor("raj","pune","raj@gmail.com",9998987036L,1001);
//        a.addVendor(v1);
//        a.viewAllVendor();
//        a.viewAllEvents();
//        a.viewAllUsers();
//        a.viewAllPackages();
//        a.deleteVendor(1001);
        VendorPackage vp=new VendorPackage(343,"basic",666665.54,"catering,singing,photography");
//        v1.addPackage(vp);
        v1.updatePackage(vp);
    }

}
