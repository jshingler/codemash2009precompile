<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />
        <title>BlogEntry List</title>
        <g:if test="${print==true}">
            <meta name="layout" content="print"/>
        </g:if>
    </head>
    <body>
        <g:each var="entry" in="${blogEntryInstanceList}">
            <div class="blogentry">
                <div class="blogRolodex"><g:blogDateRolodex date="${entry?.dateCreated}"/></div>
                <div class="blogtitle">
                    <g:link controller="blogEntry" action="show" params="[id: entry.id, blog: entry.blog.blogid]">${entry?.title}</g:link>
                </div>
                
                <g:if test="${print!=true}">
                    <div class="printIcons">
					    <g:link controller="blogEntry" action="edit" params="[id: entry.id, blog: entry.blog.blogid]">
                            <img src="<g:createLinkTo dir="images" file="edit.gif"/>" alt="Edit Blog Entry"/>
                        </g:link>
                        <g:link controller="blogEntry" action="show" params="[id: entry.id, blog: entry.blog.blogid, print: true]"><img src="<g:createLinkTo dir="images" file="print_button.png"/>" alt="Printer Friendly Version"/></g:link>
                    </div>
                </g:if>
                <div class="blogdate">Created at <g:niceDate date="${entry.dateCreated}"/></div>
                
                <div class="blogbody">${entry.body}</div>
            </div>
            <hr />
        </g:each>
        
    </body>
</html>