# Test Automation for Java Programs
Using [this very simple buggy program (just ~10 lines of code)](examples/Triangle.java), I show my students the limitations of manual testing and teach them how to apply test automation to improve the quality of programs written in Java. Specifically, I introduce to them the basic concepts in test automation including Fuzzing (my favourite topic :-)) and the tools/frameworks they can use such as JUnit, JUnit-QuickCheck, and JQF. 

# References
In addition to the great documentations on [JUnit-QuickCheck](https://github.com/pholser/junit-quickcheck) and [JQF](https://github.com/rohanpadhye/JQF) repositories, I find the following wiki/blog posts/articles helpful
- Docker overview: https://docs.docker.com/get-started/overview/
- Unit testing with JUnit: https://www.vogella.com/tutorials/JUnit/article.html
- An introduction to property-based testing using JUnit-QuickCheck: https://www.ontestautomation.com/an-introduction-to-property-based-testing-with-junit-quickcheck/

# Install Docker
Please follow [this instruction](https://docs.docker.com/get-docker/) to install Docker on your machine.

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
