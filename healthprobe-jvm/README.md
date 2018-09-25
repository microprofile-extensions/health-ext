# Health Extensions | JVM probes

## Adding JVM Probes

In ```pom.xml```:
    
```xml

    <dependency>
        <groupId>org.microprofile-ext.health-ext</groupId>
        <artifactId>healthprobe-jvm</artifactId>
        <version>XXXXX</version>
    </dependency>

```

## Configuration options

* health.jvm.heapmemory.maxpercentage = 0.9 (default)
* health.jvm.memory.maxpercentage = 0.9 (default)
* health.jvm.threadcount.max (default disabled)

## Example output

![](https://raw.githubusercontent.com/microprofile-extensions/health-ext/master/healthprobe-jvm/screenshot.png)
![](https://raw.githubusercontent.com/microprofile-extensions/health-ext/master/healthprobe-jvm/screenshot_1.png)
![](https://raw.githubusercontent.com/microprofile-extensions/health-ext/master/healthprobe-jvm/screenshot_2.png)