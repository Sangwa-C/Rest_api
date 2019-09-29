package dao;

import Organisation.Departments;
import Organisation.Users;

import java.util.List;

public interface DepartmentDao {
    //creating
    void add(Departments departments);
    void addDepartmentToUsers(Departments departments, Users users);

    //reading
    List<Departments> getThemAll();
    List<Users> getAllUsersInDepartment(int DepId);
    List<Departments> getAllDepartmentNews(int NewsId);

    Departments findById(int id);

    void update( int DepId,
                 String DName,
                 String DDescription,
                 int NEmployees);

    void deleteById(int id);
    void clearAll();
}
