# Gilgamesh-Commerce-Bank-Project

## Set Up

### Programs
#### *You will need to have these programs installed on your computer in order to run the project*

- IntelliJ
- VSCode / Atom
- Postman - https://www.postman.com/
- Java JDK
  - check your system by typing `java --version` in the command line to check if you have one
- Node.JS https://nodejs.org/en/
  - check your system by typing `npm -v` in the command line to  heck if you have installed correctly
- Git - https://git-scm.com/downloads
  - allows you to push to github and access the project. Make sure to install GitBash as well.
  
 ### Installing the Project
 #### This will download the project to your local computer
 
 #### Command Line / GitBash
  1. Open the command line and navigate to the directory you would like to save your project
  2. On Github click on the green clone button and copy the link that pops up
  3. Inside of the command line type `git clone link` using the link that copied from Github
  4. This will create a local *clone* or copy of the project on your computer. This is important because cloning will allow you to push your changes back up for others to see

 ### VsCode GUI - A little easier
  1. In VsCode hold the keys `Crtl+Shift+G` to open the souce control menu
  2. Choose the button to Clone a Repository
  3. On Github click on the green clone button and copy the link that pops up
  4. Paste the link into the textbox and hit enter
  5. Choose the file location you want to store your project
  
 ### Running the Project
 #### Steps
  1. Run the backend server
  2. Run the front end
 
 #### Backend
  1. In intelliJ select File -> Open and find the *backend* folder inside of the project repo
  2. Click on the file build.gradle and choose to open it as a project.
  3. Intellij will then open the project
  4. Inside of the src -> main -> java folder there should be an app called `GilgameshCommerceProjectApplication`
  5. Open that file and give it a moment, and when it appears click on the second green play button on the left hand side
  6. Once that is running any of the api calls can be caught and handled through the back end server
 
 #### Frontend
  1. Open the project in VsCode
  2. Create a new terminal inside of VsCode
  3. For the first time running the front end type `npm install` *This is not needed after the first run*
  4. run command `npm start` to start the front end development server.
  5. In the browser navigate to localhost:3000
  6. If all works you should be able to make changes in VScode and they should appear on the localhost site.
