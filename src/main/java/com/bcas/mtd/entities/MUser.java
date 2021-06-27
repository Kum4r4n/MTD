package com.bcas.mtd.entities;

import com.bcas.mtd.helper.UserType;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

@Table
@Entity
public class MUser extends BaseEntity {

    private String name;
    private String email;
    private String phone_number;
    private String address;
    private int userType;

    @OneToMany(mappedBy = "mUser", fetch = FetchType.LAZY)
    private Set<Booking> bookings;

    @OneToMany(mappedBy = "mUser",fetch = FetchType.LAZY)
    private Set<PackageFeedback> packageFeedbacks;

    public MUser() {
    }

    public MUser(String name, String email, String phonenumber, String address, int userType) {
        this.name = name;
        this.email = email;
        this.phone_number = phonenumber;
        this.address = address;
        this.userType = userType;
    }


    public MUser(String name, String email, String phonenumber, String address, int userType, Set<Booking> bookings, Set<PackageFeedback> packageFeedbacks) {
        this.name = name;
        this.email = email;
        this.phone_number = phonenumber;
        this.address = address;
        this.userType = userType;
        this.bookings = bookings;
        this.packageFeedbacks = packageFeedbacks;
    }
}
