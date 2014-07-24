package com.timeshots.blacklabel.onlinedirectory

/**
 * Created by borrero on 7/20/14.
 */
class Address {
    String streetAddress;
    String city;
    String state;
    String zipCode;

    static belongsTo = [person: Person]

    static constraints = {
        streetAddress(blank: false)
        city(nullable: false)
        state(nullable: false)
        zipCode(nullable: false, validator: {val, obj ->
            val?.isNumber()
        })
    }
}