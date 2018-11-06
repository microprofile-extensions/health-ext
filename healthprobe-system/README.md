[Back to health-ext](https://github.com/microprofile-extensions/health-ext/blob/master/README.md)

# System probes

[![Maven Central](https://maven-badges.herokuapp.com/maven-central/org.microprofile-ext.health-ext/healthprobe-system/badge.svg)](https://maven-badges.herokuapp.com/maven-central/org.microprofile-ext.health-ext/healthprobe-system)
[![Javadocs](https://www.javadoc.io/badge/org.microprofile-ext.health-ext/healthprobe-system.svg)](https://www.javadoc.io/doc/org.microprofile-ext.health-ext/healthprobe-system)


## Adding System probes

In ```pom.xml```:
    
```xml

    <dependency>
        <groupId>org.microprofile-ext.health-ext</groupId>
        <artifactId>healthprobe-system</artifactId>
        <version>XXXXX</version>
        <scope>runtime</scope>
    </dependency>

```

## Configuration options

* health.system.load.max = 0.7 (default)

Once the system load is greater than this value, the health probe will report down. Default value is 0.7 

## Example output

![](https://raw.githubusercontent.com/microprofile-extensions/health-ext/master/healthprobe-system/screenshot.png)
