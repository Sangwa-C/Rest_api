package Organisation;

import java.util.Objects;

public class News {
    private int NewsId;
    private String heading;
    private String body;

    public int getNewsId() { return NewsId; }

    public String getHeading() {
        return heading;
    }

    public void setHeading(String heading) {
        this.heading = heading;
    }

    public String getBody() { return body; }

    public void setBody(String body) { this.body = body; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        News news = (News) o;
        return NewsId == news.NewsId &&
                Objects.equals(heading, news.heading) &&
                Objects.equals(body, news.body);
    }

    @Override
    public int hashCode() {
        return Objects.hash(NewsId, heading, body);
    }
}
