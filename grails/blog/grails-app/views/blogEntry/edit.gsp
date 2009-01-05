<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta name="layout" content="main"/>
    <title>Edit BlogEntry</title>
    <style type="text/css">
        input  {
            font-size: x-large;
        }

        .buttons input {
            font-size: medium;
            margin-top: 5px;
        }

        .label {
            width: 5em;
            height: 2em;
        }
        
    </style>
    <g:javascript library="scriptaculous"/>
</head>
<body>
<div class="body">
<p style='font-size: large; border-bottom: 1px dotted black; padding-bottom: 4px;'>Edit Blog</p>
<g:form controller="blogEntry" action="save">
    <input type="hidden" name="id" value="${blogEntryInstance?.id}"/>
    <!--
    <input type="hidden" name="blogid" value="${blogid}"/>
    -->
    <table style="width: 100%;">
        <tbody>

            <tr>
                <td colspan="2">
                    <g:textField name='title' value="${blogEntryInstance.title}" style="width: 100%;"/>
                </td>
            </tr>

            <tr>
                <td colspan="2">
                    <textarea rows='20' cols='102' name='body' style="width: 100%; margin-top: 4px; margin-bottom: 4px;">${blogEntryInstance?.body}</textarea>
                </td>
            </tr>

            <tr>

                <td class="label">
                    Created:
                </td>
                <td>
                    <g:datePicker name='created' value="${blogEntryInstance?.dateCreated}"></g:datePicker>
                </td>
            </tr>
            
            <tr>
                <td class="label">
                    Blog:
                </td>
                <td>
                   <g:select optionKey="id" from="${Blog.list()}" name="blog.id" value="${blogEntryInstance?.blog?.id}" ></g:select>
                </td>
            </tr>

        </tbody>
    </table>
    </div>
    <div class="buttons" style="float: left; ">
        <g:submitToRemote url="[controller: 'blogEntry', action: 'preview']" update="entryPreview" value="Preview"/>
        <g:if test="${blogEntryInstance?.id}">
            <g:actionSubmit value="Update"/>
        </g:if>
        <g:else>
            <g:actionSubmit value="Save"/>
        </g:else>

    </div>
   
    
    
</g:form>
    
    <div class="buttons" style="float: right;top: -1em;">
        <g:form controller="blogEntry" action="delete">
            <input type="hidden" name="id" value="${blogEntryInstance?.id}"/>
            <g:submitButton name="delete" onclick="return confirm('Are you sure?');" value="Delete"/>
        </g:form>
    </div>
    <div id="entryPreview" style="margin-top: 3em;">
        
    </div>
    
</body>
</html>
