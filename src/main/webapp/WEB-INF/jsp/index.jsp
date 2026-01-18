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
            <h1>Podaj nazwę klienta</h1>
            <p align="center"><input type="search" value="Podaj nazwę klienta" ><a href="/search" class="btn">szukaj</a></p>
            </p>
        </div>
    </section>

    <section class="right-side">
        <div class="overlay-text">
            <span align="center">Visual Experience</span>
        </div>
    </section>
</main>

<nav class="navbar">
    <ul class="nav-links">
        <li><a href="/">Home</a></li>
        <li><a href="/panel">Admin Panel</a></li>
    </ul>
</nav>

</body>
</html>