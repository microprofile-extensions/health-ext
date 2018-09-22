# Health Extensions | System probes

## Adding System probes

In ```pom.xml```
    
    ```xml
    <dependency>
        <groupId>org.microprofile-ext.health-ext</groupId>
        <artifactId>healthprobe-system</artifactId>
        <version>XXXXX</version>
    </dependency>
    ```

## Configuration options

* health.system.load.max = 0.7 (default)

Once the system load is greater than this value, the health probe will report down. Default value is 0.7 

## Example output

![](https://raw.githubusercontent.com/microprofile-extensions/health-ext/master/health-ui/screenshot.png)
