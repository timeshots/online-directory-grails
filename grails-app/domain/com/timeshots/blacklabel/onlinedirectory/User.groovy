package com.timeshots.blacklabel.onlinedirectory

class User {

	String firstName
	String lastName
	String emailAddress
	String username
	String password

    static constraints = {
		firstName(nullable: false)
		lastName(nullable: false)
		emailAddress(nullable: false, email: true)
		username(nullable: true, matches:"[a-zA-Z0-9]+")
		password(nullable: false, password: true)
    }

	@Override
	String toString(){
		return lastName
	}
}