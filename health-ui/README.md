# Health Extensions | UI

Even though MicroProfile Health API is build for System to System use, it's still nice to look at the output of /health. 
This library gives you a small web gui on top of ```/health```

## Adding Health UI

In ```pom.xml```
    
```xml

    <dependency>
        <groupId>org.microprofile-ext.health-ext</groupId>
        <artifactId>health-ui</artifactId>
        <version>XXXXX</version>
    </dependency>

```

Then go to /<context_root>/health-ui, eg: http://localhost:7080/profiling/health-ui/

## Example screenshot

![](https://raw.githubusercontent.com/microprofile-extensions/health-ext/master/health-ui/screenshot.png)
