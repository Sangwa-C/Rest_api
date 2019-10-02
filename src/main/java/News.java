
import org.sql2o.Connection;
import org.sql2o.Sql2oException;

import java.util.List;

public class News {
    private int id;
    private String header;
    private String content;
    private String author;

    public News(String header, String content, String author) {
        this.header = header;
        this.content = content;
        this.author = author;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void save() {
        try (Connection con = DB.sql2o.open()) {
            String cece ="INSERT INTO news(header,content,author) VALUES(:header,:content,:author)";
            this.id= (int) con.createQuery(cece, true)
                    .addParameter("header", this.header)
                    .addParameter("content", this.content)
                    .addParameter("author", this.author)
                    .executeUpdate()
                    .getKey();
        } catch (Sql2oException NO_IN_News) {
            System.out.println( NO_IN_News);
        }
    }


    public static List<News> getThemAll() {
        String sql = "SELECT * FROM News ;";
        try (Connection con = DB.sql2o.open()) {
            return con.createQuery(sql).executeAndFetch(News.class);
        }
    }
}
