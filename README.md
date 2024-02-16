# Fully Automatic Beverage Vending Machine

## Compile and Execute the code

| CS-665       | Software Design & Patterns |
|--------------|----------------------------|
| Name         | Yulong Liu                 |
| Date         | 02/016/2024                |
| Course       | Fall / Spring / Summer     |
| Assignment # | 2                          |

# Assignment Overview

This assignment is to develop a notification system that will inform drivers about delivery requests.

# GitHub Repository Link:

https://github.com/nioliu/cs-665-assignment-2/tree/main

# Implementation Description

The design of the Delivery System utilizes the **Observer Pattern** to create a flexible and maintainable
structure that supports dynamic registration and notification of drivers about delivery requests.

1. **Observer Pattern**:
    - Facilitates the communication between retailers and drivers without making them directly dependent on each other,
      enhancing modularity and reducing coupling.
    - The `Retailer` acts as a mediator with a collection of `Subject` objects, each capable of managing its own set
      of `Driver` observers.
    - New `Subject` instances representing different delivery contexts can be added seamlessly, allowing for scalability
      in the notification process.
2. **Composition and Association**:
    - Retailers maintain a collection of `Subject` instances, which are managed via composition within a map structure,
      indicating ownership and lifecycle management.
    - The `Subject` objects passed to the `Retailer` as constructor arguments represent a dependency relationship, which
      allows for flexibility in assigning different subjects to different retailers.
3. **Encapsulation and Abstraction**:
    - The system encapsulates the details of the notification logic within the `Subject` and `Driver` classes, exposing
      only the necessary interface for registering and notifying observers.
    - Abstracts the concept of notification from the specific implementations, allowing for the `Driver` interface to be
      implemented by various concrete driver classes with different behaviors.
4. **Inheritance and Extensibility**:
    - The system is designed to be extensible, where new types of drivers or notification subjects can be introduced by
      extending the base `Driver` and `Subject` interfaces.

## UML

```mermaid

classDiagram

class Driver{
 <<interface>>
 +DriverType: enum
 +driverLicense() String
 +driverType() DriverType
 +receiveNewDeliveryRequest()
}

class FreelanceVan{
    -driverLicense:String
    -driverType:DriverType
    +driverLicense()String
    +driverType()DriverType
    +receiveNewDeliveryRequest()
}

class TaxiDriver{
    -driverLicense:String
    -driverType:DriverType
    +driverLicense()String
    +driverType()DriverType
    +receiveNewDeliveryRequest()
}

class Subject{
    <<interface>>
    +registerObserver()
    +notifyObservers()
    +removeObserver()
}

class DeliveryRequest{
    -driverMap : HashMap
    +registerObserver()
    +notifyObservers()
    +removeObserver()
}

class Retailer{
    <<abstract>>
    -subjectMap : HashMap
    +notify()
    +removeSubject()
    #id()enum*
    #address()String*
}

class Retailer1{
    #id()enum
    #address()String
}

class Retailer2{
    #id()enum
    #address()String
}

class Delivery{
    -retailer : Retailer
    -addtionalDetail : AdditionalDeliveryDetail
    getDeliveryDetails()String
}

class AdditionalDeliveryDetail{
    - productInfo : String
    - destineAddr : String
    - fees: double
}

%% implement beverage
Driver <|..  FreelanceVan
Driver <|..  TaxiDriver
%% implement condiment
Subject <|.. DeliveryRequest
Retailer <|-- Retailer1
Retailer <|-- Retailer2
%% driver dependent driver
Subject..>Driver
%% Delivery reuqest composit AdditionalDeliveryDetail
Delivery..>AdditionalDeliveryDetail
DeliveryRequest..>Delivery
Retailer..>Subject
```

## How to use?

```java
 public void TestBasic() {
   DeliveryRequest deliveryRequest1 = new DeliveryRequest("1"); // subject
   Retailer1 retailer1 = new Retailer1(deliveryRequest1);
   Driver taxiDriver1 = new TaxiDriver("123");// observer
   Driver taxiDriver2 = new TaxiDriver("456");// observer
   Driver taxiDriver3 = new TaxiDriver("789");// observer
   Driver taxiDriver4 = new TaxiDriver("111");// observer
   Driver taxiDriver5 = new TaxiDriver("222");// observer
   Driver taxiDriver6 = new TaxiDriver("333");// observer

   deliveryRequest1.registerObserver(taxiDriver1, taxiDriver2, taxiDriver3, taxiDriver4, taxiDriver5, taxiDriver6);

   retailer1.notify(new Delivery.
           AdditionalDeliveryDetail("keyboard", "999, Boston, MA", 19.99));
}
```

