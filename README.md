# JavaAggregatorLibrary
In the world of web services, it is commonplace for a web service to communicate with downstream services to process an API request from its clients. Web service developers try to decouple these actions into as many individual tasks as possible. However, some tasks end up as dependencies for other tasks to execute. Typically, web service developers execute these tasks in a sequential order one after the other. However, in this implementation, the throughput and latency of the web service will take a hit because each task is blocked on the previous task even though there is no dependency between them. 

On the other hand, another way of implementation is to execute independent tasks in parallel through creation of threads, and use their result to process the dependent tasks. In this implementation even though it improves the web service’s latency and throughput, the developers will have an overhead of thread creation and thread management. A better implementation for the above usecase is to decouple the tasks from their execution and hand it over to an executor library which takes care of running tasks while honoring their dependencies on other tasks, which is the aim of our library. We have build a task execution library in Java called AggregatorLibrary, which allows web service developers to exploit parallelism with minimal overhead of handling thread creation and thread management at the same time honoring task dependencies. Our Java Aggregator Library, takes a set of tasks with their dependencies as input, builds a dependency graph for these tasks and executes these tasks as concurrently as possible. In this README file we shall go though a sample tutorial on how clients can include and use our Java Aggregator Library.

###Contributors:
```
Rakesh Yarlagadda - https://github.com/ry2294

Sharan Suryanarayanan - https://github.com/s-sharan
```
This GitHub repository contains source code for our Java Aggregator Library in "AggregatorLibrary" folder. You can find the jar file for the library at: "AggregatorLibrary/AggregatorLibrary.jar". Also we have created a sample REST Java web service "redditbot" in redditbot folder which uses our Aggregator Library for parallelizing tasks execution.

# Importing AggregatorLibrary into Eclipse
Below are the steps to import our Java Aggregator Library into any Eclipse Java Web Project.
1. Download AggregatorLibrary.jar file from the following link : https://github.com/ry2294/JavaAggregatorLibrary/blob/master/AggregatorLibrary/AggregatorLibrary.jar

2. Open Eclipse and select your project to which you want to import our Aggregator Library.

3. Rigth click on your Project, and select Import. The Import window opens.

4. Under Select an import source, click JavaEE -> App Client JAR file.

5. Click Next.

6. In the Application Client File, Please click on Browse button to select the downloaded AggregatorLibrary.jar

7. Finally select Finish, which will add the JAR file to the Project and recompiles the workspace. Now, one can directly import our package com.aggregatorlibrary to use our Library.

# Tutorial
Let us take an example to illustrate on how to use our library. In the following figure, we can see four tasks A, B, C and D with their dependencies. Task A is independent and can execute first, whereas Tasks B and C depend on A since they use Task A’s output. Finally Task D is dependent on outputs of Tasks B and C and hence it has to execute last.

![dependency Graph](https://github.com/ry2294/JavaAggregatorLibrary/tree/master/images/dependencygraph.png)

We have created the following classes A, B, C and D representing the above classes respectively. Now to input these tasks to our AggregatorLibrary, clients must follow the following steps which are also illustrated in the following figure with a code example.
1. Import the package com.aggregatorlibrary by using the following statement.
`import com.aggregatorlibrary.*;`

2. Create an instance of the AggregatorService by invoking the newAggregatorService() method of the Aggregators Factory.

3. Input the tasks, in our case A, B, C and D, to the Aggregator by invoking the addTasks() method. This method takes variable arguments, hence there is no limit on the number of tasks added.

4. Finally, invoke the execute() method of the Aggregator to start the execution of the tasks.

![aggregator Service](https://github.com/ry2294/JavaAggregatorLibrary/tree/master/images/aggregatorservice.png)

### Dependency Identification and Injection
For developers to specify dependencies among tasks we have created @Dependency Annotation using Java Annotations. Developers need to insert this annotation in each task which has dependencies above their references to these dependencies. The following figure describes the usage of @Dependency in Task B which has a dependency on Task A.

<img src="https://raw.githubusercontent.com/ry2294/JavaAggregatorLibrary/master/images/dependencyinjection.png" />