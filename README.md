# Proyecto-ASJ-ED
At the start in the Main.java code we can see at least 10 "Code Smells", each "Code Smells" have a type, this is the way that we are going to order it.

Bloaters:
There is 2 bloaters in this code.
-Long Method: Being here the *BadSeleniumTest.testE2EShoppingFlow()*, is basically a single method with all the flow(Login, checkout,etc..)

-Large Class: Being here the *BadSeleniumTest* has a lot of content and too many responsabilities (WebDriver, UI Actions,etc...)

Object-Orientation Abusers:
There is 2 Object-Orientation Abusers in this code.
-Switch Statements: The *setup()* uses a switch instead of polymorphism.

-Temporary Fields: *tempUsername*, *tempPassword*, and *tempLoginTime* in *BadSeleniumTest* are used only for the first lines then they aren´t used in the rest of the code.

Change Preventers:

-Divergent Change: *BadSeleniumTest* has to change a lot by many factors, for example for configure de WebDrivers or change how the data is managed.

-Shothun Surgery: For change the login format or framework, we have to shotgun surgery across too many line because of the *System.out.println("[LOG...")* that is scattered in the code.

Dispensables:

-Duplicate Code: For Example, we have the same *while* loop in the methods *waitForId*, *waitForXpath* and *waitForClass*

-Dead Code: The *oldLoginMethod()* and the *nusedField* variable in *BadSeleniumTest* are entirely unused.

Couplers:In Reporter.java`, the `generateReport()` method "envies" `BadSeleniumTest`, making 5 consecutive calls to its getters/fields to format a string.

-Feature Envy: 

-Inappropiate Intimacy: *Reporter.java* directly accesses the package-private fields (*testName*, *browserType*, *driver*) of *BadSeleniumTest* instead of respecting encapsulation.
