<?php include "header.php" ?>

<?php if(isset($_SESSION['username'])){
    echo "<h1> Hello " . $_SESSION['username'] . "</h1>";
} else {
    echo "Welcome guest";
//    header('Location: /src/main/resources/templates/php/login.php');
} ?>

<?php include "footer.php" ?>

