<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<%@include file="common/header.jsp" %>

<div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
    <h1 class="h2">Sales History</h1>
    <div class="btn-toolbar mb-2 mb-md-0">
        <a href="${pageContext.request.contextPath}/sales-form" class="btn btn-primary">
            <i class="fas fa-cart-plus me-2"></i>New Sale
        </a>
    </div>
</div>

<div class="card shadow-sm">
    <div class="card-body">
        <div class="table-responsive">
            <table class="table table-striped table-hover align-middle">
                <thead class="table-dark">
                    <tr>
                        <th>Invoice No</th>
                        <th>Date</th>
                        <th>Customer Cell</th>
                        <th>Total Amount</th>
                        <th>Actions</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="sale" items="${salesList}">
                        <tr>
                            <td><strong>${sale.invoiceNo}</strong></td>
                            <td><fmt:formatDate value="${sale.salesDate}" pattern="dd-MMM-yyyy HH:mm" /></td>
                            <td>${sale.customerCell}</td>
                            <td>$${sale.totalAmount}</td>
                            <td>
                                <a href="${pageContext.request.contextPath}/sales-view?id=${sale.id}" class="btn btn-sm btn-outline-info">
                                    <i class="fas fa-eye me-1"></i> View
                                </a>
                            </td>
                        </tr>
                    </c:forEach>
                    <c:if test="${empty salesList}">
                        <tr>
                            <td colspan="5" class="text-center py-4">No sales records found.</td>
                        </tr>
                    </c:if>
                </tbody>
            </table>
        </div>
    </div>
</div>

<%@include file="common/footer.jsp" %>
