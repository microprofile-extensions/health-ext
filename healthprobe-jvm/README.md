[Back to health-ext](https://github.com/microprofile-extensions/health-ext/blob/main/README.md)

# JVM probes

[![Maven Central](https://maven-badges.herokuapp.com/maven-central/org.microprofile-ext.health-ext/healthprobe-jvm/badge.svg)](https://maven-badges.herokuapp.com/maven-central/org.microprofile-ext.health-ext/healthprobe-jvm)
[![Javadocs](https://www.javadoc.io/badge/org.microprofile-ext.health-ext/healthprobe-jvm.svg)](https://www.javadoc.io/doc/org.microprofile-ext.health-ext/healthprobe-jvm)

## Adding JVM Probes

In ```pom.xml```:
    
```xml

    <dependency>
        <groupId>org.microprofile-ext.health-ext</groupId>
        <artifactId>healthprobe-jvm</artifactId>
        <version>XXXXX</version>
        <scope>runtime</scope>
    </dependency>

```

## Configuration options

* health.jvm.heapmemory.maxpercentage = 0.9 (default)
* health.jvm.memory.maxpercentage = 0.9 (default)
* health.jvm.threadcount.max (default disabled)

## Example output

![](https://raw.githubusercontent.com/microprofile-extensions/health-ext/main/healthprobe-jvm/screenshot.png)
![](https://raw.githubusercontent.com/microprofile-extensions/health-ext/main/healthprobe-jvm/screenshot_1.png)
![](https://raw.githubusercontent.com/microprofile-extensions/health-ext/main/healthprobe-jvm/screenshot_2.png)
