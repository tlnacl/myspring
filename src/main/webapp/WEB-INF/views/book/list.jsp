<c:import url="/WEB-INF/views/common/layout.jsp" charEncoding="UTF-8">
    <c:param name="title" value="BOOK LIST" />
    <c:param name="body">
        <p>
            <a href='${pageContext.request.contextPath}/book/form/' class="btn btn-info">CREATE</a>
        </p>
        <table
            class="table table-striped table-bordered table-condensed">
            <tr>
                <th>ID</th>
                <th>TITLE</th>
                <th>AUTHOR</th>
                <th>&nbsp;</th>
            </tr>
            <c:forEach items="${page.content}" var="book">
                <tr>
                    <td>${f:h(book.id)}</td>
                    <td>${f:h(book.title)}</td>
                    <td>${f:h(book.author)}</td>
                    <td><a
                        href='${pageContext.request.contextPath}/book/edit/${book.id}'
                        class="btn btn-primary">Edit</a> <a
                        href='${pageContext.request.contextPath}/book/delete/${book.id}'
                        class="btn">Delete</a></td>
                </tr>
            </c:forEach>
        </table>

        <p>${f:h(page.number + 1)}/${f:h(page.totalPages)}</p>
        <div class="pagination">
            <ul>
                <li><c:if test="${!page.isFirstPage()}">
                        <a href='<c:url value="?page=0" />'>&laquo;
                            first</a>
                    </c:if></li>
                <li><c:if test="${page.hasPreviousPage()}">
                        <a
                            href='<c:url value="?page=${f:h(page.number - 1)}" />'>&lt;
                            prev</a>
                    </c:if></li>
                <li><c:if test="${page.hasNextPage()}">
                        <a
                            href='<c:url value="?page=${f:h(page.number + 1)}" />'>next
                            &gt;</a>
                    </c:if></li>
                <li><c:if test="${!page.isLastPage()}">
                        <a
                            href='<c:url value="?page=${f:h(page.totalPages - 1)}" />'>last
                            &raquo;</a>
                    </c:if></li>
            </ul>
        </div>
    </c:param>
</c:import>

