<?php include "../config/database.php" ?>
<?php include "User.php" ?>
<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org" xmlns:sec="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title th:text="|VD & VD|"></title>
    <link rel="stylesheet" href="../../static/style.css" type="text/css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <?php session_start(); ?>
</head>
<body>
<nav class="navbar navbar-expand-lg nav-bg mb-2 me-2">
    <div class="container-fluid">
        <!--    <button onclick = "window.location.href='www.linktothepage.com';"-->
        <button id="mainpage" type="button" onclick="window.location.href='/src/main/resources/templates/php/index.php'">VD & VD</button>
        <button type="button" onclick="window.location.href='/posts'">Posts</button>
        <button class="ms-2" type="button" onclick="window.location.href='/ideas'">Ideas</button>

        <?php

        if(!isset($_SESSION['username'])){
            echo '<li sec:authorize="!isAuthenticated()" class="nav-item ms-auto">
            <a class="nav-link" href="/src/main/resources/templates/php/register.php">Register</a>
        </li>
        <li sec:authorize="!isAuthenticated()" class="nav-item">
            <a class="nav-link" href="/src/main/resources/templates/php/login.php">Login</a>
        </li>';}
        ?>
        <?php
        if (isset($_SESSION['username'])) {
            echo '<form class="ms-auto d-flex" action="/src/main/resources/templates/php/logout.php" th:method="POST">
            <button class="btn footer-bg" type="submit" id="logout">Logout</button>
        </form>';
        }

        ?>

        <!--    <a class="navbar-brand logo-font" href="/">Bloglandia</a>-->
        <!--    <a class="navbar-brand logo-font" href="/roll-dice">Roll Dice</a>-->
        <!--    <a class="navbar-brand logo-font" href="/posts">All Posts</a>-->
    </div>

</nav>