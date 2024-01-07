# Michelin

## Architecture

```mermaid

flowchart LR
    subgraph Client
        browser["Browser"]
    end
    subgraph Server 
        backend["Backend server"]
        frontend["Frontend server"]
    end
    subgraph Cloud 
        s3
    end
    
    browser -- "Loads Angular SPA" --> frontend
    browser -- "Make API Calls" --> backend
    backend -- "generates upload/download URLs" --> s3
```

## Requirements

- Java 17 or later
- A Postgres Database

## Dev / Local

```mvn spring-boot:run```

## Build

```mvn package```

Generates a jar file at ```target/michelin-back-0.0.1-SNAPSHOT.jar```

## Environment variabvles

see ```src/main/resources/application.properties```
