package com.wjl.controller;


import com.wjl.entity.Student;
import com.wjl.service.StudentService;
import com.wjl.service.StudentServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/student/*")
public class StudentServlet extends HttpServlet {
    private StudentService service = new StudentServiceImpl();

    @Override
    protected void doGet(
            HttpServletRequest req,
            HttpServletResponse resp)
            throws ServletException, IOException {

        String path =
                req.getPathInfo();

        System.out.println(path);

        if ("/delete".equals(path)) {
            int id =
                    Integer.parseInt(
                            req.getParameter("id")
                    );
            service.delete(id);
            resp.sendRedirect(
                    req.getContextPath()
                            + "/student/list"
            );
            return;
        }

        if ("/toUpdate".equals(path)) {


            int id =
                    Integer.parseInt(
                            req.getParameter("id")
                    );


            Student student =
                    service.findById(id);

            System.out.println(student);


            req.setAttribute(
                    "s",
                    student
            );
            req.getRequestDispatcher(
                            "/updateStudent.jsp"
                    )
                    .forward(
                            req,
                            resp
                    );
            return;
        }

        List<Student> list =
                service.findAll();

        resp.setContentType(
                "text/html;charset = utf-8"
        );

        PrintWriter out = resp.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Student List</title>");
        out.println("</head>");
        out.println("<body>");

        out.println("<h1>Student Information</h1>");
        out.println("<table border='1'>");
        out.println(
                "<tr>" +
                        "<th>ID</th>" +
                        "<th>Student_num</th>" +
                        "<th>Name</th>" +
                        "<th>Age</th>" +
                        "<th>OPERATE</th>" +
                        "</tr>"
        );

        for (Student s : list) {
            out.println(
                    "<tr>" +
                            "<td>" + s.getId() + "</td>" +
                            "<td>" + s.getSut_num() + "</td>" +
                            "<td>" + s.getName() + "</td>" +
                            "<td>" + s.getAge() + "</td>" +

                            "<td>" +
                            "<a href='toUpdate?id="
                            + s.getId() +
                            "'>UPDATE</a> " +
                            "<a href='delete?id="
                            + s.getId() +
                            "'>DELETE</a>" +
                            "</td>" +
                    "</tr>"
            );
        }
        out.println("</table>");
        out.println("</body>");
        out.println("</html>");
    }

    @Override
    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {


        request.setCharacterEncoding("UTF-8");


        String path = request.getPathInfo();



        // =====================
        // /student/add
        // =====================
        if("/add".equals(path)){


            String stu_num =
                    request.getParameter("stu_num");


            String name =
                    request.getParameter("name");


            int age =
                    Integer.parseInt(
                            request.getParameter("age")
                    );


            Student student =
                    new Student();


            student.setSut_num(stu_num);

            student.setName(name);

            student.setAge(age);



            service.add(student);



            response.sendRedirect(
                    request.getContextPath()
                            + "/student/list"
            );


            return;

        }


        // =====================
        // /student/update

        if("/update".equals(path)){

            int id =
                    Integer.parseInt(
                            request.getParameter("id")
                    );

            String stu_num =
                    request.getParameter("stu_num");

            String name =
                    request.getParameter("name");

            int age =
                    Integer.parseInt(
                            request.getParameter("age")
                    );


            Student student =
                    new Student();


            student.setId(id);

            student.setSut_num(stu_num);

            student.setName(name);

            student.setAge(age);

            service.update(student);

            response.sendRedirect(
                    request.getContextPath()
                            + "/student/list"
            );
            return;

        }

    }
}