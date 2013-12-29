<c:import url="/WEB-INF/views/common/layout.jsp" charEncoding="UTF-8">
    <c:param name="title" value="BOOK FORM" />
    <c:param name="body">
        <spring:hasBindErrors name="book">
            <script type="text/javascript">
                $(document).ready(function() {
                    $("div.control-group>div.controls>.error").parent().parent().addClass("error");
                });
            </script>
        </spring:hasBindErrors>
        <form:form method="post" action="." modelAttribute="book"
            cssClass="form-horizontal">
            <fieldset>
                <legend>Book</legend>
                <div class="control-group">
                    <label class="control-label" for="title">title</label>
                    <div class="controls">
                        <form:input path="title" cssClass="span5"
                            cssErrorClass="error" />
                        <form:errors path="title"
                            cssClass="error help-inline inline"
                            element="span" />
                    </div>
                </div>
                <div class="control-group">
                    <label class="control-label" for="author">author</label>
                    <div class="controls">
                        <form:input path="author" cssClass="span3"
                            cssErrorClass="error" />
                        <form:errors path="author"
                            cssClass="error help-inline inline"
                            element="span" />
                    </div>
                </div>
                <form:hidden path="id" />
                <div class="form-actions">
                    <input type="submit" class="btn btn-primary"
                        value="Submit">&nbsp;
                    <button type="reset" class="btn">Cancel</button>
                </div>
            </fieldset>
        </form:form>
        <hr>
        <a href='${pageContext.request.contextPath}/book/list' class="btn">list</a>
    </c:param>
</c:import>

