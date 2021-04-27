Instructions for how to set up MYSQL database.

1. At the MySQL Workbench homepage click on the plus icon to add a MySQL connection
2. Name the connection anything you would like.  We have named ours, "finalProject"
3. Make sure the Hostname is "127.0.0.1" and the port is "3306"
4. Username should be set to root (no password is required).
5. Click the Test Connection button to ensure a connection can be made to the database.
6. After closing the Test Connection window, Click OK to create the connection.
7. When inside the connection workbench, click on the Schemas button, located next to the Administration button.
8. In the menu bar located underneath the "File, Edit, View etc" menu, you will see a button that looks like a 
   cylinder with a plus sign next to it.  Click that button to create a new schema.
9. Name that schema "wbdv-finalproject-sp21-tm-schema"
10. Click apply in the bottom right hand corner to apply the schema to the connection.

You have now successfully set up the database to receive a connection from our Java server.

To set up the java server:

1. run mvn clean install from the command line.
2. press the green "play" button either in the top of your IDE or located on the app file to start up the server.

Upon success of starting the server you should see the following two tables made in the DB:

1) users
2) matches
