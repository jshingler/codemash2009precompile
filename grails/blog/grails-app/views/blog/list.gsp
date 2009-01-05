

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />
        <title>Blog List</title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLinkTo(dir:'')}">Home</a></span>
            <span class="menuButton"><g:link class="create" action="create">New Blog</g:link></span>
        </div>
        <div class="body">
            <h1>Blog List</h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <div class="list">
                <table>
                    <thead>
                        <tr>
                        
                   	        <g:sortableColumn property="id" title="Id" />
                        
                   	        <g:sortableColumn property="title" title="Title" />
                        
                   	        <g:sortableColumn property="byline" title="Byline" />
                        
                   	        <g:sortableColumn property="blogid" title="Blogid" />
                        
                   	        <g:sortableColumn property="dateCreated" title="Date Created" />
                        
                   	        <g:sortableColumn property="lastUpdated" title="Last Updated" />
                        
                        </tr>
                    </thead>
                    <tbody>
                    <g:each in="${blogInstanceList}" status="i" var="blogInstance">
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                        
                            <td><g:link action="show" id="${blogInstance.id}" params="[blog: blogInstance.blogid]" >${fieldValue(bean:blogInstance, field:'id')}</g:link></td>
                        
                            <td>${fieldValue(bean:blogInstance, field:'title')}</td>
                        
                            <td>${fieldValue(bean:blogInstance, field:'byline')}</td>
                        
                            <td>${fieldValue(bean:blogInstance, field:'blogid')}</td>
                        
                            <td>${fieldValue(bean:blogInstance, field:'dateCreated')}</td>
                        
                            <td>${fieldValue(bean:blogInstance, field:'lastUpdated')}</td>
                        
                        </tr>
                    </g:each>
                    </tbody>
                </table>
            </div>
            <div class="paginateButtons">
                <g:paginate total="${Blog.count()}" />
            </div>
        </div>
    </body>
</html>
