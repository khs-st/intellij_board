package com.kb.www.controller;

import com.kb.www.common.Action;
import com.kb.www.common.ActionForward;
import com.sun.org.apache.xerces.internal.impl.io.UTF8Reader;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.kb.www.atcion.ArticleListAction;

@WebServlet("/list")
public class HomeController extends HttpServlet {
    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //TODO Auto-generated method stub
        request.setCharacterEncoding("UTF-8");
        ActionForward forward = null;
        Action action = new ArticleListAction();
        //이벤트 처리 콘트롤러
        try {
            forward = action.execute(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (forward != null) {
            if (forward.isRedirect()) {
                response.sendRedirect(forward.getPath());
            } else {
                RequestDispatcher dispatcher = request.getRequestDispatcher(forward.getPath());
                dispatcher.forward(request, response);
            }
        }
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doProcess(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doProcess(request, response);
    }
}