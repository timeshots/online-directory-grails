package com.timeshots.blacklabel.onlinedirectory

class User {

	transient springSecurityService
	String id
	String firstName
	String lastName
	String emailAddress
	String username
	String password

	static transients = ['springSecurityService']

    static constraints = {
		firstName(nullable: false, blank: false)
		lastName(nullable: false, blank: false)
		emailAddress(nullable: false, blank: false, email: true)
		username(nullable: true, matches:"[a-zA-Z0-9]+")
		password(nullable: false, password: true)
    }

	static mapping = {
		table 'users'
		password column: '`password`'
		id generator:"uuid"
	}
}