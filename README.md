# Setting Up Kafka on Ubuntu

### Step 1: Install Java
```sh
$ sudo apt-get update && apt-get upgrade 
$ sudo apt-get install default-jdk
```
### Step 2: Setup Kafka

  - Download [Kafka](https://kafka.apache.org/downloads.html) 
  - Run tar –xvf <KAFKA>.tar.gz
  - Add kafka to .bashrc
   -- Go to /home/<USER>
   -- nano .bashrc and add following at the end of the file
      export PATH=/home/<USER>/tools/<KAFKA>/bin:$PATH
   - Create zookeeper data directory as shown below
   --  mkdir data/zookeeper inside <KAFKA> 
  - Edit zookeeper.properties 
  -- Nano <KAFKA>/config/zookeeper.properties
  -- dataDir=/home/<USER>/tools/<KAFKA>/data/zookeeper
  - Start Zookeeper
  -- ``` zookeeper-server-start.sh config/zookeeper.properties```
  - Create kafka data directory as shown below
   --  mkdir data/kafka inside <KAFKA> 
  - Edit server.properties 
  -- Nano <KAFKA>/config/server.properties
  -- Log.dirs=/home/<USER>/tools/<KAFKA>/data/kafka
  - Start Kafka
  -- ``` kafka-server-start.sh config/server.properties```

### Step 3: Create Topic
```kafka-topics.sh --topic first_topic --create --partitions 3 --replication-factor 1 --bootstrap-server localhost:9092```

# Start Spring Boot
Spring boot application runs on port 9000 by default. It has one producer and one consumer. Import the maven project into an IDE and execute 

#### Create a message
curl -X POST -F 'message=test' http://localhost:9000/publish and check the logs
