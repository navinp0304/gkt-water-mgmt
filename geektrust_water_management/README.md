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
