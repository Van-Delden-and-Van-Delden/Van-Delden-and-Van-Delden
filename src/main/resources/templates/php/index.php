<?php include "header.php" ?>
<form action="index.php" method="post">
    <label for="counter">Counter</label>
    <input type="number" name="counter">
    <label for="age">Age</label>
    <input type="number" name="age">
    <input type="submit">
</form>
<?php
$array = ["Test1", 25, "TEST2"];
echo "<h1> Hello Kara you sexy thing</h1>";
echo "<h1> The first array element is $array[0]";
echo "<h1> The second array element is $array[1]";
echo "<h1> The third array element is $array[2]";
echo "<br>";

function doSomething($counter){
    if (!empty($_POST['counter'])){
        if ($counter > 0) {
            echo "Counter = $counter <br>";
            $counter--;
            doSomething($counter);
        }
    } else{
        echo "<h1>Enter in the number of repeats</h1>";
    }
}

$counter = 0;
if (!empty($_POST['counter'])){
    $counter = $_POST["counter"];
}

doSomething($counter);
if (isset($_POST['age'])) {
    $age = $_POST['age'];
    echo "Age is $age <br>";
}
$x = 5;
do {
    echo "x = $x <br>";
    $x--;

} while ($x > 0);

$miss = "Mississippi";

for ($i = 0; $i < strlen($miss); $i++){
    echo "<br>" . substr($miss, $i, 1);
}
echo "<hr>";
$name = "Luke";
include "functions.php";
sayHello($name);
echo "<hr>";
newone();

$address = "Fake Address 123 st";
$city = "San Antonio";
$state = "Texas";

addressInfo($address, $city, $state);


include "footer.php";
?>