# Maven Commands

We'll use Apache Maven to compile and run this project. You'll need to install Apache Maven (https://maven.apache.org/)
on your system.

Apache Maven is a build automation tool and a project management tool for Java-based projects. Maven provides a
standardized way to build, package, and deploy Java applications.

Maven uses a Project Object Model (POM) file to manage the build process and its dependencies. The POM file contains
information about the project, such as its dependencies, the build configuration, and the plugins used for building and
packaging the project.

Maven provides a centralized repository for storing and accessing dependencies, which makes it easier to manage the
dependencies of a project. It also provides a standardized way to build and deploy projects, which helps to ensure that
builds are consistent and repeatable.

Maven also integrates with other development tools, such as IDEs and continuous integration systems, making it easier to
use as part of a development workflow.

Maven provides a large number of plugins for various tasks, such as compiling code, running tests, generating reports,
and creating JAR files. This makes it a versatile tool that can be used for many different types of Java projects.

## Compile

Type on the command line:

```bash
mvn clean compile
```

## JUnit Tests

JUnit is a popular testing framework for Java. JUnit tests are automated tests that are written to verify that the
behavior of a piece of code is as expected.

In JUnit, tests are written as methods within a test class. Each test method tests a specific aspect of the code and is
annotated with the @Test annotation. JUnit provides a range of assertions that can be used to verify the behavior of the
code being tested.

JUnit tests are executed automatically and the results of the tests are reported. This allows developers to quickly and
easily check if their code is working as expected, and make any necessary changes to fix any issues that are found.

The use of JUnit tests is an important part of Test-Driven Development (TDD), where tests are written before the code
they are testing is written. This helps to ensure that the code is written in a way that is easily testable and that all
required functionality is covered by tests.

JUnit tests can be run as part of a continuous integration pipeline, where tests are automatically run every time
changes are made to the code. This helps to catch any issues as soon as they are introduced, reducing the need for
manual testing and making it easier to ensure that the code is always in a releasable state.

To run, use the following command:

```bash
mvn clean test
```

## Spotbugs

SpotBugs is a static code analysis tool for Java that detects potential bugs in your code. It is an open-source tool
that can be used as a standalone application or integrated into development tools such as Eclipse, IntelliJ, and Gradle.

SpotBugs performs an analysis of the bytecode generated from your Java source code and reports on any potential problems
or issues that it finds. This includes things like null pointer exceptions, resource leaks, misused collections, and
other common bugs.

The tool uses data flow analysis to examine the behavior of the code and detect issues that might not be immediately
obvious from just reading the source code. SpotBugs is able to identify a wide range of issues and can be customized to
meet the needs of your specific project.

Using SpotBugs can help to improve the quality and reliability of your code by catching potential bugs early in the
development process. This can save time and effort in the long run by reducing the need for debugging and fixing issues
later in the development cycle. SpotBugs can also help to ensure that your code is secure by identifying potential
security vulnerabilities.

Use the following command:

```bash
mvn spotbugs:gui 
```

For more info see
https://spotbugs.readthedocs.io/en/latest/maven.html

SpotBugs https://spotbugs.github.io/ is the spiritual successor of FindBugs.

## Checkstyle

Checkstyle is a development tool for checking Java source code against a set of coding standards. It is an open-source
tool that can be integrated into various integrated development environments (IDEs), such as Eclipse and IntelliJ, as
well as build tools like Maven and Gradle.

Checkstyle performs static code analysis, which means it examines the source code without executing it, and reports on
any issues or violations of the coding standards defined in its configuration. This includes issues like code style,
code indentation, naming conventions, code structure, and many others.

By using Checkstyle, developers can ensure that their code adheres to a consistent style and follows best practices,
making it easier for other developers to read and maintain. It can also help to identify potential issues before the
code is actually run, reducing the risk of runtime errors or unexpected behavior.

Checkstyle is highly configurable and can be customized to fit the needs of your team or organization. It supports a
wide range of coding standards and can be integrated with other tools, such as code coverage and automated testing
tools, to create a comprehensive and automated software development process.

The following command will generate a report in HTML format that you can open in a web browser.

```bash
mvn checkstyle:checkstyle
```

The HTML page will be found at the following location:
`target/site/checkstyle.html`



