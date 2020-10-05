package beans;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "users", schema = "testbase")
public class UsersEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "FK_roles")
    private RolesEntity role;

    @OneToMany(fetch = FetchType.EAGER,mappedBy = "user")
    private List<AdsEntity> ads;

    @Basic
    @Column(name = "login", nullable = false, length = 100)
    private String login;

    @Basic
    @Column(name = "password", nullable = false, length = 100)
    private String password;

    @Basic
    @Column(name = "Email", nullable = false, length = 100)
    private String email;

    public UsersEntity() {
    }

    public UsersEntity(int id, RolesEntity role, List<AdsEntity> ads, String login, String password, String email) {
        this.id = id;
        this.role = role;
        this.ads = ads;
        this.login = login;
        this.password = password;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public RolesEntity getRole() {
        return role;
    }

    public void setRole(RolesEntity role) {
        this.role = role;
    }

    public List<AdsEntity> getAds() {
        return ads;
    }

    public void setAds(List<AdsEntity> ads) {
        this.ads = ads;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UsersEntity that = (UsersEntity) o;
        return id == that.id &&
                role.equals(that.role) &&
                ads.equals(that.ads) &&
                login.equals(that.login) &&
                password.equals(that.password) &&
                email.equals(that.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, role, ads, login, password, email);
    }

    @Override
    public String toString() {
        return "UsersEntity{" +
                "id=" + id +
                ", role=" + role +
                ", ads=" + ads +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
