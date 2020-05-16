# COMP3100-Project
 
## Installation

To use this files with the compiled ds-server simulator, make sure the ds-sim folder containing the ds-server file is in the same directory as the comp3100 folder containing the java project, as system.xml can is accessed as such.

## Running the Client

In a linux terminal, navigate to the folder in which **ds-server** is located and run the command **./ds-server -c <config_file.xml> -v all** where <config_file.xml> is the path of a valid server configuration file. Next in a different linux terminal navigate to the folder containing **Client.class** and run this file. It should be located in under the directory **comp3100/bin/Client.class**. To runs this file, use the command **java Client <arguments>**. The arguments are detailed next.

## Command Line Arguments

This program accepts two argument types. **java Client -a <algorithm>** will run the program using the specified algorithm. The options for this are **ff**, **bf** and **wf**. These stand for first fit, best fit and worst fit respectivly, and will run that scheduling algorithm when used as a parameter. Alternativly, no algorithm or argument can be specified and the client will run the allToLargest scheduling algorithm. The command **java Client -h** will print a help command if help is required.

## Job Scheduling Functions

* All To Largest (atl) - Schedules all jobs to the largest server
* First Fit (ff) - Schedules jobs to the first available server with sufficient resources
* Best Fit (bf) - Schedules jobs to the best fit server with available resources
* Worst Fit (wf) - Schedules jobs to the worst fit server with available resources

