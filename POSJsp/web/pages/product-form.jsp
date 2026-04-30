<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@include file="common/header.jsp" %>

<div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
    <h1 class="h2">${product.id != 0 ? 'Edit' : 'Add'} Product</h1>
    <div class="btn-toolbar mb-2 mb-md-0">
        <a href="${pageContext.request.contextPath}/products" class="btn btn-secondary">
            <i class="fas fa-arrow-left me-2"></i>Back to List
        </a>
    </div>
</div>

<div class="row justify-content-center">
    <div class="col-md-8">
        <div class="card shadow-sm">
            <div class="card-body">
                <form action="${pageContext.request.contextPath}/product-save" method="post">
                    <input type="hidden" name="id" value="${product.id}">
                    
                    <div class="mb-3">
                        <label for="name" class="form-label">Product Name</label>
                        <input type="text" class="form-control" id="name" name="name" value="${product.name}" required>
                    </div>
                    
                    <div class="row">
                        <div class="col-md-6 mb-3">
                            <label for="price" class="form-label">Price</label>
                            <div class="input-group">
                                <span class="input-group-text">$</span>
                                <input type="number" step="0.01" class="form-control" id="price" name="price" value="${product.price}" required>
                            </div>
                        </div>
                        <div class="col-md-6 mb-3">
                            <label for="quantity" class="form-label">Quantity</label>
                            <input type="number" step="0.01" class="form-control" id="quantity" name="quantity" value="${product.quantity}" required>
                        </div>
                    </div>
                    
                    <div class="row">
                        <div class="col-md-6 mb-3">
                            <label for="categoryId" class="form-label">Category</label>
                            <select class="form-select" id="categoryId" name="categoryId" required>
                                <option value="">Select Category</option>
                                <c:forEach var="category" items="${categories}">
                                    <option value="${category.id}" ${product.categoryId == category.id ? 'selected' : ''}>
                                        ${category.name}
                                    </option>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="col-md-6 mb-3">
                            <label for="supplierId" class="form-label">Supplier</label>
                            <select class="form-select" id="supplierId" name="supplierId" required>
                                <option value="">Select Supplier</option>
                                <c:forEach var="supplier" items="${suppliers}">
                                    <option value="${supplier.id}" ${product.supplierId == supplier.id ? 'selected' : ''}>
                                        ${supplier.name}
                                    </option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                    
                    <div class="d-grid gap-2 d-md-flex justify-content-md-end mt-4">
                        <button type="submit" class="btn btn-primary px-5">
                            <i class="fas fa-save me-2"></i>Save Product
                        </button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>

<%@include file="common/footer.jsp" %>
