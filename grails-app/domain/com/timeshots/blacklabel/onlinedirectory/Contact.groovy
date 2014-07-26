package com.timeshots.blacklabel.onlinedirectory

/**
 * Created by borrero on 7/26/14.
 */
class Contact {
    String emailAddress
    String phoneNumber
    String cellphoneNumber

    Profile profile

    static constraints = {
        emailAddress(nullable: false)
        phoneNumber(nullable: true)
        cellphoneNumber(nullable: true)

        profile(nullable: true)
    }
}