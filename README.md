# Fully Automatic Beverage Vending Machine

## Compile and Execute the code

| CS-665       | Software Design & Patterns |
|--------------|----------------------------|
| Name         | Yulong Liu                 |
| Date         | 02/016/2024                |
| Course       | Fall / Spring / Summer     |
| Assignment # | 2                          |

# Assignment Overview

This assignment is to implement a Automatic Beverage Machine, which can be used to make coffee and tea beverage with
some condiments, and calculate the price of the final product.

# GitHub Repository Link:

https://github.com/nioliu/cs-665-assignment-2/tree/main

# Implementation Description

My implement of Automatic Beverage Vending Machine utilize the **Strategy Pattern** as part of my main software design
concepts.

1. Strategy design Pattern
    - Allows the vending machine's behavior to be changed at runtime by invoke different brewing algorithm
      like `Americano`
    - Allows the clients change strategy easily with `switchBrewMethod`.
    - You can also easily add more brewing algorithm with only 2 steps:
        1. create a new class like `RedTea`
        2. Implement the three method to extend `BeverageStrategy` abstract class.
2. Simplicity and understandability
    - Developer can understand easily from the `class UML`.
    - Each main class and method has clear and meaningful comments which can also help developer to read.
3. Encapsulation
    - Hides the internal state and functionality of the brewing strategies and condiments to prevent unauthorized access
      or changes.
    - The `BeverageStrategy` and `Condiment` abstract class hide some fields like `brew()`,`price()`,`add()`, and only
      expose some methods which are meaningful for users like `execute()` to execute brewing process, `addCondiments()`
      to add condiments into beverage.
    - Only can be implemented in beverage package, in case other package invoke this abstract class and doesn't
      implement abstract method.
4. Abstraction
    - Define some common methods for common logics and abstract methods for specified logics, allowing for flexible
      extension with different beverages.
5. Inheritance
    - Allow developer to extend `BeverageStrategy` and `Condiment` easily.

## UML

```mermaid

classDiagram
%% can add more strategy easily just to implement this interface
class BeverageStrategy{
 <<abstract>>
 -realStrategy: BeverageStrategy
 ~condiments: List<Condiment>
 %% return the price
 #brew()
 #price() double
 #name() String
 +execute() *
 +addCondiments(Codiments)*
 +switchBrewMethod(BeverageStrategy)*
}

class Americano{
 #brew()
 #price() double
 #name() String
}

class GreenTea{
 #brew()
 #price() double
 #name() String
}

class Condiment{
 <<abstract>>
 %% to mark which condiment
 ~getCondimentId() String
 %% to get the price if each condiment has its own price
 %% set this to public for client to get the price of curr condiment
 +price() double
 %% add current condiment
 ~add()
}

class milk{
 %% to mark which condiment
 ~getCondimentId() String
 %% to get the price if each condiment has its own price
 %% set this to public for client to get the price of curr condiment
 +price() double
 %% add current condiment
 ~add()
}

class sugar{
 %% to mark which condiment
 ~getCondimentId() String
 %% to get the price if each condiment has its own price
 %% set this to public for client to get the price of curr condiment
 +price() double
 %% add current condiment
 ~add()
}

%% implement beverage
BeverageStrategy <|..  GreenTea
BeverageStrategy <|..  Americano
%% implement condiment
Condiment <|.. milk
Condiment <|.. sugar
%% Beverage aggregation
BeverageStrategy --o Condiment





```

## How to use?

```java
public void testAllMethods() throws Exception {
    GreenTea beverage = new GreenTea(); // assume you want a green tea
    beverage.addCondiments(new Sugar(), new Milk(), new Milk());// and ass some condiments
    beverage.switchBeverageStrategy(new YellowTea());// then you want to change to yellow tea
    logger.info(beverage.getReceipt());// now you want to take a look at the receipt base on your chose
    beverage.addCondiments(new Sugar());// and you decide to add one more sugar
    logger.info(beverage.getReceipt());// and check the receipt
    beverage.execute();// then begin to brew
    logger.info(beverage.getTotalPrice());// finally, get the total price
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



