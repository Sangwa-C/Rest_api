//package dao;
//import org.sql2o.Connection;
//import org.sql2o.Sql2o;
//import org.sql2o.Sql2oException;
//import models.Departments;
//import models.Users;
//
//import java.util.List;
//
//
//public class Sql2oDepartmentDao implements DepartmentDao {
//    private Sql2o sql2o;
//
//    public Sql2oDepartmentDao(Sql2o sql2o){
//        this.sql2o=sql2o;
//        int id;
//    }
//
//    @Override
//    public void add(Departments departments) {
//        String data="INSERT INTO departments(depDescription,depName,nbrEmployees)VALUES(:depDescription,:depName,:nbrEmployees);";
//        try (Connection con = sql2o.open()) {
//            int id = (int) con.createQuery(data, true)
//                    .bind(departments)
//                    .executeUpdate()
//                    .getKey();
//            departments.setId(id);
//        } catch (Sql2oException ex) {
//            System.out.println(ex);
//        }
//    }
//
//    @Override
//    public void addDepartmentToUsers(Departments departments, Users users) {
//
//    }
//
//    @Override
//    public List<Departments> getThemAll() {
//        try (Connection con = sql2o.open()) {
//            return con.createQuery("SELECT * FROM department")
//                    .executeAndFetch(Departments.class);
//        }
//    }
//
//    @Override
//    public List<Users> getAllUsersInDepartment(int DepId) {
//        return null;
//    }
//
//    @Override
//    public List<Departments> getAllDepartmentNews(int NewsId) {
//        String cece = "SELECT * FROM News WHERE departmentId =:deptId";
//
//        try(Connection con= sql2o.open()){
//            return con.createQuery(cece)
//                    .addParameter("NewsId", NewsId)
//                    .throwOnMappingFailure(false)
//                    .executeAndFetch(Departments.class);
//        }
//    }
//
//    @Override
//    public Departments findById(int id) {
//        try (Connection con = sql2o.open()) {
//            return con.createQuery("SELECT * FROM department WHERE id = :id")
//                    .addParameter("id", id)
//                    .executeAndFetchFirst(Departments.class);
//        }
//    }
//
//    @Override
//    public void update(int DepId, String DName, String DDescription, int NEmployees) {
//        String cece ="UPDATE department SET (DName,DDescription,NEmployees)=(:DName,:DDescription,:NEmployees)";
//        try (Connection con=sql2o.open()){
//            con.createQuery(cece)
//                    .addParameter("DName",DName)
//                    .addParameter("DDescription",DDescription)
//                    .addParameter("NEmployees",NEmployees)
//                    .executeUpdate();
//        }catch (Sql2oException no){
//            System.out.println(no);
//        }
//    }
//
//    @Override
//    public void deleteById(int id) {
//
//    }
//
//    @Override
//    public void clearAll() {
//        String cece = "DELETE from department";
//        try (Connection con = sql2o.open()) {
//            con.createQuery(cece).executeUpdate();
//        } catch (Sql2oException no) {
//            System.out.println(no);
//        }
//    }
//}
