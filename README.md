# Benchmarking Algorithms

This repository contains implementation for sorting and graph-searching methods like:
* mergesort
* quicksort
* breadth-first search
* depth-first search

Algorithms are implemented in Java.  
To build application you will need:
* JDK 
* Gradle
* IDE or command line

## How to run
To run benchmark suite, please run following commands:
```
$ gradle clean jar
# In case of -XmxN - N is the amount of memory (6000m for 6 gigabytes of memory)
$ java -jar -XmxN -XX:-UseGCOverheadLimit build/libs/benchmarkingalgorithms-1.0.jar
```

## Gradle Tasks

* To build an application:
`$ gradle clean build`

* To run unit test:
`$ gradle clean test`

* To run sorting algorithms:
`$ gradle clean mainSort`

* To run searching algorithms:
`$ gradle clean mainSearch`

* To make jar-file:
`$ gradle clean jar`

