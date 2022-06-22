## E-Commerce Application

## Github Rules - PLEASE READ
- Create your own branch to make your own changes to the current project
- make sure your project works BEFORE you commit your changes to YOUR branch
- When done with your task, test and ask others to test your changes BEFORE merging into testing branch
- After you merge YOUR branch into "testing" branch, make sure to test again to ensure the application is running okay
- After all tasks have been completed, tested, and merged in the testing branch and the project is running, <br/>
 ask lead to merge testing into main branch

### Application to buy Revature Swag. 

This application is a functional website written in Java and typescript. It will allow users to register and select from listed products for purchase, add them to the cart, and check out. If a user forgets their password they can have it reset. A guest or user can look at products and get a pop up view of the item, and its discription. The user or guest can see how many of a product are in stock. The user or guest can search items by key word.

Working application can be found here:
### `https://production.dcs2jw2334qwo.amplifyapp.com/`

## Install Instructions for developers
- Helpful Technology
  - JDK 
  - Spring
  - Docker
  - NODE
  - Maven

This application can be downloaded to your local machine by running the command
### `git clone https://github.com/revature-rss-adam-1300/e-commerce-backend.git`
-----------
Next, assure you have the front end code by running 
### `git clone https://github.com/revature-rss-adam-1300/e-commerce-frontend.git`

in another folder. It is important to keep the front and back ends in separate directory locations.


-----------
To prepare the enviornment, in the project back end directory, enter the command
### `mvn install`

Then, navagate into the `target` directory, and run the command:
### `mvn spring-boot:run`
which will run the Spring enviornment

The enviornment will be limited to the test data contained in this source code. 


----------
To run the front end, navigate to its directory and run the command:
### `npm install`
After that, running the command:
### `npm start` 
within the directory will open the application in your browser. 

----------
## Docker instructions
To download the image from docker, enter the command:
### `docker pull murryf/e-commerce`

in the directory of your choosing. Open with your Docker desktop and run as a containerized image.


## Happy coding!
