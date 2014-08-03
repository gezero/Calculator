Calculator
==========

Exam application - Simple application reading input file and executing instructions from it. 

Build
=====
To build this application you should be able to run `gradlew build` task. That should download gradle, and build everything.
Among other things this will run the tests in the src/test directory. Test reports can be found in the build/reports directory.

Running
=======
To run the application you have few options. Firstly You can use `gradle run` task.
This task is not accepting arguments in a convenient way. If you want to use `gradlew run` task you will need to pass
arguments in the following way: `gradlew run -PappArgs="['src/test/resources/programs/program1']"`

If you do not like the gradle output add -q option as a first parameter.

Another option you have is to create/install the distribution package. Creating distribution package will create zip(tar) 
file containing everything necessary to run the program. Try running `gradlew distZip` this will create zip file in the build/distributions
directory. 
 
The contents of the archive will be similar to what will be created using the `gradlew installApp` command. Look in the build/install
directory. 

In both situations there is an executable in the bin subdirectory that you can run and add parameters to it normally.

Usage
=====
The application expects 1 parameter and that is path to file containing instructions. The application will print help string
in case you will not run it properly and will print result of the calculation in case you run it properly.


