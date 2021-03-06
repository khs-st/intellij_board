<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.kb.www.vo.ArticleVO" %>
<%@ page import="com.kb.www.common.LoginManager" %>
<%
    ArticleVO vo2 = (ArticleVO) request.getAttribute("article");
    LoginManager lm = LoginManager.getInstance();
    String id = lm.getMemberId(session);
%>
<html>
<head>
    <meta charset="UTF-8">
    <title>글내용 보기</title>
    <style>
        h1, table {
            text-align: center;
            margin: auto;
            position: static;
        }

        table, tr, td {

            height: 30px;
            border: 1px solid black;

        }

        #table {
            text-align: center;
            margin: auto;
            width: 600px;
        }


    </style>
</head>
<body>
<div id="table">
    <table>
        <tr>
            <td>글 번호</td>
            <td>글 제목</td>
            <td>글 내용</td>
            <td>작성자</td>
            <td>작성 날짜</td>
            <td>수정 날짜</td>
        </tr>
        <tr>
            <td><%=vo2.getArticleNum()%>
            </td>
            <td>
                <%=vo2.getArticleTitle()%>
            </td>
            <td>
                <%=vo2.getArticleContent()%>
            </td>
            <td>
                <%=vo2.getId()%>
            </td>
            <td>
                <%=vo2.getWriteDate()%>
            </td>
            <td>
                <%=vo2.getUpdateDate()%>
            </td>
        </tr>
    </table>

    <button onclick="location.href='/list.do'">게시물 목록 보기</button>
    <br/>
    <br/>
    <%if (id != null && id.equals(vo2.getId())) {%>
    <button onclick="location.href='/update.do?num=<%=vo2.getArticleNum()%>'">글 수정</button>
    <br/>
    <br/>
    <button onclick="location.href='/delete.do?num=<%=vo2.getArticleNum()%>'">글 삭제</button>
    <br/>
    <%}%>
</div>
</body>
</html>
