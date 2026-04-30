<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@include file="common/header.jsp" %>

<div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
    <h1 class="h2">Suppliers</h1>
    <div class="btn-toolbar mb-2 mb-md-0">
        <a href="${pageContext.request.contextPath}/supplier-form" class="btn btn-primary">
            <i class="fas fa-plus me-2"></i>Add New Supplier
        </a>
    </div>
</div>

<div class="card shadow-sm">
    <div class="card-body">
        <div class="table-responsive">
            <table class="table table-striped table-hover align-middle">
                <thead class="table-dark">
                    <tr>
                        <th>ID</th>
                        <th>Name</th>
                        <th>Cell</th>
                        <th>Contact Person</th>
                        <th>Contact Cell</th>
                        <th>Address</th>
                        <th>Actions</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="supplier" items="${suppliers}">
                        <tr>
                            <td>${supplier.id}</td>
                            <td>${supplier.name}</td>
                            <td>${supplier.cell}</td>
                            <td>${supplier.contactPersonName}</td>
                            <td>${supplier.contactPersonCell}</td>
                            <td>${supplier.address}</td>
                            <td>
                                <a href="${pageContext.request.contextPath}/supplier-form?id=${supplier.id}" class="btn btn-sm btn-outline-primary">
                                    <i class="fas fa-edit"></i>
                                </a>
                                <a href="${pageContext.request.contextPath}/supplier-delete?id=${supplier.id}" class="btn btn-sm btn-outline-danger" onclick="return confirm('Are you sure you want to delete this supplier?')">
                                    <i class="fas fa-trash"></i>
                                </a>
                            </td>
                        </tr>
                    </c:forEach>
                    <c:if test="${empty suppliers}">
                        <tr>
                            <td colspan="7" class="text-center py-4">No suppliers found.</td>
                        </tr>
                    </c:if>
                </tbody>
            </table>
        </div>
    </div>
</div>

<%@include file="common/footer.jsp" %>
