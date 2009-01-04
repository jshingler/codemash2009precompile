

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />
        <title>BlogEntry List</title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLinkTo(dir:'')}">Home</a></span>
            <span class="menuButton"><g:link class="create" action="create">New BlogEntry</g:link></span>
        </div>
        <div class="body">
            <h1>BlogEntry List</h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <div class="list">
                <table>
                    <thead>
                        <tr>
                        
                   	        <g:sortableColumn property="id" title="Id" />
                        
                   	        <g:sortableColumn property="title" title="Title" />
                        
                   	        <g:sortableColumn property="body" title="Body" />
                        
                   	        <g:sortableColumn property="dateCreated" title="Date Created" />
                        
                   	        <g:sortableColumn property="lastUpdated" title="Last Updated" />
                        
                   	        <th>Blog</th>
                   	    
                        </tr>
                    </thead>
                    <tbody>
                    <g:each in="${blogEntryInstanceList}" status="i" var="blogEntryInstance">
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                        
                            <td><g:link action="show" id="${blogEntryInstance.id}">${fieldValue(bean:blogEntryInstance, field:'id')}</g:link></td>
                        
                            <td>${fieldValue(bean:blogEntryInstance, field:'title')}</td>
                        
                            <td>${fieldValue(bean:blogEntryInstance, field:'body')}</td>
                        
                            <td>${fieldValue(bean:blogEntryInstance, field:'dateCreated')}</td>
                        
                            <td>${fieldValue(bean:blogEntryInstance, field:'lastUpdated')}</td>
                        
                            <td>${fieldValue(bean:blogEntryInstance, field:'blog')}</td>
                        
                        </tr>
                    </g:each>
                    </tbody>
                </table>
            </div>
            <div class="paginateButtons">
                <g:paginate total="${BlogEntry.count()}" />
            </div>
        </div>
    </body>
</html>
