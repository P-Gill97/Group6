# Group 6 Metrics Program

## Members
- Rafael Garcia-Perez
- Perry Gill
- Sam Low
- Brent Paterson
- Jovany Pena

# Software Requirements Specification
# 1 Introduction
### 1.1 Purpose
The basic purpose of this program is to take in java files, analyze them, and return back a set of metrics that can be compared with any other file analyzed in the same fashion. The program takes in a Github url and imports the files in the repository so multiple files can be analyzed.
### 1.2 Document Convention
Will be added later
### 1.3 Scope
The user can only use GitHub repo links and only java,C/C++ files can be processed. It will only the following Metrics: Lines, Words, Characters, Source Lines, and Comment Lines. 
### 1.4 References
-Jgit https://www.eclipse.org/jgit/

## 2 Overall Description:
### 2.1  Product Perspective
A Metrics program with a GUI interface that will allow you to download a repository from GitHub and view various metrics on all the total java and C files in the repository. 
### 2.2 Product Functions
Once the GUI is called it wil prompt user to select two options "Add repo" and "List repos". Add repo takes in a URL from Github and runs the actual Metric analysis. List repos gives you back a list of all the previous read repos with the totals for each metrics. 
### 2.3 User Characteristics
 The user should know basic computed skills like copy and paste. Some knowledge of github is also needed.
### 2.4 General Constraints
The user can only enter one URL at a time and the program will remove non Java and C files from the repo to be used in metrics. 
### 2.5 Assumptions and Dependencies
This project uses the maven framework to get the Jgit dependencies. The user will enter a valid url and select the appropriate options.  
## 3. Detailed Requirements
 
###      3.1 External Interface Requirements
####     3.1.1 User Interfaces

The GUI will launch and prompt the user to select two an option. Add new repo or look at old repos. If the user decides 
to add new repo then the URL will be added. If the user decided to look at list of repos metrics. If the list of repo metrics is selected then the user will be promted to select run metrics on a selected repo or delete repo. 
 
####   3.1.2 Hardware Interfaces
All hardware should have internet access and a screen to display the GUI.
####       3.1.3 Software Interfaces
The API module has a controller which can be called to communicate with the metrics module. The metrics uses a controller to send 
an arraylist to the UI. 
####    3.1.4 Communication Interfaces
The api module uses the HTTP protocol to get the repository git object. The GUI  communicates with the main Metrics program. 
### 3.2 Functional Requirements
* Functional Requirement 1: Prompt user for Add new repo
* Functional Requirement 2: Using API get repo files and remove undesired files. 
* Functional Requirement 3: Calculate metrics and add to a database file. 
### 3.3 Performance Requirements

### 3.4 Design Constraints 3.5 Attributes
_
### 3.6 Other Requirements