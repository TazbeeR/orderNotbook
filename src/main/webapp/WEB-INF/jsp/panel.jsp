<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html lang="pl">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Landing Page - Dolny Navbar</title>
    <link rel="stylesheet" href="<c:url value='/css/style.css' />">
    <link href="https://fonts.googleapis.com/css2?family=Inter:wght@400;600;700&display=swap" rel="stylesheet">
</head>
<body>

<main class="container">
    <section class="left-side">
        <div class="content">
            <p>
            <h1 align="center">Dodaj/Usuń Item</h1>
            <ul>
                <center>
                    <li><a href="/hogcasing/list" class="btn">Wieprzowe</a></li>
                </center>
                <center>
                    <li><a href="/sheepcasing/list" class="btn">Baranie</a></li>
                </center>
                <center>
                    <li><a href="/spice/list" class="btn">Przyprawy</a></li>
                </center>
                <center>
                    <li><a href="/additive/list" class="btn">Dodatki</a></li>
                </center>
                <center>
                    <li><a href="/customer/list" class="btn">Klienci</a></li>
                </center>
            </ul>
            </p>

        </div>
    </section>

    <section class="right-side">
        <div class="overlay-text">
            <span>Visual Experience</span>
        </div>
    </section>
</main>

<nav class="navbar">
    <ul class="nav-links">
        <li><a href="/">Home</a></li>
        <li><a href="/panel"></a>Admin Panel</li>
    </ul>
</nav>

</body>
</html>