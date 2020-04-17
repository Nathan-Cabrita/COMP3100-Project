# COMP3100-Project
 
## Installation

To use this files with the compiled ds-server simulator, make sure ds-sim is in the same directory as the comp3100 folder containing the java project, as system.xml can is accessed as such.

## Running the Client

In a linux terminal, navigate to the folder in which **ds-server** is located and run the command **./ds-server -c <config_file.xml> -v all** where <config_file.xml> is the path of a valid server configuration file. Next in a different linux terminal navigate to the folder containing **Client.class** and run this file. It should be located in under the directory **comp3100/bin/Client.class**.

## Job Scheduling Functions

Currently the only available job scheduling function is allToLargest, which sends all jobs from the server to the largest server type.

