# JavaAggregatorLibrary
Java Aggregator Library for Topics in Software Engineering Course

###Contributors:
```
Rakesh Yarlagadda - https://github.com/ry2294

Sharan Suryanarayanan - https://github.com/s-sharan
```
This GitHub repository contains source code in "AggregatorLibrary" folder for our Java Aggregator Library. Also we have created a sample REST Java web service which uses our Aggregator Library for downstream service tasks execcution.


### AggregatorLibrary : Contains source code for Java Aggregator Library
You can find the jar file for the library at:
`https://github.com/ry2294/JavaAggregatorLibrary/blob/master/AggregatorLibrary/AggregatorLibrary.jar`

If you want to make changes to the library to suit your application more then you can clone the repository, make changes and create the jar file as follows:

1. If you are using an IDE like Eclipse then go to Project->Export->Java->JAR File.

2. You can create the jar file from command line by running the following command from the Aggregator Library Folder `jar cvf  AggregatorLibrary.jar *`

You can later import this jar file in your project and make use of the library.

You can find the documentation and tutorial in the `Documentation` folder.

### redditbot : Contains source code for sample REST Java Webservice

Sample REST application which makes use of the Aggregator Library and listens to the Reddit stream.


