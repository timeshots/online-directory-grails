import com.timeshots.blacklabel.onlinedirectory.Address
import com.timeshots.blacklabel.onlinedirectory.Person
import com.timeshots.blacklabel.onlinedirectory.User

class BootStrap {
    def init = { servletContext ->
        Address add_one = new Address(state: 'NY', city: 'Windsor', streetAddress: '117 W 2nd St', zipCode: '11111').save(failOnError: true)
        Address add_two = new Address(state: 'NY', city: 'Windsor', streetAddress: '117 W 2nd St', zipCode: '22222').save(failOnError: true)
        Address add_three = new Address(state: 'NY', city: 'Windsor', streetAddress: '117 W 2nd St', zipCode: "33333").save(failOnError: true)

        def johnDoe = new Person(firstName: 'John', lastName: 'Doe', address: add_one).save(failOnError: true)
        def larryBor = new Person(firstName: 'Larry', lastName: 'Borrero', address: add_two).save(failOnError: true)
        def darKim = new Person(firstName: 'Darel', lastName: 'Kim', address: add_three).save(failOnError: true)

        User larry = new User(firstName: 'Larry', lastName: 'Borrero', emailAddress: 'redwolfgang20@gmail.com', username: 'redwolfgang20', password: 'redwolfgang1990', hasConfirmedEmail: true).save(flush: true, failOnError: true)
        User whitehot = new User(firstName: 'White', lastName: 'Hot', emailAddress: 'whitehot@gmail.com', username: 'white', password: 'whitehot', hasConfirmedEmail: true).save(flush: true, failOnError: true)
    }

    def destroy = {
    }
}