package ua.lviv.iot.model.entity;



import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "country")
public class CountryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "capital")
    private String capital;

    @Column(name = "population")
    private Integer population;

    @Column(name = "area_in_sk")
    private Double areaInSk;

    @Column(name = "country_name")
    private String countryName;


    @OneToMany(mappedBy = "countryEntity")
    private List<CinemaEntity> cinemaEntityList;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CountryEntity countryEntity = (CountryEntity) o;
        return id.equals(countryEntity.id)
                && capital.equals(countryEntity.capital)
                && population.equals(countryEntity.population)
                && Objects.equals(areaInSk, countryEntity.areaInSk)
                && Objects.equals(countryName, countryEntity.countryName)
                && Objects.equals(cinemaEntityList, countryEntity.cinemaEntityList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, capital, population, areaInSk,countryName, cinemaEntityList);
    }

    public CountryEntity(String capital, Integer population, Double areaInSk, String countryName, List<CinemaEntity> cinemaEntityList) {
        this.capital = capital;
        this.population = population;
        this.areaInSk = areaInSk;
        this.countryName = countryName;
        this.cinemaEntityList = cinemaEntityList;
    }
    public CountryEntity(String capital, Integer population, Double areaInSk, String countryName) {
        this.capital = capital;
        this.population = population;
        this.areaInSk = areaInSk;
        this.countryName = countryName;

    }

    @Override
    public String toString() {
        return "CountryEntity{" +
                "id=" + id +
                ", capital='" + capital + '\'' +
                ", population=" + population +
                ", areaInSk=" + areaInSk +
                ", countryName='" + countryName + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public Integer getPopulation() {
        return population;
    }

    public void setPopulation(Integer population) {
        this.population = population;
    }

    public Double getAreaInSk() {
        return areaInSk;
    }

    public void setAreaInSk(Double areaInSk) {
        this.areaInSk = areaInSk;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public CountryEntity() {
    }
}
