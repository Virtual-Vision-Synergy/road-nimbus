<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Road Nimbus - Tableau de bord</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background: #f5f5f5;
            margin: 0;
            padding: 0;
        }
        .header {
            background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
            color: white;
            padding: 20px;
            display: flex;
            justify-content: space-between;
            align-items: center;
        }
        .header h1 {
            margin: 0;
        }
        .user-info {
            display: flex;
            align-items: center;
            gap: 15px;
        }
        .logout-btn {
            background: rgba(255,255,255,0.2);
            color: white;
            border: none;
            padding: 8px 16px;
            border-radius: 5px;
            cursor: pointer;
            text-decoration: none;
        }
        .logout-btn:hover {
            background: rgba(255,255,255,0.3);
        }
        .container {
            max-width: 1200px;
            margin: 30px auto;
            padding: 0 20px;
        }
        .welcome-card {
            background: white;
            padding: 30px;
            border-radius: 10px;
            box-shadow: 0 2px 10px rgba(0,0,0,0.1);
            margin-bottom: 30px;
            text-align: center;
        }
        .success-message {
            background: #d4edda;
            color: #155724;
            padding: 15px;
            border-radius: 5px;
            margin-bottom: 20px;
            border: 1px solid #c3e6cb;
        }
        .dashboard-grid {
            display: grid;
            grid-template-columns: repeat(auto-fit, minmax(300px, 1fr));
            gap: 20px;
        }
        .dashboard-card {
            background: white;
            padding: 25px;
            border-radius: 10px;
            box-shadow: 0 2px 10px rgba(0,0,0,0.1);
        }
        .dashboard-card h3 {
            color: #333;
            margin-top: 0;
        }
        .dashboard-card .icon {
            font-size: 48px;
            margin-bottom: 15px;
        }
        .btn {
            background: #667eea;
            color: white;
            padding: 10px 20px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            text-decoration: none;
            display: inline-block;
        }
        .btn:hover {
            background: #5a67d8;
        }
    </style>
</head>
<body>
    <div class="header">
        <h1>🚧 Road Nimbus</h1>
        <div class="user-info">
            <span>Bienvenue, <c:out value="${user.email}" default="Utilisateur" /></span>
            <a href="/users/logout" class="logout-btn">Déconnexion</a>
        </div>
    </div>

    <div class="container">
        <c:if test="${not empty message}">
            <div class="success-message">${message}</div>
        </c:if>

        <div class="welcome-card">
            <h2>Tableau de bord - Signalements routiers</h2>
            <p>Gérez les signalements de travaux routiers et consultez les données cartographiques</p>
        </div>

        <div class="dashboard-grid">
            <div class="dashboard-card">
                <div class="icon">📍</div>
                <h3>Signalements</h3>
                <p>Créer et gérer les signalements de travaux routiers</p>
                <a href="/api/signalements" class="btn">Gérer les signalements</a>
            </div>

            <div class="dashboard-card">
                <div class="icon">🗺️</div>
                <h3>Cartographie</h3>
                <p>Visualiser les signalements sur la carte</p>
                <a href="/api/map" class="btn">Voir la carte</a>
            </div>

            <div class="dashboard-card">
                <div class="icon">👥</div>
                <h3>Utilisateurs</h3>
                <p>Gérer les utilisateurs et les autorisations</p>
                <a href="/api/auth/users" class="btn">Gérer les utilisateurs</a>
            </div>

            <div class="dashboard-card">
                <div class="icon">📊</div>
                <h3>API Documentation</h3>
                <p>Consulter la documentation de l'API</p>
                <a href="/swagger-ui/index.html" class="btn">Voir l'API</a>
            </div>
        </div>
    </div>
</body>
</html>