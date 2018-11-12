<html>
<body>
<h2>Hello World!</h2>
<%
    String fooParameter = request.getParameter( "foo" );
    if ( fooParameter == null )
    {
%>
    <p>No parameter foo given to this page.</p>
<%
    }
    else
    {
%>
    <p>The value of parameter foo is <%= fooParameter.toString() %>.</p>
<%
    }
%>
</body>
</html>
