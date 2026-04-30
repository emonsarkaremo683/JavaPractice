<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<%@include file="common/header.jsp" %>

<div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
    <h1 class="h2">Dashboard</h1>
</div>

<div class="row">
    <div class="col-md-3 mb-4">
        <div class="card bg-primary text-white shadow-sm border-0 h-100">
            <div class="card-body d-flex align-items-center">
                <div class="flex-grow-1">
                    <h6 class="text-uppercase mb-1">Total Products</h6>
                    <h2 class="mb-0">${totalProducts}</h2>
                </div>
                <div class="fs-1 opacity-50">
                    <i class="fas fa-box"></i>
                </div>
            </div>
            <div class="card-footer bg-transparent border-0 py-2">
                <a href="${pageContext.request.contextPath}/products" class="text-white text-decoration-none small">
                    View Details <i class="fas fa-arrow-right ms-1"></i>
                </a>
            </div>
        </div>
    </div>
    <div class="col-md-3 mb-4">
        <div class="card bg-success text-white shadow-sm border-0 h-100">
            <div class="card-body d-flex align-items-center">
                <div class="flex-grow-1">
                    <h6 class="text-uppercase mb-1">Total Revenue</h6>
                    <h2 class="mb-0">$<fmt:formatNumber value="${totalRevenue}" pattern="#,##0.00" /></h2>
                </div>
                <div class="fs-1 opacity-50">
                    <i class="fas fa-money-bill-wave"></i>
                </div>
            </div>
            <div class="card-footer bg-transparent border-0 py-2">
                <a href="${pageContext.request.contextPath}/sales" class="text-white text-decoration-none small">
                    View Details <i class="fas fa-arrow-right ms-1"></i>
                </a>
            </div>
        </div>
    </div>
    <div class="col-md-3 mb-4">
        <div class="card bg-warning text-dark shadow-sm border-0 h-100">
            <div class="card-body d-flex align-items-center">
                <div class="flex-grow-1">
                    <h6 class="text-uppercase mb-1">Total Sales</h6>
                    <h2 class="mb-0">${totalSales}</h2>
                </div>
                <div class="fs-1 opacity-50">
                    <i class="fas fa-shopping-cart"></i>
                </div>
            </div>
            <div class="card-footer bg-transparent border-0 py-2">
                <a href="${pageContext.request.contextPath}/sales" class="text-dark text-decoration-none small">
                    View Details <i class="fas fa-arrow-right ms-1"></i>
                </a>
            </div>
        </div>
    </div>
    <div class="col-md-3 mb-4">
        <div class="card bg-info text-white shadow-sm border-0 h-100">
            <div class="card-body d-flex align-items-center">
                <div class="flex-grow-1">
                    <h6 class="text-uppercase mb-1">Total Suppliers</h6>
                    <h2 class="mb-0">${totalSuppliers}</h2>
                </div>
                <div class="fs-1 opacity-50">
                    <i class="fas fa-truck"></i>
                </div>
            </div>
            <div class="card-footer bg-transparent border-0 py-2">
                <a href="${pageContext.request.contextPath}/suppliers" class="text-white text-decoration-none small">
                    View Details <i class="fas fa-arrow-right ms-1"></i>
                </a>
            </div>
        </div>
    </div>
</div>

<div class="row mt-4">
    <div class="col-md-8">
        <div class="card shadow-sm h-100">
            <div class="card-header bg-white">
                <h5 class="mb-0">Recent Sales</h5>
            </div>
            <div class="card-body p-0">
                <ul class="list-group list-group-flush">
                    <c:forEach var="sale" items="${recentSales}" end="4">
                        <li class="list-group-item py-3">
                            <div class="d-flex w-100 justify-content-between">
                                <h6 class="mb-1">Invoice: ${sale.invoiceNo}</h6>
                                <small class="text-muted"><fmt:formatDate value="${sale.salesDate}" pattern="dd-MMM HH:mm" /></small>
                            </div>
                            <p class="mb-1 text-muted small">Customer Cell: ${sale.customerCell} | Amount: $${sale.totalAmount}</p>
                        </li>
                    </c:forEach>
                    <c:if test="${empty recentSales}">
                        <li class="list-group-item py-4 text-center text-muted">No recent sales.</li>
                    </c:if>
                </ul>
            </div>
        </div>
    </div>
    <div class="col-md-4">
        <div class="card shadow-sm h-100">
            <div class="card-header bg-white">
                <h5 class="mb-0">Quick Actions</h5>
            </div>
            <div class="card-body">
                <div class="d-grid gap-2">
                    <a href="${pageContext.request.contextPath}/product-form" class="btn btn-outline-primary text-start py-3">
                        <i class="fas fa-plus-circle me-2"></i> Add New Product
                    </a>
                    <a href="${pageContext.request.contextPath}/sales-form" class="btn btn-outline-success text-start py-3">
                        <i class="fas fa-cart-plus me-2"></i> Create New Sale
                    </a>
                    <a href="${pageContext.request.contextPath}/category-form" class="btn btn-outline-info text-start py-3">
                        <i class="fas fa-folder-plus me-2"></i> Add New Category
                    </a>
                </div>
            </div>
        </div>
    </div>
</div>

<%@include file="common/footer.jsp" %>
