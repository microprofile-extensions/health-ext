# Health Extensions | UI

[![Maven Central](https://maven-badges.herokuapp.com/maven-central/org.microprofile-ext.health-ext/health-ui/badge.svg)](https://maven-badges.herokuapp.com/maven-central/org.microprofile-ext.health-ext/health-ui)
[![Javadocs](https://www.javadoc.io/badge/org.microprofile-ext.health-ext/health-ui.svg)](https://www.javadoc.io/doc/org.microprofile-ext.health-ext/health-ui)

Even though MicroProfile Health API is build for System to System use, it's still nice to look at the output of /health. 
This library gives you a small web gui on top of ```/health```

## Adding Health UI

In ```pom.xml```
    
```xml

    <dependency>
        <groupId>org.microprofile-ext.health-ext</groupId>
        <artifactId>health-ui</artifactId>
        <version>XXXXX</version>
        <scope>runtime</scope>
    </dependency>

```

Then go to /<context_root>/health-ui, eg: http://localhost:8080/health-example/health-ui/

## Example screenshot

### Dashboard

![](https://raw.githubusercontent.com/microprofile-extensions/health-ext/master/health-ui/screenshot.png)

### Settings (to refresh automatically etc.)

![](https://raw.githubusercontent.com/microprofile-extensions/health-ext/master/health-ui/screenshot_settings.png)