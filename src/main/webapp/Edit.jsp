<html>
<head></head>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<body>
	<form action="edit" method="post">
		id
		<input value="${detail.id}" name="id"  readonly="readonly" type=text><br>
		name
		<input value="${detail.name}" name="name" type=text> <br>
		image
		<input value="${detail.image}" type=text name="image"> <br>
			gia
		<input value="${detail.price}" name="price" type=text><br>
		title
		<textarea rows="" name="title">${detail.title }</textarea>
		<br>
		description
		<textarea rows="" name="description">${detail.description }</textarea>
		<div class="form-group">
			<br> <label>Category</label> <select name="category"
				class="form-select" aria-label="Default select example">
				<c:forEach items="${ ListC}" var="o">
					<option value="${o.cId}">${o.cName}</option>
				</c:forEach>
			</select>
		</div>
		<input type="submit" value="edit">
	</form>
</body>
</html>