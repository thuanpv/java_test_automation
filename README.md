# Test Automation for Java Program
In this small project, I teach my students how to apply test automation to test programs written in Java. Specifically, I introduce to them the basic concepts in test automation including Fuzzing (my favourite topic :-)) and the tools/frameworks they can use such as JUnit, JUnit-QuickCheck, and JQF.

# Build a Docker image
First, you need to build a Docker image using the given Dockerfile. The Docker image has everything ready (e.g., Java JDK, JQF) for your experiments.

```bash
docker build . -t jta
```

# Run experiments inside a Docker container
Start a Docker container using the built image
```bash
docker run -it jta /bin/bash
```

Inside the Docker container, please follow the instructions below to test the example Triangle class.

First, go to examples folder
```bash
cd /examples
```

Then, compile the Triangle class and all test classes
```bash
javac -cp .:$(/jqf/scripts/classpath.sh) *.java
```

To test Triangle class manually, please run
```bash
java Triangle
```

To run JUnit test with the Triangle class
```bash
java -cp .:$(/jqf/scripts/classpath.sh) org.junit.runner.JUnitCore TriangleJUnitTest
```

To run JUnit-QuickCheck test
```bash
java -cp .:$(/jqf/scripts/classpath.sh) org.junit.runner.JUnitCore TriangleQCheckTest
```

To run fuzzing with JQF
```bash
/jqf/bin/jqf-zest -c .:$(/jqf/scripts/classpath.sh) TriangleJQFTest testInvalidTriangle
```

Enjoy Test Automation for Java!!!
