# Recruitment task 
#### This is recruitment task form my internship, resolved according to specific guidelines:

" .. among other things, that task verifiers will pay attention to:
* code cleanliness and good object oriented programming practices
* the ability to use ready-made libraries, where it can significantly shorten and simplify the code
* unit and integration tests to verify that the code actually works correctly
* reasonable error handling - it is impossible to protect against everything, but leaving the "happy path" alone will not be appreciated 😉
* maximum flexibility when it comes to configuration - so that there is no need to recompile the solution for no reason
* whether the code and tests can be run not only from the IDE but also from the command line "

![recruitment task](https://user-images.githubusercontent.com/44747531/121699453-3ae41800-cacf-11eb-8d4f-7411ffc2b8ec.PNG)


## How to Run project: 
Github REST Api
To Deploy Application on your computer, you need Java 8+ and Maven:

1. Pull the project
2. Command Line:
>mvnw clean install

3. Run .jar file with command:
>java -jar patch\file_name.jar

4. To print repository info use endpoint:
>localhost:8080/repositories/{username}/{repository_name}
