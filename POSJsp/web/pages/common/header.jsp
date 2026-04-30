<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>POS System</title>
        <!-- Bootstrap CSS -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
        <!-- Font Awesome -->
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css" rel="stylesheet">
        <style>
            body {
                background-color: #f8f9fa;
            }
            .sidebar {
                min-height: 100vh;
                background-color: #212529;
                color: white;
            }
            .sidebar a {
                color: #adb5bd;
                text-decoration: none;
                padding: 10px 20px;
                display: block;
            }
            .sidebar a:hover {
                background-color: #343a40;
                color: white;
            }
            .sidebar a.active {
                background-color: #0d6efd;
                color: white;
            }
            .main-content {
                padding: 20px;
            }
        </style>
    </head>
    <body>
        <div class="container-fluid">
            <div class="row">
                <!-- Sidebar -->
                <nav class="col-md-2 d-none d-md-block sidebar">
                    <div class="position-sticky pt-3">
                        <h4 class="px-3 mb-4 text-primary"><i class="fas fa-store me-2"></i>POS JSP</h4>
                        <ul class="nav flex-column">
                            <li class="nav-item">
                                <a href="${pageContext.request.contextPath}/index" class="nav-link">
                                    <i class="fas fa-home me-2"></i> Dashboard
                                </a>
                            </li>
                            <li class="nav-item">
                                <a href="${pageContext.request.contextPath}/products" class="nav-link">
                                    <i class="fas fa-box me-2"></i> Products
                                </a>
                            </li>
                            <li class="nav-item">
                                <a href="${pageContext.request.contextPath}/categories" class="nav-link">
                                    <i class="fas fa-tags me-2"></i> Categories
                                </a>
                            </li>
                            <li class="nav-item">
                                <a href="${pageContext.request.contextPath}/suppliers" class="nav-link">
                                    <i class="fas fa-truck me-2"></i> Suppliers
                                </a>
                            </li>
                            <li class="nav-item">
                                <a href="${pageContext.request.contextPath}/sales" class="nav-link">
                                    <i class="fas fa-shopping-cart me-2"></i> Sales
                                </a>
                            </li>
                        </ul>
                    </div>
                </nav>

                <!-- Main Content -->
                <main class="col-md-10 ms-sm-auto px-md-4 main-content">
