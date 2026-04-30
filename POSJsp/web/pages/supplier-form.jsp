<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="common/header.jsp" %>

<div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
    <h1 class="h2">${supplier.id != 0 ? 'Edit' : 'Add'} Supplier</h1>
    <div class="btn-toolbar mb-2 mb-md-0">
        <a href="${pageContext.request.contextPath}/suppliers" class="btn btn-secondary">
            <i class="fas fa-arrow-left me-2"></i>Back to List
        </a>
    </div>
</div>

<div class="row justify-content-center">
    <div class="col-md-8">
        <div class="card shadow-sm">
            <div class="card-body">
                <form action="${pageContext.request.contextPath}/supplier-save" method="post">
                    <input type="hidden" name="id" value="${supplier.id}">
                    
                    <div class="row">
                        <div class="col-md-6 mb-3">
                            <label for="name" class="form-label">Supplier Name</label>
                            <input type="text" class="form-control" id="name" name="name" value="${supplier.name}" required>
                        </div>
                        <div class="col-md-6 mb-3">
                            <label for="cell" class="form-label">Phone/Cell</label>
                            <input type="text" class="form-control" id="cell" name="cell" value="${supplier.cell}" required>
                        </div>
                    </div>
                    
                    <div class="row">
                        <div class="col-md-6 mb-3">
                            <label for="contactPersonName" class="form-label">Contact Person Name</label>
                            <input type="text" class="form-control" id="contactPersonName" name="contactPersonName" value="${supplier.contactPersonName}">
                        </div>
                        <div class="col-md-6 mb-3">
                            <label for="contactPersonCell" class="form-label">Contact Person Cell</label>
                            <input type="text" class="form-control" id="contactPersonCell" name="contactPersonCell" value="${supplier.contactPersonCell}">
                        </div>
                    </div>
                    
                    <div class="mb-3">
                        <label for="address" class="form-label">Address</label>
                        <textarea class="form-control" id="address" name="address" rows="3">${supplier.address}</textarea>
                    </div>
                    
                    <div class="d-grid gap-2 d-md-flex justify-content-md-end mt-4">
                        <button type="submit" class="btn btn-primary px-5">
                            <i class="fas fa-save me-2"></i>Save Supplier
                        </button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>

<%@include file="common/footer.jsp" %>
