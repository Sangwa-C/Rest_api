package Organisation;

import java.util.Objects;

public class News {
    private int id;
    private String body;

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public String getBody() { return body; }

    public void setBody(String body) { this.body = body; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        News news = (News) o;
        return id == news.id &&
                Objects.equals(body, news.body);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, body);
    }
}
