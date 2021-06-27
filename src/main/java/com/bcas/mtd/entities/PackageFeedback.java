package com.bcas.mtd.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table
public class PackageFeedback extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mUser_id", nullable = false)
    private MUser mUser;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "package_id", nullable = false)
    private Package packages;

    private String comment;
    private int rating;

    public PackageFeedback() {
    }

    public PackageFeedback(MUser user, Package packages, String comment, int rating) {
        this.mUser = user;
        this.packages = packages;
        this.comment = comment;
        this.rating = rating;
    }

    public PackageFeedback(String comment, int rating) {
        this.comment = comment;
        this.rating = rating;
    }

    public MUser getUser() {
        return mUser;
    }

    public void setUser(MUser user) {
        this.mUser = user;
    }

    public Package getPackages() {
        return packages;
    }

    public void setPackages(Package packages) {
        this.packages = packages;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
