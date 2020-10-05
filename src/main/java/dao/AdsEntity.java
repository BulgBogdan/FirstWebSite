package beans;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "ads", schema = "testbase")
public class AdsEntity {
    @Id
    @Column(name = "id", nullable = false)
    private int id;

    @ManyToOne
    @JoinColumn(name = "FK_users")
    private UsersEntity user;

    @Column(name = "animal", nullable = false, length = 100)
    private String animal;

    @Column(name = "breed", nullable = false, length = 100)
    private String breed;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Column(name = "age", nullable = false, length = 100)
    private String age;

    @Column(name = "weight", nullable = false, length = 100)
    private String weight;

    @Column(name = "numberPhone", nullable = false, length = 100)
    private String numberPhone;

    public AdsEntity() {
    }

    public AdsEntity(int id, UsersEntity user, String animal, String breed, String name, String age, String weight, String numberPhone) {
        this.id = id;
        this.user = user;
        this.animal = animal;
        this.breed = breed;
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.numberPhone = numberPhone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public UsersEntity getUser() {
        return user;
    }

    public void setUser(UsersEntity user) {
        this.user = user;
    }

    public String getAnimal() {
        return animal;
    }

    public void setAnimal(String animal) {
        this.animal = animal;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getNumberPhone() {
        return numberPhone;
    }

    public void setNumberPhone(String numberPhone) {
        this.numberPhone = numberPhone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AdsEntity adsEntity = (AdsEntity) o;
        return id == adsEntity.id &&
                user.equals(adsEntity.user) &&
                animal.equals(adsEntity.animal) &&
                breed.equals(adsEntity.breed) &&
                name.equals(adsEntity.name) &&
                age.equals(adsEntity.age) &&
                weight.equals(adsEntity.weight) &&
                numberPhone.equals(adsEntity.numberPhone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, user, animal, breed, name, age, weight, numberPhone);
    }

    @Override
    public String toString() {
        return "AdsEntity{" +
                "id=" + id +
                ", user=" + user +
                ", animal='" + animal + '\'' +
                ", breed='" + breed + '\'' +
                ", name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", weight='" + weight + '\'' +
                ", numberPhone='" + numberPhone + '\'' +
                '}';
    }
}
