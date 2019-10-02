import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.sql2o.Connection;
import org.sql2o.Sql2oException;

public class Users {
    private static int id;
    private String name;
    private String title;
    private String duty;

    public Users(String name, String title, String duty) {
        this.name = name;
        this.title = title;
        this.duty = duty;
    }

    public static int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDuty() {
        return duty;
    }

    public void setDuty(String duty) {
        this.duty = duty;
    }

    public void save() {
        try (Connection con = DB.sql2o.open()) {
            String cece = "INSERT INTO userer(DepId,usersId) VALUES (:DepId,:usersId) ";
            con.createQuery(cece)
                    .addParameter("DeptId", Departments.getId())
                    .addParameter("usersId", Users.getId())
                    .throwOnMappingFailure(false)
                    .executeUpdate();
        } catch (Sql2oException no) {
            System.out.println(no);
        }

    }

    public static List<Users> getThemAll() {
        try (Connection con = DB.sql2o.open()) {
            return con.createQuery("SELECT * FROM userer")
                    .executeAndFetch(Users.class);
        }
    }


//    public List<Departments> allDepartmentsForUsers(int usersId) {
//        List<Departments> departments = new ArrayList<>();
//        String joinCode = "SELECT DepId FROM user_in_department WHERE usersId=:usersId";
//        try (Connection con = DB.sql2o.open()) {
//            List<Integer> allDepartmentIds = con.createQuery(joinCode)
//                    .addParameter("usersId", usersId)
//                    .executeAndFetch(Integer.class);
//            for (Integer DeptId : allDepartmentIds) {
//                String departmentQuery = "SELECT * FROM department WHERE id = :DeptId";
//                departments.add(
//                        con.createQuery(departmentQuery)
//                                .addParameter("DeptId", DeptId)
//                                .executeAndFetchFirst(Departments.class));
//            }
//        } catch (Sql2oException no) {
//            System.out.println(no);
//        }
//        return departments;
//
//    }
}
