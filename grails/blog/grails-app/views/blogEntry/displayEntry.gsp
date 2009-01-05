<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main"/>
        <g:if test="${print==true}">
            <meta name="layout" content="print"/>
        </g:if>
    </head>
    <body>
        <g:each var="entry" in="${entries}">

            <div class="blogentry">
                <div class="blogRolodex"><g:blogDateRolodex date="${entry.dateCreated}"/></div>
                <div class="blogtitle"><a href="${baseUri + entry.toPermalink()}">${entry.title}</a></div>
                <g:if test="${print!=true}">
                    <div class="printIcons">
                        <g:link controller="blogEntry" action="edit" params="[id: entry.id, blog: entry.blog.blogid]">
                            <img src="<g:createLinkTo dir="images" file="edit.gif"/>" alt="Edit Blog Entry"/>
                        </g:link>
                        <a href="/blog${entry.toPermalink()}?print=true"><img src="<g:createLinkTo dir="images" file="print_button.png"/>" alt="Printer Friendly Version"/></a>
                    </div>
                </g:if>
                <div class="blogdate">By ${entry.blog.user.fullName} at <g:niceDate date="${entry.dateCreated}"/></div>
                <div class="blogbody">${entry.body}</div>
                <div class="blogtags"> </div>
            </div>
        </g:each>
    </body>
</html>