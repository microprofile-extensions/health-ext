# Health Extensions

[![build_status](https://travis-ci.com/microprofile-extensions/health-ext.svg?branch=master)](https://travis-ci.com/microprofile-extensions/health-ext)
[![Maven Central](https://maven-badges.herokuapp.com/maven-central/org.microprofile-ext/health-ext/badge.svg)](https://maven-badges.herokuapp.com/maven-central/org.microprofile-ext/health-ext)
[![License](https://img.shields.io/badge/license-Apache%202-blue.svg)](https://github.com/microprofile-extensions/health-ext/blob/master/LICENSE)
[![Javadocs](https://www.javadoc.io/badge/org.microprofile-ext/health-ext.svg)](https://www.javadoc.io/doc/org.microprofile-ext/health-ext)

Here you will find some additional reuasable health probes and a basic ui

## Health Probes

### System

@TODO

### JVM

@TODO

## UI

Even though MicroProfile Health API is build for System to System use, it's still nice to look at the output of /health. 
This library gives you a small web gui on top of ```/health```

### Adding Health UI

In ```pom.xml```
    
    ```xml
    <dependency>
        <groupId>org.microprofile-ext.health-ext</groupId>
        <artifactId>health-ui</artifactId>
        <version>XXXXX</version>
    </dependency>
    ```

Then go to /<context_root>/health-ui, eg: http://localhost:7080/profiling/health-ui/

### Example screenshot

![](https://raw.githubusercontent.com/microprofile-extensions/health-ext/master/health-ui/screenshot.png)
