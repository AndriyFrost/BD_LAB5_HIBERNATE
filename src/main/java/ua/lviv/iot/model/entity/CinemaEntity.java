package ua.lviv.iot.model.entity;



import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "cinema")
public class CinemaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "city")
    private String city;

    @Column(name = "address")
    private String address;

    @ManyToOne
    @JoinColumn(name = "country_id",
            referencedColumnName = "id", nullable = false)
    private CountryEntity countryEntity;


    @OneToMany(mappedBy = "cinemaEntity")
    private List<HallEntity> hallEntities;

    @Override
    public String toString() {
        return "CinemaEntity{" +
                "id=" + id +
                ", city='" + city + '\'' +
                ", address='" + address + '\'' +
                ", countryEntity=" + countryEntity.toString() +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public CountryEntity getCountryEntity() {
        return countryEntity;
    }

    public void setCountryEntity(CountryEntity countryEntity) {
        this.countryEntity = countryEntity;
    }

    public List<HallEntity> getHallEntities() {
        return hallEntities;
    }

    public void setHallEntities(List<HallEntity> hallEntities) {
        this.hallEntities = hallEntities;
    }

    public CinemaEntity(String city, String address, CountryEntity countryEntity) {
        this.city = city;
        this.address = address;
        this.countryEntity = countryEntity;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CinemaEntity cinemaEntity = (CinemaEntity) o;
        return id.equals(cinemaEntity.id)
                && city.equals(cinemaEntity.city)
                && address.equals(cinemaEntity.address)
                && Objects.equals(countryEntity, cinemaEntity.countryEntity)
                && Objects.equals(hallEntities,cinemaEntity.hallEntities);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, city, address, countryEntity, hallEntities);
    }

    public CinemaEntity() {
    }
}
