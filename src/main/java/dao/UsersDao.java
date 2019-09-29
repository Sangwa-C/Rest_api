package dao;
import Organisation.News;
import Organisation.Departments;
import Organisation.Users;

import java.util.List;

public interface UsersDao {
    //create
    void add(Users users);
    void addUsersToDepartment(Users users, Departments department);

    //read
    List<Users>getThemAll();
    List<Departments>allDepartmentsForUsers(int id);

    void deleteById(int id);
    void clearAll();

    Users findById(int Id);
}
