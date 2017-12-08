# Maven-Tomcat-Mongo-intellij-Community-Edition

This is a simple Jersey RESTful service project. I Put this together for IntelliJ community Edition.
You can run Maven, tomcat, Jersey and mongo without having to pay for Intellij.

## Getting Started

These instructions will get you a copy of the project up and running on your local machine only.
### Prerequisites

What things you need to install the software and how to install them

```
Download Intellij community edition, Tomcat7, Maven, Mongod.
```

### Installing

Steps are simple

```
Download or clone this project.
```
### Configurate the project

Steps to follow on Intellij

To configure Tomcat

```
Click run
Click Edit Configurations...
Under Defaults select Maven
```

A new configuration for Maven needs to be created. Enter the following

```
Name: enter whatever
Working directory: Enter the location of your project (you could click the browse button and find your project)
Command Line: tomcat7:run
```

Create a New Maven Goal by clicking the plus (+) sign on the bottom.

```
Select Run Maven Goal
Enter "clean"
Click OK
```

## Running the Project

If everything is configured correctly you can run the project

```
Click the Run button
```

### Run app on web browser

Simply open your web browser and run it

```
Open web brower and copy paste
http://localhost:8888/
```

if it worked you should get "This is index holy crap it worked"

### Test Jersey RESTful service

Simply open your web browser and run it

```
Open web brower and copy paste
http://localhost:8888/rest/hello
```

if it worked you should get "Jersey say : Bitcoin is the shit. You should invest NOW!!!"


You can run the next jersey method for fun

```
Open web brower and copy paste
http://localhost:8888/rest/hello/bitcoin is king
```

if it worked you should get "Jersey say what the : bitcoin is kingt"


## Built With

* [Maven](https://maven.apache.org/) - Dependency Management

## Contributing

Youtube...

## Versioning

...

## Authors

...

## License

This project is Open Source

## Acknowledgments

...
