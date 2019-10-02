
import org.sql2o.Connection;
import org.sql2o.Sql2oException;
import org.sql2o.Connection;
import java.util.List;
import java.util.Objects;

public class Departments {
    private static int id;
    private String dname;
    private String ddescription;
    private int nemployees;

    public Departments(String dname, String ddescription, int nemployees) {
        this.dname = dname;
        this.ddescription = ddescription;
        this.nemployees = nemployees;
    }

    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        Departments.id = id;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public String getDdescription() {
        return ddescription;
    }

    public void setDdescription(String ddescription) {
        this.ddescription = ddescription;
    }

    public int getNemployees() {
        return nemployees;
    }

    public void setNemployees(int nemployees) {
        this.nemployees = nemployees;
    }

    public void save() {
        try (Connection con = DB.sql2o.open()) {
            String cece = "INSERT INTO userer(dname,ddescription,nemployees)VALUES(:dname,:ddescription,:nemployees);";
            this.id = (int) con.createQuery(cece, true)
                    .addParameter("dname", this.dname)
                    .addParameter("ddescription", this.ddescription)
                    .addParameter("nemployees", this.nemployees)
                    .executeUpdate()
                    .getKey();
        } catch (Sql2oException NO_IN_Departmants) {
            System.out.println(NO_IN_Departmants);
        }
    }


    public static List<Departments> getThemAll() {
        String cece = "SELECT * FROM department;";
        try (Connection con = DB.sql2o.open()) {
            return con.createQuery(cece)
                    .executeAndFetch(Departments.class);
        }
    }

    public void clearAll() {
        String cece = "DELETE from department";
        try (Connection con = DB.sql2o.open()) {
            con.createQuery(cece).executeUpdate();
        } catch (Sql2oException NO_IN_Departmants) {
            System.out.println(NO_IN_Departmants);
        }
    }


//    public List<Users> getAllUsersInDepartment(int DepId) {
//        return null;
//    }
//
//
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
//
//    public Departments findById(int id) {
//        try (Connection con = sql2o.open()) {
//            return con.createQuery("SELECT * FROM department WHERE id = :id")
//                    .addParameter("id", id)
//                    .executeAndFetchFirst(Departments.class);
//        }
//    }
//
//
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
//
//    public void deleteById(int id) {
//
//    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Departments that = (Departments) o;
        return nemployees == that.nemployees &&
                Objects.equals(dname, that.dname) &&
                Objects.equals(ddescription, that.ddescription);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dname, ddescription, nemployees);
    }
}
