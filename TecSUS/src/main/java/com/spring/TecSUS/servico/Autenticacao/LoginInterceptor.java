package com.spring.TecSUS.servico.Autenticacao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
// import org.springframework.web.servlet.ModelAndView;

import com.spring.TecSUS.servico.servicoCookie;

@Component
public class LoginInterceptor implements HandlerInterceptor {
   @Override
   public boolean preHandle
      (HttpServletRequest request, HttpServletResponse response, Object handler) 
      throws Exception {
      
      try{
         if(servicoCookie.getCookie(request, "usuarioId") != null){
            return true;
         }
      }
      catch(Exception erro) {}
      
      response.sendRedirect("/login");
      return false;
   }

}