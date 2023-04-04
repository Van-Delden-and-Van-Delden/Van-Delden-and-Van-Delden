<?php include "header.php" ?>
<form action="<?php echo htmlspecialchars($_SERVER['PHP_SELF']); ?>" method="post">
    <div>
        <label for="username">Username: </label>
        <input type="text" name="username">
    </div>
    <div>
        <label for="password">Password: </label>
        <input type="password" name="password">
    </div>
    <input type="submit" value="Submit" name="submit">
</form>

<?php if(isset($_POST['submit'])) {
    $username = filter_input(INPUT_POST, 'username', FILTER_SANITIZE_SPECIAL_CHARS);

    $password = $_POST['password'];

    if ($username == 'l' && $password == 'l') {
        $_SESSION['username'] = $username;
        header('Location: /src/main/resources/templates/php/profile.php');
    } else {
        echo "<h3>Incorrect username / password combination</h3>";
    }

}


?>
<?php include "footer.php" ?>
