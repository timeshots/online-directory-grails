package com.timeshots.blacklabel.onlinedirectory

/**
 * Created by borrero on 7/20/14.
 */
class Person {
    String firstName;
    String lastName;
    Address address;

    static hasMany = [address: Address]

    static constraints = {
        firstName(nullable: false)
        lastName(nullable: false)
        address(nullable: true)
    }
}