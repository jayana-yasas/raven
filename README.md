# raven

Sms-service is a micro service which capable of interacting with SMS APIs.
Storage-service is micro service which poll data from database and handle the business logic.
These two modules connects to each other through RabbitMQ message broker.
Zipkin Server is used as a log tracer for all modules.
http://localhost:9411/
Grafana is used as a monitoring tool while it has mysql data source.  