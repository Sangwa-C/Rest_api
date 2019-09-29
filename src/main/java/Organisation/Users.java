package Organisation;
import java.util.Objects;


public class Users {
    private int usersId;
    private String name;
    private String title;
    private String duty;

    public Users(String name, String title, String duty) {
        this.name = name;
        this.title = title;
        this.duty = duty;
    }

    public int getUsersId() { return usersId; }

    public void setUserId(int userId) { this.usersId = usersId; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getTitle() { return title; }

    public void setTitle(String title) { this.title = title; }

    public String getDuty() { return duty; }

    public void setDuty(String duty) { this.duty = duty; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Users users = (Users) o;
        return usersId == users.usersId &&
                Objects.equals(name, users.name) &&
                Objects.equals(title, users.title) &&
                Objects.equals(duty, users.duty);
    }

    @Override
    public int hashCode() {
        return Objects.hash(usersId, name, title, duty);
    }
}
