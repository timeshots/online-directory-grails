grails.servlet.version = "3.0" // Change depending on target container compliance (2.5 or 3.0)
grails.project.class.dir = "target/classes"
grails.project.test.class.dir = "target/test-classes"
grails.project.test.reports.dir = "target/test-reports"
grails.project.work.dir = "target/work"
grails.project.target.level = 1.6
grails.project.source.level = 1.6
//grails.project.war.file = "target/${appName}-${appVersion}.war"

grails.project.fork = [
    // configure settings for compilation JVM, note that if you alter the Groovy version forked compilation is required
    //  compile: [maxMemory: 256, minMemory: 64, debug: false, maxPerm: 256, daemon:true],

    // configure settings for the test-app JVM, uses the daemon by default
    test: [maxMemory: 768, minMemory: 64, debug: false, maxPerm: 256, daemon:true],
    // configure settings for the run-app JVM
    run: [maxMemory: 768, minMemory: 64, debug: false, maxPerm: 256, forkReserve:false],
    // configure settings for the run-war JVM
    war: [maxMemory: 768, minMemory: 64, debug: false, maxPerm: 256, forkReserve:false],
    // configure settings for the Console UI JVM
    console: [maxMemory: 768, minMemory: 64, debug: false, maxPerm: 256]
]

grails.project.dependency.resolver = "maven" // or ivy
grails.project.dependency.resolution = {
    // inherit Grails' default dependencies
    inherits("global") {
        // specify dependency exclusions here; for example, uncomment this to disable ehcache:
        // excludes 'ehcache'
    }
    log "error" // log level of Ivy resolver, either 'error', 'warn', 'info', 'debug' or 'verbose'
    checksums true // Whether to verify checksums on resolve
    legacyResolve false // whether to do a secondary resolve on plugin installation, not advised and here for backwards compatibility

    def gebVersion = '0.9.2'
    def seleniumVersion = '2.41.0'

    repositories {
        inherits true // Whether to inherit repository definitions from plugins

        grailsPlugins()
        grailsHome()
        mavenLocal()
        grailsCentral()
        mavenCentral()
        mavenRepo 'http://repo.spring.io/milestone'
        // uncomment these (or add new ones) to enable remote dependency resolution from public Maven repositories
        //mavenRepo "http://repository.codehaus.org"
        //mavenRepo "http://download.java.net/maven/2/"
        //mavenRepo "http://repository.jboss.com/maven2/"
    }

    dependencies {
        // specify dependencies here under either 'build', 'compile', 'runtime', 'test' or 'provided' scopes e.g.
        runtime 'mysql:mysql-connector-java:5.1.27'
        //runtime 'mysql:mysql-connector-java:5.1.20'
        //runtime 'apacheexec:commons-exec:1.1'
        //runtime 'mysql:mysql-connector-java:5.1.18'
        // runtime 'org.postgresql:postgresql:9.3-1100-jdbc41'
        //runtime ':twitter-bootstrap:3.1.1'

        compile 'com.amazonaws:aws-java-sdk:1.7.5'
        build 'org.apache.httpcomponents:httpcore:4.2'
        build 'org.apache.httpcomponents:httpclient:4.2'
        runtime 'org.apache.httpcomponents:httpcore:4.2'
        runtime 'org.apache.httpcomponents:httpclient:4.2'
        //test "org.seleniumhq.selenium:selenium-chrome-driver:$seleniumVersion"
        test "org.gebish:geb-spock:$gebVersion"
        //runtime 'org.postgresql:postgresql:9.3-1100-jdbc4'
        //test('com.github.detro.ghostdriver:phantomjsdriver:1.0.4') { transitive = false }
        //compile 'com.google.guava:guava:17.0'
    }

    plugins {
        //build ':tomcat:7.0.54'
        //compile ':aws-sdk:1.7.7'
        // plugins for the compile step
        compile ':scaffolding:2.1.2'
        compile ':cache:1.1.7'

        // plugins needed for the email confirmation
        compile ":mail:1.0.6"
        //compile ":email-confirmation:2.0.8"

        //spring security plugin
        compile ":spring-security-core:2.0-RC3"
        compile ":spring-security-rest:1.4.0.RC3", {
            excludes: 'spring-security-core'
        }

        // plugins needed at runtime but not for compilation
        runtime ':hibernate:3.6.10.16' // or ':hibernate4:4.3.4'
        runtime ':database-migration:1.4.0'
        runtime ':jquery:1.11.0.2'
        compile ':asset-pipeline:1.8.11'
		

        //multi tenancy plugin
        compile ':multi-tenant-single-db:0.8.3'

        //test data builder plugin
        compile ':build-test-data:2.1.2'

        //functional testing plugin
        //test ":geb:$gebVersion"
        // test ':code-coverage:1.2.7'
        test ":code-coverage:2.0.3-1"
        // Not required, but very useful in speeding up working with functional tests
        //to use, run: 'grails develop-functional-tests'
        compile ':functional-test-development:0.9.3'
        //compile ':funky-test-load:0.3.9'
        compile ':quartz:1.0.1'

        compile ":platform-core:1.0.0"

/******************************************************************************/

        // plugins for the build system only
        build ":tomcat:7.0.53"

        // plugins for the compile step
        //compile ":scaffolding:2.0.3"
        //compile ':cache:1.1.2'

        // plugins needed at runtime but not for compilation
        //runtime ":hibernate:3.6.10.15" // or ":hibernate4:4.3.5.2"
        //runtime ":database-migration:1.4.0"
        //runtime ":jquery:1.11.1"
        runtime ":resources:1.2.8"

        //compile ':spring-security-core:1.2.7.3'
        //compile ':mongodb:1.0.0.GA'
        //compile ':webxml:1.4.1'
        //compile ':ws-client:1.0'
        //runtime ':lesscss-resources:1.3.0.3'

        // Uncomment these (or add new ones) to enable additional resources capabilities
        //runtime ":zipped-resources:1.0.1"
        //runtime ":cached-resources:1.1"
        //runtime ":yui-minify-resources:0.1.5"

        // An alternative to the default resources plugin is the asset-pipeline plugin
        //compile ":asset-pipeline:1.6.1"

        // Uncomment these to enable additional asset-pipeline capabilities
        //compile ":sass-asset-pipeline:1.5.5"
        //compile ":less-asset-pipeline:1.5.3"
        //compile ":coffee-asset-pipeline:1.5.0"
        //compile ":handlebars-asset-pipeline:1.3.0.1"

        //compile ":bootstrap-theme:1.0.RC3"
        //compile ":kickstart-with-bootstrap:1.1.0"
        //compile ":platform-ui:1.0.RC7"
        compile ":twitter-bootstrap:2.3.0"
        compile ":lesscss-resources:1.3.3"

        //compile ":twitter-bootstrap:3.2.1"
    }
}
		
