<%-- Sample comment --%>


<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <title>MyEPSI</title>
    <link rel="stylesheet" type="text/css" href="style.css">


</head>
<body>
<div class="container">

    <div>
        <button id="signin-button">Connexion</button>
        <button id="signup-button">Inscription</button>
    </div>

    <div>
        <form id="signup-form">
            <input type="text" placeholder="USERNAME" />
            <input type="email" placeholder="EMAIL" /> <input type="password" placeholder="PASSWORD" />
            <button type="button" class="submit-button">Sign up!</button>
        </form>
        <form id="signin-form">
            <input type="email" placeholder='USERNAME' />
            <input type="password" placeholder="PASSWORD" />
            <button type="button" class="submit-button">Sign In</button>
        </form>
    </div>
</div>

<script type="text/javascript" src="https://code.jquery.com/jquery.js"></script>
<script type="text/javascript" src="index.js"></script>
</body>

</html>