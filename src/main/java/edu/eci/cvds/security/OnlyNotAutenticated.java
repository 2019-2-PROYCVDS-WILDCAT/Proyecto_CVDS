/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cvds.security;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.AccessControlFilter;
import org.apache.shiro.web.util.WebUtils;

/**
 *
 * @author AlejandroB
 */
public class OnlyNotAutenticated extends AccessControlFilter {

    String welcomeurl = "";

    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) throws Exception {
        Subject subject = getSubject(request, response);
        return !subject.isAuthenticated(); // THE POINT

    }

    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {

        WebUtils.issueRedirect(request, response, getWelcome(request,response));
        return false;//What to do if try to go to login -> go welcome page of auth ursers
    }

    public String getWelcomeurl() {
        return welcomeurl;
    }

    public void setWelcomeurl(String welcomeurl) {
        this.welcomeurl = welcomeurl;
    }

    private String getWelcome(ServletRequest request, ServletResponse response) {
        Subject subject;
        subject = getSubject(request, response);

        if (subject.hasRole("comunidad")) {
            
            welcomeurl="/faces/secure/Comunidad.xhtml";
        } else if (subject.hasRole("administrador")) {
            welcomeurl="/faces/secure/Administrador.xhtml";
        }
        return welcomeurl;
    }
}
