# spring-autoconfiguration-example
An example of loading configuration objects using the `@EnableAutoConfiguration` annotation.

The example contains a simple Spring Boot rest service with several endpoints. At runtime, via auto-configuration, an endpoint that returns
a list of all endpoints in the application is automatically added.

## Running the Example
1. Start the example by running the following Gradle command:

        $ ./gradlew bootRun

2. Execute the following command to hit the endpoint added at runtime via auto-configuration:

        # curl -v http://localhost:8080/endpoints
    
    If successful you will see the following:
    
        *   Trying ::1...
        * TCP_NODELAY set
        * Connected to localhost (::1) port 8080 (#0)
        > GET /endpoints HTTP/1.1
        > Host: localhost:8080
        > User-Agent: curl/7.54.0
        > Accept: */*
        >
        < HTTP/1.1 200
        < Content-Type: application/json;charset=UTF-8
        < Transfer-Encoding: chunked
        < Date: Thu, 24 May 2018 03:39:18 GMT
        <
        * Connection #0 to host localhost left intact
        ["/bar1","/bar","/bar2"]

3. Notice that only the `bar` endpoints have been returned due to the `FooController` being annotated with `@ExcludeEndpointListing`.

## Bugs and Feedback
For bugs, questions, and discussions please use the [Github Issues](https://github.com/gregwhitaker/spring-autoconfiguration-example/issues).

## License
MIT License

Copyright (c) 2018 Greg Whitaker

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.