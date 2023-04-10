<?php
const DB_HOST = 'localhost';
const DB_USER = 'root';
const DB_PASS = 'codeup';
const DB_NAME = 'springblog_db';


$conn = new mysqli(DB_HOST, DB_USER, DB_PASS, DB_NAME);

if ($conn->connect_error) {
    die('Connection Failed ' . $conn->connect_error);
}

echo "Connected!";
?>
<!--NSERT INTO Customers SET ID=2, FirstName='User2'-->
