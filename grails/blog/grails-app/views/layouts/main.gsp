<html>
    <head>
        <title><g:layoutTitle default="Blog Welcome"/></title>
        <link rel="stylesheet" href="${createLinkTo(dir: 'css', file: 'reset-fonts-grids.css')}"/>
        <link rel="stylesheet" href="${createLinkTo(dir: 'css', file: 'main.css')}"/>
        <link rel="shortcut icon" href="${createLinkTo(file: 'favicon.ico')}"/>

        <g:layoutHead/>
        <g:javascript library="application"/>

        <meta name="description" content="blog is a grails based blog engine"/>
        <meta name="keywords" content="groovy,grails,blogs"/>
        <meta name="robots" content="index,follow"/>

    </head>
    <body>
        <div id="doc3" class="yui-t5">
            <div id="hd">

                <div id="hdtitle"><a href="<g:createLinkTo dir="${params.blog}/"/>"><g:blogTitle blogid="${params.blog}"/></a></div>

                <div style="float: right; position: relative; margin-right: 7px; font-size: medium; ">
                    <g:form url='[controller: "blog", action: "search"]' id="searchableForm" name="searchableForm" method="get">
                        <g:textField name="query" value="${params.query}" size="25"/> <input type="submit" value="Search" />
                    </g:form>
                </div>

                <div id="hdsubtitle"><g:blogByline blogid="${params.blog}"/></div>

            </div>
            <div id="bd"><!-- start body -->

                <div id="yui-main">
                    <div class="yui-b">
                        <g:if test="${flash.message}">
                            <div class="flash">
                                ${flash.message}
                            </div>
                        </g:if>

                        <g:layoutBody/>
                    </div>
                </div>
                <div class="yui-b">

                    <g:render template="/sidebar"/>

                </div>


            </div>  <!-- end body -->
            <div id="ft">
                <div id="footerText">
                Blog <g:meta name="app.version"/> on Grails <g:meta name="app.grails.version"/> by <a href="http://BeginningGroovyAndGrails.com">BGG</a>.
                </div>
            </div>
        </div>

    </body>

</html>