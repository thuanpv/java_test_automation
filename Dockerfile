FROM ubuntu:16.04

# Install common dependencies
RUN apt-get -y update && \
    apt-get -y install sudo \ 
    apt-utils \
    build-essential \
    git \
    vim \
    openjdk-8-jdk openjdk-8-jre \
    maven

# Set up JQF
RUN git clone https://github.com/rohanpadhye/jqf && \
    cd jqf && \
    mvn package

# Copy source code
COPY examples /examples
