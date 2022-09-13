Middleware Architecture
Lab 2 – Java RMI

- When uncommented the code section in divide function that has a long running loop and run the server and client again.
  So that use if condition to do it.

- When client is added, The count increment is a function that is implemented. Every client connect to the one server,although there are multiple servers are running.

- The created server is assured to the registry with a service name. The client links to the server by searching the service name in the registry.

- This shows that the server is a singleton. In order to make it per call or per client instantiation, in the constructor of the server, the new Instance keyword can be used.
