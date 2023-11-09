package com.example.module7;

import java.io.*;
import entity.ToDoListEntity;
import jakarta.persistence.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet("/toDo-servlet")
public class ToDoServlet extends HttpServlet {

    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
    EntityManager entityManager = entityManagerFactory.createEntityManager();
    //EntityTransaction transaction = entityManager.getTransaction();

    //TypedQuery<ToDoListEntity> viewToDo = entityManager.createNamedQuery("ToDoListEntity.viewList", ToDoListEntity.class);

    public void init() throws ServletException {
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getServletPath();

        EntityTransaction transaction = entityManager.getTransaction();

        switch(action) {
            case "/addTask":
                transaction.begin();
                String toDoItem = request.getParameter("toDoAdd");
                System.out.println(toDoItem);

                // Adds to-do item to the DB
                ToDoListEntity toDoAdd = new ToDoListEntity();
                toDoAdd.setTask(toDoItem);
                entityManager.persist(toDoAdd);
                entityManager.flush();

                transaction.commit();
                break;
            case "/deleteTask":
                transaction.begin();
                ToDoListEntity toDoDelete = new ToDoListEntity();

                transaction.commit();
                break;
            default:
                break;
        }
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //response.setContentType("text/html");

    }

    public void destroy() {
    }
}