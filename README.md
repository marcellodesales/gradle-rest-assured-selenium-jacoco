gradle-rest-assured-selenium-jacoco
=======================

This project provides a Gradle build file with a basic setup to start developing web applications
for [Tomcat](http://tomcat.apache.org/) leveraging [FluentLenium](https://github.com/FluentLenium/FluentLenium),
to write and execute [Selenium Tests](http://seleniumhq.org/) in addition to REST-ASSURED tests.

This was based on https://github.com/moritzzimmer/gradle-selenium-fixture.

## Features

* integration test setup (source folders, dependencies etc.) 
* configured [Tomcat Plugin](https://github.com/bmuschko/gradle-tomcat-plugin/)
* [JaCoCo](http://www.eclemma.org/jacoco/) code coverage. NOT WORKING WHEN RUNNING WITH TOMCAT.

## Requirements

Gradle 1.0+ (wrapper is included)

## Usage

To run the integration tests and generate the Jacoco reports (Still 0% bug), execute the following task:

	gradle integrationTest jacocoReport
 
This will start an embedded tomcat server, execute all integration tests and shutdown the server:

	integrationTest.doFirst {
  		println 'Starting the embedded tomcat server'
  		tasks.tomcatRun.daemon = true
  		tasks.tomcatRun.execute()
	}

	integrationTest.doLast {
  		println 'Stopping the embedded tomcat server'
  		tasks.tomcatStop.execute()
	}
	
The 'integrationTest' task has a dependency to 'check' so you can also execute:

	gradle check
