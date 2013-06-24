## Sample Application for use with App Engine Java, Google Cloud Endpoints and AngularJS.

Requires [Apache Maven](http://maven.apache.org) 3.0 or greater, and JDK 6+ in order to run.

To build, run

    mvn package

To start the app, use the [App Engine Maven Plugin](http://code.google.com/p/appengine-maven-plugin/) that is already included in this demo.  Just run the command.

    mvn appengine:devserver


Javascripts dependencies are managed with BOWER. 
You have to do "a bower install" in the webapp folder to download all the necessary files. 
(For more informations about Bower : https://github.com/bower/bower )
