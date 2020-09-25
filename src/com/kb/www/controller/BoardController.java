package com.kb.www.controller;

import com.kb.www.atcion.*;
import com.kb.www.common.Action;
import com.kb.www.common.ActionForward;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("*.do")
public class BoardController extends HttpServlet {
    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //TODO Auto-generated method stub
        request.setCharacterEncoding("UTF-8");
        String RequestURI = request.getRequestURI();
        String contextPath = request.getContextPath();
        String command = RequestURI.substring(contextPath.length());
        ActionForward forward = null;
        Action action = null;
        //게시판 이벤트 처리 콘트롤러 모듈화
        if (command.equals("/list.do")) {
            action=new ArticleListAction();
            try {
                forward = action.execute(request, response);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else if(command.equals("/detail.do")){
            action=new ArticleDetailAction();
            try {
                forward = action.execute(request, response);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else if(command.equals("/register.do")){
            action=new ArticleRegisterAction();
            try {
                forward = action.execute(request, response);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else if(command.equals("/delete.do")){
            action=new ArticleDeleteAction();
            try {
                forward = action.execute(request, response);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else if(command.equals("/update.do")){
            action=new ArticleUpdateAction();
            try {
                forward = action.execute(request, response);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else if(command.equals("/updatePro.do")){
            action=new ArticleUpdateProAction();
            try {
                forward = action.execute(request, response);
            } catch (Exception e) {
                e.printStackTrace();
            }
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
