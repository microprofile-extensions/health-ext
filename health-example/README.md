[Back to health-ext](https://github.com/microprofile-extensions/health-ext/blob/master/README.md)

# Example Application

This is a very basic example application to demonstrate the Health extensions.

## Running the example.

Using maven, you can start this application using Payara or OpenLiberty:

```
    mvn -Ppayara clean install
```
or
```
    mvn -Popenliberty clean install
```

You can then go to http://localhost:8080/health-example/health-ui/ to see the UI and probes
