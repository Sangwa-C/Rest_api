//package dao;
//
//
//import org.sql2o.Connection;
//import org.sql2o.Sql2o;
//import org.sql2o.Sql2oException;
//
//import java.util.List;
//
//public class Sql20NewsDao implements NewsDao{
//    private final Sql2o sql2o;
//
//    public Sql20NewsDao(Sql2o sql2o) {
//        this.sql2o = sql2o;
//    }
//
//
//    @Override
//    public void add(News news) {
//        String cece ="INSERT INTO news(heading,body) VALUES(:heading,:body)";
//        try (Connection con = sql2o.open()) {
//            int id = (int) con.createQuery(cece, true)
//                    .bind(news)
//                    .executeUpdate()
//                    .getKey();
//            news.setId(id);
//        } catch (Sql2oException no) {
//            System.out.println(no);
//        }
//    }
//
//    @Override
//    public List<News> getThemAll() {
//        return null;
//    }
//
//    @Override
//    public List<News> allNewsPostedInDepartment(int DepId) {
//        return null;
//    }
//
//    @Override
//    public void deleteById(int id) {
//
//    }
//
//    @Override
//    public void clearAll() {
//
//    }
//}
