package com.timeshots.blacklabel.onlinedirectory

/**
 * Created by borrero on 7/20/14.
 */
class Address {
    String streetAddress
    String city
    String state
    String zipCode

    static constraints = {
        streetAddress(nullable: true)
        city(nullable: false)
        state(nullable: true)
        zipCode(nullable: false)
    }
}