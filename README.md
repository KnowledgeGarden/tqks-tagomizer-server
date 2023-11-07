# tqks-tagomizer-server
Server for pivot browsing annotations. A PivotBrowser will talk to this server.

## Port
7070 as defined in config/javalin-server-props.xml

## Installation
- Install https://github.com/KnowledgeGarden/tqks-javalin-backside-core

- Install https://github.com/KnowledgeGarden/tqks-tagomizer-server

`mvn clean install`

- Must be installed on same location as tqks-hypothesis-client; otherwise, the postgresql-props.xml must be modified.

## Running
`./start.sh`


