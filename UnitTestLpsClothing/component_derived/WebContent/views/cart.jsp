<%@ include file="header.jsp" %>

      <div class="jumbotron">
        <div class="container">
          <h1 class="display-3">Cart</h1>
        </div>
      </div>

      <div class="container">
      
        <div class="row">
          <div class="col-md-12">
          <c:set var="total" value="0" />
          	<c:if test="${not empty products}">
 			<table class="tg">
				<tr>
				<th width="120">Name</th>
				<th width="120">Price</th>
				<th width="120">QTY</th>
				<th width="120">Subtotal</th>
				<th width="120">Remove</th>
				</tr>
				<c:forEach items="${products}" var="pro">
				<tr><td>${pro.getName()}</td>
				<td>${pro.getPrice()}</td>
				<c:set var="pid" value="${pro.getId()}" />
				<c:set var="subtotal" value="${pro.getPrice() * qty[pid]}" />
				<c:set var="total" value="${pro.getPrice() * qty[pid] + total}" />
				<td><c:out value="${qty[pid]}" /></td>
				<td><c:out value="${subtotal}" /></td>
				<td><a href="./Cart?remove=${pro.getId()}">Remove this product</a></td>
				</c:forEach>
				</table><br /><br />
				<b>Total:</b> <c:out value="${total}" /><br /><br />
				
				<a href="./Cart?clear=1">Clear Cart</a>

				<!--B-payment-zone-->

<!--Code injected by: OnlinePayment-AlterCart-->
<br /><br />
				<b>Pay with PayPal</b><br />
				<form action="https://www.paypal.com/cgi-bin/webscr" method="post" target="_top">
				<input type="hidden" name="cmd" value="_s-xclick">
				<input type="hidden" name="hosted_button_id" value="">
				<input type="image" src="https://www.paypalobjects.com/en_US/i/btn/btn_buynowCC_LG.gif" border="0" name="submit" alt="PayPal - The safer, easier way to pay online!">
				<img alt="" border="0" src="https://www.paypalobjects.com/en_US/i/scr/pixel.gif" width="1" height="1">
				</form>
<!--Code injected by: OnlinePayment-AlterCart-->


<!--Code injected by: OfflinePayment-AlterCart-->
<br /><br />
				<b>Offline payment</b><br />
				Click <a HREF="javascript:window.print()">here</a> to print this page. Then transfer the total value to this bank account: XXX-XX-XXX-XX and send us the previous printed page including the transaction confirmation.
<!--Code injected by: OfflinePayment-AlterCart-->

			</c:if>          
          </div>
        </div>
        
       </div>


<%@ include file="footer.jsp" %>