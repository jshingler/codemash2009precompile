

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />
        <title>Create BlogEntry</title>         
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLinkTo(dir:'')}">Home</a></span>
            <span class="menuButton"><g:link class="list" action="list">BlogEntry List</g:link></span>
        </div>
        <div class="body">
            <h1>Create BlogEntry</h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${blogEntryInstance}">
            <div class="errors">
                <g:renderErrors bean="${blogEntryInstance}" as="list" />
            </div>
            </g:hasErrors>
            <g:form action="save" method="post" >
                <div class="dialog">
                    <table>
                        <tbody>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="title">Title:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:blogEntryInstance,field:'title','errors')}">
                                    <input type="text" maxlength="128" id="title" name="title" value="${fieldValue(bean:blogEntryInstance,field:'title')}"/>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="body">Body:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:blogEntryInstance,field:'body','errors')}">
                                    <textarea rows="5" cols="40" name="body">${fieldValue(bean:blogEntryInstance, field:'body')}</textarea>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="dateCreated">Date Created:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:blogEntryInstance,field:'dateCreated','errors')}">
                                    <g:datePicker name="dateCreated" value="${blogEntryInstance?.dateCreated}" ></g:datePicker>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="lastUpdated">Last Updated:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:blogEntryInstance,field:'lastUpdated','errors')}">
                                    <g:datePicker name="lastUpdated" value="${blogEntryInstance?.lastUpdated}" noSelection="['':'']"></g:datePicker>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="blog">Blog:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:blogEntryInstance,field:'blog','errors')}">
                                    <g:select optionKey="id" from="${Blog.list()}" name="blog.id" value="${blogEntryInstance?.blog?.id}" ></g:select>
                                </td>
                            </tr> 
                        
                        </tbody>
                    </table>
                </div>
                <div class="buttons">
                    <span class="button"><input class="save" type="submit" value="Create" /></span>
                </div>
            </g:form>
        </div>
    </body>
</html>
