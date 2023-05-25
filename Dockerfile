FROM ubuntu:20.04

# Install common dependencies
RUN apt-get -y update && \
    DEBIAN_FRONTEND=noninteractive apt-get -y install sudo \
    apt-utils \
    build-essential \
    git \
    vim \
    openjdk-11-jdk openjdk-11-jre \
    maven

# Set up JQF
RUN git clone https://github.com/rohanpadhye/jqf && \
    cd jqf && \
    mvn package

# Copy source code
COPY examples /examples
