package Organisation;

import java.util.Objects;

public class Departments {
    private int id;
    private String DName;
    private String DDescription;
    private int NEmployees;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDName() {
        return DName;
    }

    public void setDName(String DName) {
        this.DName = DName;
    }

    public String getDDescription() {
        return DDescription;
    }

    public void setDDescription(String DDescription) {
        this.DDescription = DDescription;
    }

    public int getNEmployees() {
        return NEmployees;
    }

    public void setNEmployees(int NEmployees) {
        this.NEmployees = NEmployees;
    }

    public Departments() {
        super();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Departments that = (Departments) o;
        return id == that.id &&
                NEmployees == that.NEmployees &&
                Objects.equals(DName, that.DName) &&
                Objects.equals(DDescription, that.DDescription);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, DName, DDescription, NEmployees);
    }
}
