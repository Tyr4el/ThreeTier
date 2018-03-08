<!DOCTYPE html>
<!--
Name:
Course: CNT 4714 – Spring 2018 – Project Four
Assignment title: A Three-Tier Distributed Web-Based Application
Date: April 1, 2018
-->
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>CNT 4714 Remote Datbase Management System</title>
    <link rel="stylesheet" href="main.css">
</head>

<body>
    <h1>Welcome to the Project 4 Remote Database Management System</h1>
    <div class="divider"></div>
    <main>
        <p>You are connected to the Project4 database. <br> Please enter any valid SQL query or update statement. <br> If no query/update command is given, the Execute button will display all supplier information in the database. <br> All execution results will appear below. <br></p>

        <form action="/Project4/main" method="post">
            <textarea name="sqlStatement" id="sqlStatement" cols="30" rows="10"></textarea><br>
            <input type="submit" value="Execute Command" name="execute" class="submitButton">
            <input type="submit" value="Clear Form" name="clear" class="submitButton">
        </form>
        <br>
        <div class="divider"></div>
        <p>Database Results:</p>
        <form action="/Project4/main" method="get" id="outputForm">

        </form>
    </main>


</body>

</html>
