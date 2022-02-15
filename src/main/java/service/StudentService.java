package service;

import entity.Student;
import repository.StudentDao;

import java.util.List;

public class StudentService {

    StudentDao studentDao = new StudentDao();



    public List<Student> getListStudent() {
        return studentDao.getAll();
    }

    public List<Student> searchListStudentByString(String attribute,String values) {
        return studentDao.findByStringAttribute(attribute,values);
    }

    public List<Student> searchListStudentByNumber(String attribute,float values) {
        return studentDao.findByFloatAttribute(attribute,values);
    }

    public Student findID(int id) {
        return studentDao.findById(id);
    }

    public boolean insert(Student student) {
        List<Student> students = studentDao.getAll();
        students.sort((o1, o2) -> o1.getId() < o2.getId() ? 1 : -1);
        int id = students.get(0).getId() + 1;

        student.setId(id);
        if (student.getName() == null) {
            return false;
        }
        return studentDao.insert(student);
    }

    public boolean removeStudent(int id) {
        return studentDao.removeStudent(id);
    }

}
