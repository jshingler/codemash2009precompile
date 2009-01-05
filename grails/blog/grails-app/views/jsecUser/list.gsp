

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />
        <title>JsecUser List</title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLinkTo(dir:'')}">Home</a></span>
            <span class="menuButton"><g:link class="create" action="create">New JsecUser</g:link></span>
        </div>
        <div class="body">
            <h1>JsecUser List</h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <div class="list">
                <table>
                    <thead>
                        <tr>
                        
                   	        <g:sortableColumn property="id" title="Id" />
                        
                   	        <g:sortableColumn property="username" title="Username" />
                        
                   	        <g:sortableColumn property="fullName" title="Full Name" />
                        
                   	        <g:sortableColumn property="email" title="Email" />
                        
                        </tr>
                    </thead>
                    <tbody>
                    <g:each in="${jsecUserInstanceList}" status="i" var="jsecUserInstance">
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                        
                            <td><g:link action="show" id="${jsecUserInstance.id}">${fieldValue(bean:jsecUserInstance, field:'id')}</g:link></td>
                        
                            <td>${fieldValue(bean:jsecUserInstance, field:'username')}</td>
                        
                            <td>${fieldValue(bean:jsecUserInstance, field:'fullName')}</td>
                        
                            <td>${fieldValue(bean:jsecUserInstance, field:'email')}</td>
                        
                        </tr>
                    </g:each>
                    </tbody>
                </table>
            </div>
            <div class="paginateButtons">
                <g:paginate total="${JsecUser.count()}" />
            </div>
        </div>
    </body>
</html>
