package beans;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "roles", schema = "testbase")
public class RolesEntity {

    @Id
    @Column(name = "id", nullable = false)
    private int id;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "role")
    private List<UsersEntity> user;

    @Basic
    @Column(name = "role")
    private String role;

    public RolesEntity() {
    }

    public RolesEntity(String role, List<UsersEntity> user) {
        this.role = role;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public List<UsersEntity> getUser() {
        return user;
    }

    public void setUser(List<UsersEntity> user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RolesEntity that = (RolesEntity) o;
        return id == that.id &&
                role.equals(that.role) &&
                user.equals(that.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, role, user);
    }

    @Override
    public String toString() {
        return "RolesEntity{" +
                "id=" + id +
                ", role='" + role + '\'' +
                ", user=" + user +
                '}';
    }
}
