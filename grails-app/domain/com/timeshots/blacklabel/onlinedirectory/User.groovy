package com.timeshots.blacklabel.onlinedirectory

class User {

    transient springSecurityService
	String firstName
	String lastName
	String emailAddress
	String username
	String password
    Boolean hasConfirmedEmail
    String id

    static transients = ['springSecurityService']

    static constraints = {
		firstName(nullable: false)
		lastName(nullable: false)
		emailAddress(nullable: false, email: true)
		username(nullable: true, matches:"[a-zA-Z0-9]+")
		password(nullable: false, password: true)
        hasConfirmedEmail(nullable: false)
    }

    static mapping = {
        hasConfirmedEmail(defaultValue: false)
        table 'users'
        password column: '`password`'
        id generator:'uuid'
    }

    def beforeInsert() {
        if (password != null) {
            encodePassword()
        }
    }

    def beforeUpdate() {
        if (isDirty('password')) {
            encodePassword()
        }
    }

    protected void encodePassword() {
        password = springSecurityService.encodePassword(password)
    }
}