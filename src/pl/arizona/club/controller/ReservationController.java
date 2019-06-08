package pl.arizona.club.controller;

import pl.arizona.club.model.User;
import pl.arizona.club.service.ReservationService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/reservation")
public class ReservationController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String reservID = request.getParameter("reservID");
        String date = request.getParameter("date") + " " + request.getParameter("time");
        String type = request.getParameter("reservationType");
        User reservUser = (User) request.getSession(false).getAttribute("user");
        if (request.getUserPrincipal() != null) {
            ReservationService reservService = new ReservationService();
            if(reservID != null){
                reservService.deleteReservation(reservID);
                request.setAttribute("reservID", reservID);
                request.getRequestDispatcher("WEB-INF/confirmation.jsp").forward(request, response);
            }
            reservService.addReservation(date, type, reservUser);
            request.setAttribute("date", date);
            request.setAttribute("reservType", type);
            request.getRequestDispatcher("WEB-INF/confirmation.jsp").forward(request, response);
        } else {
            response.sendError(403);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("WEB-INF/reservation.jsp").forward(request, response);
    }
}
