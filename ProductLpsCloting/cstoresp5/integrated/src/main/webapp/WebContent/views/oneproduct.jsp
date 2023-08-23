<%@ include file="header.jsp" %>

      <div class="jumbotron">
        <div class="container">
          <h1 class="display-3">${pro.getName()}</h1>
        </div>
      </div>
      
      <div class="container">
        <div class="row">
        
	        <div class="col-md-3">
			<div class="box_slide">
				<div class="box_image">
				<img src="${pro.getImg()}" class="gall-img-responsive">
				</div>
			</div>
			</div>	
			<div class="col-md-6">
			
	        <b>${pro.getName()}</b><br />
	        <b>Price:</b> ${pro.getPrice()}<br />
	        <!--B-alter-pdata-->

<!--Code injected by: Rating-AlterOneProduct2-->
<b>Rate:</b> ${pro.getRate()}<br />
<!--Code injected by: Rating-AlterOneProduct2-->


			<br />${pro.getDescription()}<br />
			<!--B-alter-pdata2-->

<!--Code injected by: Cart-AlterOneProduct-->
<br />
	        <b>Add product to cart:</b><br />
	        <form action="./Cart" method="POST">
	        <input type="hidden" name="id" value="${id}" />
	        Quantity:<br /> <input type="text" size="1" name="qty" value="1" /> <input type="submit" value="Add to Cart" />
			</form>
<!--Code injected by: Cart-AlterOneProduct-->


<!--Code injected by: SharingSystem-AlterOneProduct-->
<c:set var="req" value="${pageContext.request}" />
			<c:set var="baseURL" value="${fn:replace(req.requestURL, req.requestURI, '')}" />
			<c:set var="params" value="${requestScope['javax.servlet.forward.query_string']}"/>
			<c:set var="requestPath" value="${requestScope['javax.servlet.forward.request_uri']}"/>
			<c:set var="pageUrl" value="${ baseURL }${ requestPath }${ not empty params?'?'+=params:'' }"/>
	        <br />
	        <b>Share this product:</b><br />
	        <a href="https://www.facebook.com/sharer/sharer.php?u=<c:url value='${pageUrl}' />">
	        <img src="<c:url value='assets/img/fb.png' />">
	        </a>
	        
	        <a href="https://twitter.com/home?status=<c:url value='${pageUrl}' />">
	        <img src="<c:url value='assets/img/twitter.png' />">
	        </a>
	        <br />
<!--Code injected by: SharingSystem-AlterOneProduct-->


<!--Code injected by: Rating-AlterOneProduct-->
<br />
	        <b>Rate this product:</b><br />
	        <form action="./Products" method="POST">
	        <fieldset class="rating">
			    <input type="radio" id="star5" name="rating" value="5" /><label class = "full" for="star5" title="Awesome - 5 stars"></label>
			    <input type="radio" id="star4" name="rating" value="4" /><label class = "full" for="star4" title="Pretty good - 4 stars"></label>
			    <input type="radio" id="star3" name="rating" value="3" /><label class = "full" for="star3" title="Meh - 3 stars"></label>
			    <input type="radio" id="star2" name="rating" value="2" /><label class = "full" for="star2" title="Kinda bad - 2 stars"></label>
			    <input type="radio" id="star1" name="rating" value="1" /><label class = "full" for="star1" title="Sucks big time - 1 star"></label>
			</fieldset><br /><br />
			<input type="hidden" name="id" value="${id}" />
			<input type="submit" value="Rate" />
			</form>
<!--Code injected by: Rating-AlterOneProduct-->


<!--Code injected by: Comments-AlterOneProduct-->
</div>
			<div class="col-md-3">
	        <b>Comment product:</b><br />
	        <form action="./AddComment" method="POST">
	        Description:<br /> <textarea name="description"></textarea><br /><br />
			<input type="hidden" name="product" value="${id}" />
			<input type="submit" value="Comment" />
			</form>
			
			<table class="table table-bordered">
			<c:forEach items="${comments}" var="com">
			<tr>
			<td>${com.getDescription()}</td>
			<td>${com.getDate()}</td>
			</tr>			
			</c:forEach>
			</table>
			</div>
<!--Code injected by: Comments-AlterOneProduct-->

	        </div>
	    </div>
	   </div>

<%@ include file="footer.jsp" %>