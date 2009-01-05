

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />
        <title>Edit Blog</title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLinkTo(dir:'')}">Home</a></span>
            <span class="menuButton"><g:link class="list" action="list">Blog List</g:link></span>
            <span class="menuButton"><g:link class="create" action="create">New Blog</g:link></span>
        </div>
        <div class="body">
            <h1>Edit Blog</h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${blogInstance}">
            <div class="errors">
                <g:renderErrors bean="${blogInstance}" as="list" />
            </div>
            </g:hasErrors>
            <g:form method="post" >
                <input type="hidden" name="id" value="${blogInstance?.id}" />
                <input type="hidden" name="blog" value="${blogInstance?.blogid}" />
                <div class="dialog">
                    <table>
                        <tbody>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="title">Title:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:blogInstance,field:'title','errors')}">
                                    <input type="text" maxlength="128" id="title" name="title" value="${fieldValue(bean:blogInstance,field:'title')}"/>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="byline">Byline:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:blogInstance,field:'byline','errors')}">
                                    <input type="text" maxlength="128" id="byline" name="byline" value="${fieldValue(bean:blogInstance,field:'byline')}"/>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="blogid">Blogid:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:blogInstance,field:'blogid','errors')}">
                                    <input type="text" id="blogid" name="blogid" value="${fieldValue(bean:blogInstance,field:'blogid')}"/>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="dateCreated">Date Created:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:blogInstance,field:'dateCreated','errors')}">
                                    <g:datePicker name="dateCreated" value="${blogInstance?.dateCreated}" ></g:datePicker>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="lastUpdated">Last Updated:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:blogInstance,field:'lastUpdated','errors')}">
                                    <g:datePicker name="lastUpdated" value="${blogInstance?.lastUpdated}" noSelection="['':'']"></g:datePicker>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="blogEntries">Blog Entries:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:blogInstance,field:'blogEntries','errors')}">
                                    
<ul>
<g:each var="b" in="${blogInstance?.blogEntries?}">
    <li><g:link controller="blogEntry" action="show" id="${b.id}">${b?.encodeAsHTML()}</g:link></li>
</g:each>
</ul>
<g:link controller="blogEntry" params="['blog.id':blogInstance?.id,blog:blogInstance.blogid]" action="create">Add BlogEntry</g:link>

                                </td>
                            </tr> 
                        
                        </tbody>
                    </table>
                </div>
                <div class="buttons">
                    <span class="button"><g:actionSubmit class="save" value="Update" /></span>
                    <span class="button"><g:actionSubmit class="delete" onclick="return confirm('Are you sure?');" value="Delete" /></span>
                </div>
            </g:form>
        </div>
    </body>
</html>
