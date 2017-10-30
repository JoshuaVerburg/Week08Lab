package servlets;

import businesslogic.NoteService;
import domainmodel.Note;

import java.io.IOException;
import static java.lang.Integer.parseInt;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        NoteService us = new NoteService();
        String action = request.getParameter("action");
        if (action != null && action.equals("view")) {
            String selectedNoteString = request.getParameter("selectedNote");
            int selectedNote = parseInt(selectedNoteString);
            try {
                Note note = us.get(selectedNote);
                request.setAttribute("selectedNote", note);
            } catch (Exception ex) {
                Logger.getLogger(UserServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        List<Note> notes = null;        
        try {
            notes = us.getAll();
        } catch (Exception ex) {
            Logger.getLogger(UserServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        request.setAttribute("notes", notes);
        getServletContext().getRequestDispatcher("/WEB-INF/users.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");
        String datecreated = request.getParameter("datecreated");
        String contents = request.getParameter("contents");
        String noteid = request.getParameter("noteid");
        int noteidint = 0;
        if(noteid != null){
        noteidint = parseInt(noteid);
        }
        Date date = new Date();

        NoteService us = new NoteService();

        try {
            if (action.equals("delete")) {
                String selectedNoteString = request.getParameter("selectedNote");
                int selectedNote = parseInt(selectedNoteString);
                us.delete(selectedNote);
            } else if (action.equals("edit")) {
                
                us.update(noteidint, new Date(), contents);
            } else if (action.equals("add")) {
                
                us.insert(0, new Date(), contents);
            }
        } catch (Exception ex) {
            request.setAttribute("errorMessage", "Whoops.  Could not perform that action.");
        }
        
        List<Note> notes = null;
        try {
            notes = us.getAll();
        } catch (Exception ex) {
            Logger.getLogger(UserServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        request.setAttribute("notes", notes);
        getServletContext().getRequestDispatcher("/WEB-INF/users.jsp").forward(request, response);
    }
}
