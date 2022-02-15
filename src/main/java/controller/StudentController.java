package controller;

import entity.Student;
import service.StudentService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Date;
import java.util.List;

@Path("/students")
public class StudentController {

    StudentService studentService = new StudentService();

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Student> getListStudent() {
        return studentService.getListStudent();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Student getStudent(@PathParam("id") int id) {
        return studentService.findID(id);
    }

    @GET
    @Path("/{attribute}/{value}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Student> searchStudentByStringAttributes(@PathParam("attribute") String attribute, @PathParam("value")  String value) {
        return studentService.searchListStudentByString(attribute,value);
    }

    @GET
    @Path("/{attribute}/{value}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Student> searchStudentByFloatAttributes(@PathParam("attribute") String attribute,@PathParam("value")  Float value) {
        return studentService.searchListStudentByNumber(attribute,value);
    }

   /* @GET
    @Path("/{attribute}/{value}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Student> searchStudentByDateAttributes(@PathParam("attribute") String attribute,@PathParam("value") Date value) {
        return studentService.searchListStudentByDate(attribute,value);
    }*/

    @POST
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public String addNewStudent(Student student) {
        return studentService.insert(student) ? "Thêm mới thành công" : "Thêm mới thất bại";
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String removeStudent(@PathParam("id") int id) {
        return studentService.removeStudent(id) ? "Xóa thành công" : "Xóa thất bại";
    }

}