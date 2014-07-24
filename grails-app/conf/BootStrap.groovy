import com.timeshots.blacklabel.onlinedirectory.Person

class BootStrap {

    def init = { servletContext ->
        if(!Person.count()){
            def johnDoe = new Person(firstName: 'John', lastName: 'Doe').save(failOnError: true)
            def larryBor = new Person(firstName: 'Larry', lastName: 'Borrero').save(failOnError: true)
            def darKim = new Person(firstName: 'Darel', lastName: 'Kim').save(failOnError: true)

            johnDoe.addToAddresses(new Address(state: 'NY', city: 'Windsor', streetAddress: '117 W 2nd St', zipCode: '55555')).save(failOnError: true)
            larryBor.addToAddresses(new Address(state: 'PH', city: 'Cebu', streetAddress: '900 Apas Cebu', zipCode: '10011')).save(failOnError: true)
            darKim.addToAddresses(new Address(state: 'PH', city: 'Cebu', streetAddress: '900 Apas Cebu', zipCode: '10011')).save(failOnError: true)
        }
    }

    def destroy = {
    }
}