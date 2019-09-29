package dao;

import Organisation.News;

import java.util.List;

public interface NewsDao {
    //creating
    void  add(News news);
    List<News> getThemAll();
    List<News> allNewsPostedInDepartment(int DepId);

    //reading
    //void update(int id,String contents,int deptId);
    void deleteById(int id);
    void clearAll();
}
