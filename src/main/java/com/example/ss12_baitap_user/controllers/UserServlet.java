package com.example.ss12_baitap_user.controllers;

import com.example.ss12_baitap_user.models.User;
import com.example.ss12_baitap_user.services.IUserService;
import com.example.ss12_baitap_user.services.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "UserServlet", urlPatterns = "/users")
public class UserServlet extends HttpServlet {
    IUserService iUserService = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                showFormCreate(req, resp);
                break;
            case "edit":
                showFormEdit(req, resp);
                break;
            case "delete":
                deleteUser(req,resp);
                break;
            case "searchCountry":
                getSearchContry(req,resp);
                break;
            case "arrange":
                getArrange(req,resp);
                break;
            default:
                showListUser(req, resp);
        }
    }

    private void getSearchContry(HttpServletRequest req, HttpServletResponse resp) {
        String countryUser = req.getParameter("countryUser");
        List<User>users = iUserService.searchByCountry(countryUser);
        RequestDispatcher dispatcher = req.getRequestDispatcher("list.jsp");
        req.setAttribute("ds", users);
        try {
            dispatcher.forward(req,resp);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void deleteUser(HttpServletRequest req, HttpServletResponse resp) {
        Integer id = Integer.parseInt(req.getParameter("id"));

        iUserService.delete(id);
        try {
            resp.sendRedirect("users");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    private void showFormEdit(HttpServletRequest req, HttpServletResponse resp) {
        RequestDispatcher dispatcher = req.getRequestDispatcher("edit.jsp");
        Integer id = Integer.parseInt(req.getParameter("id"));
        User user = this.iUserService.findById(id);
        req.setAttribute("user",user);

        try {
            dispatcher.forward(req,resp);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private void showFormCreate(HttpServletRequest req, HttpServletResponse resp) {
        RequestDispatcher dispatcher = req.getRequestDispatcher("create.jsp");
        try {
            dispatcher.forward(req, resp);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void showListUser(HttpServletRequest req, HttpServletResponse resp) {
        RequestDispatcher dispatcher = req.getRequestDispatcher("list.jsp");
        List<User> users = this.iUserService.findAll();
        req.setAttribute("ds", users);
        try {
            dispatcher.forward(req, resp);
        } catch (ServletException e) {

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                createUser(req, resp);
                break;
            case "edit":
                editUser(req,resp);
                break;
            case "searchCountry":
                getSearchContry(req,resp);
                break;


        }
    }

    private void getArrange(HttpServletRequest req, HttpServletResponse resp) {
        List<User>users = iUserService.findAllArranged();
        RequestDispatcher dispatcher = req.getRequestDispatcher("list.jsp");
        req.setAttribute("ds", users);
        try {
            dispatcher.forward(req,resp);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void editUser(HttpServletRequest req, HttpServletResponse resp) {
        Integer id = Integer.parseInt(req.getParameter("id"));
        String nameUser = req.getParameter("name_User");
        String emailUser = req.getParameter("email_User");
        String countryUser = req.getParameter("country_User");
        User user = new User(id,nameUser,emailUser,countryUser);
        iUserService.update(user);
        try {
            resp.sendRedirect("/users");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void createUser(HttpServletRequest req, HttpServletResponse resp) {
        String nameUser = req.getParameter("name_User");
        String emailUser = req.getParameter("email_User");
        String countryUser = req.getParameter("country_User");
        User user = new User(nameUser, emailUser, countryUser);
        iUserService.save(user);
        try {
            resp.sendRedirect("/users");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
