# dynatrace-jenkins-plugin
Jenkins plugin for publishing build events to dynatrace 

dynatrace-jenkins-plugin is a dedicated plugin which helps in publishing jenkins build events to Dynatrace events API. 

It internally makes use of multiple API's exposed by Dynatrace. 

The plugin is developed in Java and Maven which has a dedicated plugin for jenkins-plugin development. Different extensions are used to serve the purpose. 

Java 7 is used for development purpose.

When you pull the code and build the project you will have a .hpi file generated in target folder.

Open the jenkins running on the local environment and click on manage. Navigate to manage plugins section and click on Advanced tab. In here you can see an option to upload the plugin where you will upload the generated .hpi.

Restart the jenkins if asked and now the new plugin is installed. 

Create a job click on add build step and configure dynatrace and see the result. 

#######Cheers.
