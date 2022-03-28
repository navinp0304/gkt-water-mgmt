# geektrust water management

**Build command  is**


```
mvn validate clean dependency:copy-dependencies compile test
```

### Above command runs unit tests and is dependent on junit 5.

Output is like
```
[INFO]
[INFO] Results:
[INFO]
[INFO] Tests run: 51, Failures: 0, Errors: 0, Skipped: 0
[INFO]
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] -------------------------
```

### For code coverage using jacoco run below command
```
mvn clean jacoco:prepare-agent test jacoco:report 
```

For ant run
./apache-ant-1.10.12/bin/ant

or 

run ./antbuild.sh

to get junit test reports.


navin  ~ | eclipse-workspace | geektrust | geektrust_water_management  gradle clean test jacocoReport

> Configure project :
sourcesets is [source set 'main', source set 'test']

BUILD SUCCESSFUL in 12s
5 actionable tasks: 5 executed





clover output using gradle
gradle -b buildclover.gradle  clean cloverGenerateReport

> Task :cloverInstrumentCodeForTest
[ant:javac] warning: [options] bootstrap class path not set in conjunction with -source 8
[ant:javac] 1 warning
[ant:javac] warning: [options] bootstrap class path not set in conjunction with -source 8
[ant:javac] 1 warning

> Task :cloverGenerateReport
Project geektrust_water_management classes coverage
Files: 14 Packages: 1 Classes: 14 LOC: 671 NCLOC: 449
Methods coverage 100.00
Elements coverage 100.00
Statements coverage 100.00
Conditionals coverage 100.00

Project geektrust_water_management test classes coverage
Files: 12 Packages: 1 Classes: 12 LOC: 1215 NCLOC: 966
Methods coverage 100.00
Elements coverage 98.95
Statements coverage 99.01
Conditionals coverage 50.00


Deprecated Gradle features were used in this build, making it incompatible with Gradle 8.0.

You can use '--warning-mode all' to show the individual deprecation warnings and determine if they come from your own scripts or plugins.

See https://docs.gradle.org/7.4/userguide/command_line_interface.html#sec:command_line_warnings

BUILD SUCCESSFUL in 1m 5s