/*
grails.servlet.version = '3.0' // Change depending on target container compliance (2.5 or 3.0)
grails.project.class.dir = 'target/classes'
grails.project.test.class.dir = 'target/test-classes'
grails.project.test.reports.dir = 'target/test-reports'
grails.project.work.dir = 'target/work'
grails.project.target.level = 1.6
grails.project.source.level = 1.6
//grails.project.war.file = 'target/${appName}-${appVersion}.war'

grails.project.fork = [
        // configure settings for compilation JVM, note that if you alter the Groovy version forked compilation is required
        //  compile: [maxMemory: 256, minMemory: 64, debug: false, maxPerm: 256, daemon:true],

        // configure settings for the test-app JVM, uses the daemon by default
        test: [maxMemory: 768, minMemory: 64, debug: false, maxPerm: 256, daemon:true],
        // configure settings for the run-app JVM
        run: [maxMemory: 768, minMemory: 64, debug: false, maxPerm: 256, forkReserve:false],
        // configure settings for the run-war JVM
        war: [maxMemory: 768, minMemory: 64, debug: false, maxPerm: 256, forkReserve:false],
        // configure settings for the Console UI JVM
        console: [maxMemory: 768, minMemory: 64, debug: false, maxPerm: 256]
]

grails.project.dependency.resolver = 'maven' // or ivy
grails.project.dependency.resolution = {
    // inherit Grails' default dependencies
    inherits('global') {
        // specify dependency exclusions here; for example, uncomment this to disable ehcache:
        // excludes 'ehcache'
    }
    log 'error' // log level of Ivy resolver, either 'error', 'warn', 'info', 'debug' or 'verbose'
    checksums true // Whether to verify checksums on resolve
    legacyResolve false // whether to do a secondary resolve on plugin installation, not advised and here for backwards compatibility

    def gebVersion = '0.9.2'
    def seleniumVersion = '2.41.0'


    repositories {
        inherits true // Whether to inherit repository definitions from plugins

        grailsPlugins()
        grailsHome()
        mavenLocal()
        grailsCentral()
        mavenCentral()
        mavenRepo 'http://repo.spring.io/milestone'
        // uncomment these (or add new ones) to enable remote dependency resolution from public Maven repositories
        //mavenRepo 'http://repository.codehaus.org'
        //mavenRepo 'http://download.java.net/maven/2/'
        //mavenRepo 'http://repository.jboss.com/maven2/'
    }

    dependencies {

        compile 'com.amazonaws:aws-java-sdk:1.7.5'
        build 'org.apache.httpcomponents:httpcore:4.2'
        build 'org.apache.httpcomponents:httpclient:4.2'
        runtime 'org.apache.httpcomponents:httpcore:4.2'
        runtime 'org.apache.httpcomponents:httpclient:4.2'
        test "org.seleniumhq.selenium:selenium-chrome-driver:$seleniumVersion"
//        test('org.seleniumhq.selenium:selenium-firefox-driver:$seleniumVersion')
        test "org.gebish:geb-spock:$gebVersion"
        runtime 'org.postgresql:postgresql:9.3-1100-jdbc4'
        test('com.github.detro.ghostdriver:phantomjsdriver:1.0.4') { transitive = false }
        compile 'com.google.guava:guava:17.0'
        // compile 'org.seleniumhq.selenium:selenium-htmlunit-driver:2.41.0'
    }

    plugins {
        // plugins for the build system only
        build ':tomcat:7.0.54'
        compile ':aws-sdk:1.7.7'
        // plugins for the compile step
        compile ':scaffolding:2.1.2'
        compile ':cache:1.1.7'

        // plugins needed for the email confirmation
        compile ":mail:1.0.6"
        //compile ":email-confirmation:2.0.8"

        //spring security plugin
        compile ":spring-security-core:2.0-RC3"
        compile ":spring-security-rest:1.4.0.RC3", {
            excludes: 'spring-security-core'
        }

        // plugins needed at runtime but not for compilation
        runtime ':hibernate:3.6.10.16' // or ':hibernate4:4.3.4'
        runtime ':database-migration:1.4.0'
        runtime ':jquery:1.11.0.2'
        compile ':asset-pipeline:1.8.11'
        runtime ':resources:1.2.8'
        // Uncomment these (or add new ones) to enable additional resources capabilities
        //runtime ':zipped-resources:1.0.1'
        //runtime ':cached-resources:1.1'
        //runtime ':yui-minify-resources:0.1.5'

        // An alternative to the default resources plugin is the asset-pipeline plugin
        //compile ':asset-pipeline:1.6.1'

        // Uncomment these to enable additional asset-pipeline capabilities
        //compile ':sass-asset-pipeline:1.5.5'
        //compile ':less-asset-pipeline:1.5.3'
        //compile ':coffee-asset-pipeline:1.5.0'
        //compile ':handlebars-asset-pipeline:1.3.0.1'

        //multi tenancy plugin
        compile ':multi-tenant-single-db:0.8.3'

        //test data builder plugin
        compile ':build-test-data:2.1.2'

        //functional testing plugin
        test ":geb:$gebVersion"
        // test ':code-coverage:1.2.7'
        test ":code-coverage:2.0.3-1"
        // Not required, but very useful in speeding up working with functional tests
        //to use, run: 'grails develop-functional-tests'
        compile ':functional-test-development:0.9.3'
//        compile ':funky-test-load:0.3.9'
        compile ':quartz:1.0.1'

        compile ":platform-core:1.0.0"
		
		compile ":scaffolding:2.0.3"
		compile ':cache:1.1.2'
    }
}*/