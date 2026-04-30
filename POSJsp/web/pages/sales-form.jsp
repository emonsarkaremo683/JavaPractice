<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@include file="common/header.jsp" %>

<div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
    <h1 class="h2">New Sale</h1>
    <div class="btn-toolbar mb-2 mb-md-0">
        <a href="${pageContext.request.contextPath}/sales" class="btn btn-secondary">
            <i class="fas fa-arrow-left me-2"></i>Sales History
        </a>
    </div>
</div>

<div class="row">
    <div class="col-md-12">
        <div class="card shadow-sm mb-4">
            <div class="card-body">
                <form id="salesForm" action="${pageContext.request.contextPath}/sales-save" method="post">
                    <div class="row mb-4">
                        <div class="col-md-4">
                            <label class="form-label">Invoice No</label>
                            <input type="text" class="form-control" name="invoiceNo" value="INV-${System.currentTimeMillis()}" readonly>
                        </div>
                        <div class="col-md-4">
                            <label class="form-label">Customer Cell</label>
                            <input type="text" class="form-control" name="customerCell" placeholder="Enter customer cell" required>
                        </div>
                        <div class="col-md-4">
                            <label class="form-label">Date</label>
                            <input type="text" class="form-control" value="<%= new java.util.Date() %>" readonly disabled>
                        </div>
                    </div>

                    <div class="table-responsive">
                        <table class="table table-bordered" id="itemsTable">
                            <thead class="table-light">
                                <tr>
                                    <th style="width: 40%;">Product</th>
                                    <th>Price</th>
                                    <th style="width: 15%;">Quantity</th>
                                    <th>Total</th>
                                    <th>Action</th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr class="item-row">
                                    <td>
                                        <select class="form-select product-select" name="productId[]" required>
                                            <option value="">Select Product</option>
                                            <c:forEach var="p" items="${products}">
                                                <option value="${p.id}" data-price="${p.price}">${p.name} ($${p.price})</option>
                                            </c:forEach>
                                        </select>
                                    </td>
                                    <td>
                                        <input type="number" class="form-control price-input" name="price[]" readonly>
                                    </td>
                                    <td>
                                        <input type="number" class="form-control qty-input" name="quantity[]" min="1" value="1" required>
                                    </td>
                                    <td>
                                        <input type="number" class="form-control row-total" name="rowTotal[]" readonly>
                                    </td>
                                    <td>
                                        <button type="button" class="btn btn-outline-danger remove-row"><i class="fas fa-times"></i></button>
                                    </td>
                                </tr>
                            </tbody>
                        </table>
                    </div>

                    <div class="d-flex justify-content-between align-items-center mt-3">
                        <button type="button" class="btn btn-outline-primary" id="addRow">
                            <i class="fas fa-plus me-2"></i>Add Item
                        </button>
                        <div class="text-end">
                            <h4>Grand Total: $<span id="grandTotal">0.00</span></h4>
                            <input type="hidden" name="totalAmount" id="totalAmountInput">
                        </div>
                    </div>

                    <div class="d-grid gap-2 d-md-flex justify-content-md-end mt-4">
                        <button type="submit" class="btn btn-success btn-lg px-5">
                            <i class="fas fa-check-circle me-2"></i>Complete Sale
                        </button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>

<script>
    document.addEventListener('DOMContentLoaded', function() {
        const table = document.getElementById('itemsTable').getElementsByTagName('tbody')[0];
        const addRowBtn = document.getElementById('addRow');
        const grandTotalSpan = document.getElementById('grandTotal');
        const totalAmountInput = document.getElementById('totalAmountInput');

        function calculateTotals() {
            let grandTotal = 0;
            const rows = table.getElementsByClassName('item-row');
            
            for (let row of rows) {
                const price = parseFloat(row.querySelector('.price-input').value) || 0;
                const qty = parseFloat(row.querySelector('.qty-input').value) || 0;
                const total = price * qty;
                row.querySelector('.row-total').value = total.toFixed(2);
                grandTotal += total;
            }
            
            grandTotalSpan.innerText = grandTotal.toFixed(2);
            totalAmountInput.value = grandTotal.toFixed(2);
        }

        addRowBtn.addEventListener('click', function() {
            const firstRow = table.querySelector('.item-row');
            const newRow = firstRow.cloneNode(true);
            
            // Clear inputs
            newRow.querySelector('.product-select').value = '';
            newRow.querySelector('.price-input').value = '';
            newRow.querySelector('.qty-input').value = '1';
            newRow.querySelector('.row-total').value = '';
            
            table.appendChild(newRow);
            attachRowEvents(newRow);
        });

        function attachRowEvents(row) {
            const productSelect = row.querySelector('.product-select');
            const qtyInput = row.querySelector('.qty-input');
            const removeBtn = row.querySelector('.remove-row');

            productSelect.addEventListener('change', function() {
                const selectedOption = this.options[this.selectedIndex];
                const price = selectedOption.getAttribute('data-price');
                row.querySelector('.price-input').value = price || 0;
                calculateTotals();
            });

            qtyInput.addEventListener('input', calculateTotals);

            removeBtn.addEventListener('click', function() {
                if (table.getElementsByClassName('item-row').length > 1) {
                    row.remove();
                    calculateTotals();
                } else {
                    alert('At least one item is required.');
                }
            });
        }

        // Attach events to existing rows
        const initialRows = table.getElementsByClassName('item-row');
        for (let row of initialRows) {
            attachRowEvents(row);
        }
    });
</script>

<%@include file="common/footer.jsp" %>
