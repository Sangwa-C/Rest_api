package dao;

import java.util.ArrayList;
import java.util.List;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import Organisation.Departments;
import Organisation.Users;
import org.sql2o.Sql2oException;


public class Sql2oUserDao implements UsersDao {

    private final Sql2o sql2o;

    public Sql2oUserDao(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    @Override
    public void add(Users users) {
        String cece="INSERT INTO users (name, title, duty) VALUES (:name, :title, :duty)";
        try(Connection con = sql2o.open()){
            int id = (int) con.createQuery(cece, true)
                    .bind(users)
                    .executeUpdate()
                    .getKey();
            users.setUserId(id);
        } catch (Sql2oException no) {
            System.out.println(no);
        }

    }

    @Override
    public void addUsersToDepartment(Users users, Departments department) {
        String data="INSERT INTO user_in_department(DepId,usersId) VALUES (:DepId,:usersId) ";
        try (Connection con = sql2o.open()) {
            con.createQuery(data)
                    .addParameter("DeptId", department.getDepId())
                    .addParameter("usersId", users.getUsersId())
                    .throwOnMappingFailure(false)
                    .executeUpdate();
        } catch (Sql2oException no){
            System.out.println(no);
        }

    }


    @Override
    public List<Users> getThemAll() {
        try(Connection con = sql2o.open()){
            return con.createQuery("SELECT * FROM users")
                    .executeAndFetch(Users.class);
        }
    }

    @Override
    public List<Departments> allDepartmentsForUsers(int usersId) {
        List<Departments>departments=new ArrayList<>();
        String joinCode="SELECT DepId FROM user_in_department WHERE usersId=:usersId";
        try (Connection con = sql2o.open()) {
            List<Integer> allDepartmentIds = con.createQuery(joinCode)
                    .addParameter("usersId", usersId)
                    .executeAndFetch(Integer.class);
            for (Integer DeptId : allDepartmentIds){
                String departmentQuery = "SELECT * FROM department WHERE id = :DeptId";
                departments.add(
                        con.createQuery(departmentQuery)
                                .addParameter("DeptId", DeptId)
                                .executeAndFetchFirst(Departments.class));
            }
        } catch (Sql2oException no){
            System.out.println(no);
        }
        return departments;
    }

    @Override
    public void deleteById(int id) {
        String sql = "DELETE from users WHERE id = :id";
        String deleteCode = "DELETE from users_in_department WHERE usersId = :usersId";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("id", id)
                    .executeUpdate();

            con.createQuery(deleteCode)
                    .addParameter("usersId", id)
                    .executeUpdate();
        } catch (Sql2oException no){
            System.out.println(no);
        }

    }

    @Override
    public void clearAll() {
        String cece = "DELETE FROM users";
        try (Connection con = sql2o.open()) {
            con.createQuery(cece).executeUpdate();
        } catch (Sql2oException no) {
            System.out.println(no);
        }

    }

    @Override
    public Users findById(int usersId) {
        try(Connection con = sql2o.open()){
            return con.createQuery("SELECT * FROM users WHERE id = :id")
                    .addParameter("usersId", usersId)
                    .executeAndFetchFirst(Users.class);
        }

    }
}
