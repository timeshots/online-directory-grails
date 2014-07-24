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
        cityy(blank: false)
        state(blank: false, size: 2.2)
        zipCode(blank: false, size: 5.5, validator: {val, obj ->
            val?.isNumber()
        })
    }
}