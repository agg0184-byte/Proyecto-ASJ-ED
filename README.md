# Proyecto-ASJ-ED
At the start in the Main.java code we can see at least 10 "Code Smells", each "Code Smells" have a type, this is the way that we are going to order it.

1. **Long Method** *(Bloater)*: *Main.main()* contains the entire flow (setup, navigation, login, validation, and teardown) in a single massive method.
2. **Large Class / God Class** *(Bloater)*: The *Main* class has too many responsibilities—it configures the WebDriver, performs UI tests, and handles reporting.
3. **Duplicate Code** *(Dispensable)*: The logic for checking and printing the product items is duplicated with only minor differences in index.
4. **Magic Numbers & Strings** *(Obfuscator)*: Hardcoded values scattered throughout the code, such as the URL (`"https://www.saucedemo.com/"`) and credentials (`"standard_user"`).
5. **Long Parameter List** *(Bloater)*: The *fillForm* method takes 7 individual arguments instead of using an encapsulated parameter object.
6. **Hardcoded Sleeps** *(Test Automation Smell)*: Extensive use of explicit pauses (`Thread.sleep(2000)`) instead of using Selenium's robust implicit or explicit waits.
7. **Dead Code** *(Dispensable)*: The method *oldMethodThatIsNotUsedAnymore()* is completely unused in the codebase.
8. **Obvious Comments** *(Dispensable)*: The code contains redundant comments explaining exactly what the code does (e.g., `// Configure the web driver using webdrivermanager`).
9. **Inconsistent/Poor Naming** *(Obfuscator)*: Variables have meaningless names such as `d` (WebDriver), `u` (username WebElement), `p` (password WebElement), and `btn1`.
10. **Primitive Obsession** *(Object-Orientation Abuser)*: `fillForm` passes multiple individual primitive strings (`a`, `b`, `address`, etc.) instead of an encapsulated data object.
