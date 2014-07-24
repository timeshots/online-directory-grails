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
        streetAddress(nullable: false)
        city(nullable: false)
        state(nullable: false)
        zipCode(nullable: false)
    }

    @Override
    String toString(){
        return streetAddress
    }
}