## Java-Junit-Selenium
[![Travis Status](https://travis-ci.org/saucelabs-sample-test-frameworks/Java-Junit-Selenium.svg?branch=master)](https://travis-ci.org/saucelabs-sample-test-frameworks/Java-Junit-Selenium)

This code is provided on an "AS-IS” basis without warranty of any kind, either express or implied, including without limitation any implied warranties of condition, uninterrupted use, merchantability, fitness for a particular purpose, or non-infringement. Your tests and testing environments may require you to modify this framework. Issues regarding this framework should be submitted through GitHub. For questions regarding Sauce Labs integration, please see the Sauce Labs documentation at https://wiki.saucelabs.com/. This framework is not maintained by Sauce Labs Support.

This framework will execute some basic Appium web tests against the Sauce Labs RDC, and update the test status on the platform at the end. It should be noted that Serenity has significant limitations with parallel running. Whilst it is possible fork and batch your tests to run concurrently, it is currently only possible to do this at the test level, and not for different capability sets. If you need to run your tests agianst multiple devices concurrently, you will have to spawn multiple mvn commands with alternate serenity.properties files (or POM, or command line).

### Environment Setup

1. Global Dependencies
    * Install [Maven](https://maven.apache.org/install.html)
    * Or Install Maven with [Homebrew](http://brew.sh/) (Easier)
    ```
    $ brew install maven
    ```
2. Project Dependencies
    * Check that packages are available
    ```
    $ cd RDC-Java-Junit-Selenium
    $ mvn test-compile
    ```
    * You may also want to run the command below to check for outdated dependencies. Please be sure to verify and review updates before editing your pom.xml file as they may not be compatible with your code.
    ```
    $ mvn versions:display-dependency-updates
    ```
3. Serenity.properties
   This file contains the configuration you will need to edit to get your script working. Any K:V pairs you enter with the prefix saucelabs_ will end up as part of the capabilities set. This is useful for things like browserName (saucelabs_browserName), deviceName, (saucelabs_deviceName) etc. You must specify the testobject_api_key as saucelabs_testobject_api_key in order for the code to function.
   
   
### Running Tests

#####Testing
```
$ mvn verify
```
[Sauce Labs RDC Dashboard](https://app.testobject.com)

### Advice/Troubleshooting
1. It may be useful to use a Java IDE such as IntelliJ or Eclipse to help troubleshoot potential issues. 
2. There may be additional latency when using a remote webdriver to run tests on Sauce Labs. Timeouts and/or waits may need to be increased.
    * [Selenium tips regarding explicit waits](https://wiki.saucelabs.com/display/DOCS/Best+Practice%3A+Use+Explicit+Waits)

### Resources
##### [Sauce Labs Documentation](https://wiki.saucelabs.com/)

##### [SeleniumHQ Documentation](http://www.seleniumhq.org/docs/)

##### [Junit Documentation](http://junit.org/javadoc/latest/index.html)

##### [Java Documentation](https://docs.oracle.com/javase/7/docs/api/)

##### [Stack Overflow](http://stackoverflow.com/)
* A great resource to search for issues not explicitly covered by documentation.

