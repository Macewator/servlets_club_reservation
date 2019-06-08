package pl.arizona.club.controller;

import pl.arizona.club.model.Reservation;
import pl.arizona.club.model.User;
import pl.arizona.club.service.ReservationService;
import pl.arizona.club.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@WebServlet("/profile")
public class ProfileController extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String[] params = request.getParameterValues("option");
        if (params != null) {
            request.getRequestDispatcher("WEB-INF/profileUpdate.jsp").forward(request, response);
        }
        String actionEnable = "enable";
        if (request.getParameter("edit").equals(actionEnable)) {
            request.setAttribute("edit", actionEnable);
        }
        if (request.getParameter("delete").equals(actionEnable)) {
            request.setAttribute("delete", actionEnable);
        }
        User user = (User) request.getSession(false).getAttribute("user");
        long userId = user.getId();
        ReservationService reservService = new ReservationService();
        List<Reservation> reservations = reservService.getAllUserReservation(userId);
        request.setAttribute("reservations", reservations);
        request.getRequestDispatcher("WEB-INF/profile.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userNewEmail = request.getParameter("newEmail");
        String userNewPassword = request.getParameter("newPassword");
        User user = (User) request.getSession(false).getAttribute("user");
        UserService userService = new UserService();
        userService.updateUserData(user, userNewEmail, userNewPassword);
        request.getSession(false).removeAttribute("user");
        response.sendRedirect(request.getContextPath() + "/profile?edit=disable&delete=disable");
    }
}
