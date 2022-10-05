## Run Kafka on Window
Downnload Kafka from [here](https://kafka.apache.org/quickstart) and unzip it to a folder, for example `kafka` folder.


cd to the directory. `C:\kafka>`

### Start Zookeeper
```bash
.\bin\windows\zookeeper-server-start.bat .\config\zookeeper.properties
```

### Start Kafka
```bash
.\bin\windows\kafka-server-start.bat .\config\server.properties
```

### Create a topic (`topiccccccccccccccccccc1`)
```bash
.\bin\windows\kafka-topics.bat --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic topiccccccccccccccccccc1
```
### List all topics
```bash
.\bin\windows\kafka-topics.bat --list --zookeeper localhost:2181
```

### Start a producer
```bash
.\bin\windows\kafka-console-producer.bat --broker-list localhost:9092 --topic topiccccccccccccccccccc1
```
then you can type some messages and press enter to send them.

### Start a consumer
```bash
.\bin\windows\kafka-console-consumer.bat --bootstrap-server localhost:9092 --topic topiccccccccccccccccccc1 --from-beginning
```
then you can see the messages you typed in the producer.
