


	      		<ul>
	      		  <li><g:link controller='feed'>
                      <img src="${createLinkTo(dir:'images',file:'feed-icon-16x16.jpg')}" alt="RSS"/>RSS</g:link>
                  </li>
	      		  <li><a class="home" href="${createLinkTo(dir:'')}">Home</a></li>
	      		</ul>
	      		
	      		<jsec:isLoggedIn>

                      User Info
                      <p><g:userFullName/>  (<jsec:principal/>) </p>
                      <ul>
                      <li><a href="<g:createLink controller="blogEntry" action="userHomePage"/>">Homepage</a></li>
                      <li><a href="<g:createLink controller="blog" action="editByUser"/>">Edit Blog</a></li>
                      <li><a href="<g:createLink controller="blogEntry" action="create" />">New Blog Entry</a></li>                               
                      <li><a href="<g:createLink controller="auth" action="signOut" />">Logout</a></li>
                      </ul>
                </jsec:isLoggedIn>

                <jsec:isNotLoggedIn>
                           <g:if test="${flash.loginError}">
                                <div class="flash">${flash.loginError}</div>
                           </g:if>

                           <g:form controller="auth" action="signIn">
                                <table>
                                    <tr>
                                        <td><b>User Id:</b></td>
                                        <td><input type='text' name='username'/></td>
                                    </tr>
                                    <tr>
                                        <td><b>Password:</b></td>
                                        <td><input type="password" name='password'/></td>
                                    </tr>
                                    <tr>
                                        <td><b>Remember Me?:</b></td>
                                        <td><g:checkBox name="rememberMe" value="${rememberMe}" /></td>
                                    </tr>
                                </table>
                                <g:actionSubmit value="Login" action="signIn" />
                                <g:actionSubmit value="Register" action="register" />
                            </g:form>
                </jsec:isNotLoggedIn>
	      		
                <div style="padding-left: 80px;">
	      			<a href="http://www.grails.org/">
	      				<img src="${createLinkTo(dir:'images',file:'grails_button.gif')}" alt="Powered By Grails"/>
	      			</a>
	      		</div>



