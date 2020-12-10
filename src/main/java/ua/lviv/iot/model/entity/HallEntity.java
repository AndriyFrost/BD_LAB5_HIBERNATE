package ua.lviv.iot.model.entity;


import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "hall")
public class HallEntity {

    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "number_of_seats")
    private Integer numberOfSeats;

    @ManyToOne
    @JoinColumn(name = "cinema_id",
            referencedColumnName = "id", nullable = false)
    private CinemaEntity cinemaEntity;


    @OneToMany(mappedBy = "hallEntity")
    private List<SessionEntity> sessionEntities;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        HallEntity hallEntity = (HallEntity) o;
        return id.equals(hallEntity.id)
                && numberOfSeats.equals(hallEntity.numberOfSeats)
                && Objects.equals(cinemaEntity, hallEntity.cinemaEntity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, numberOfSeats, cinemaEntity);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(Integer numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public CinemaEntity getCinemaEntity() {
        return cinemaEntity;
    }

    public void setCinemaEntity(CinemaEntity cinemaEntity) {
        this.cinemaEntity = cinemaEntity;
    }

    public List<SessionEntity> getSessionEntities() {
        return sessionEntities;
    }

    public void setSessionEntities(List<SessionEntity> sessionEntities) {
        this.sessionEntities = sessionEntities;
    }

    public HallEntity( Integer numberOfSeats, CinemaEntity cinemaEntity) {
        this.numberOfSeats = numberOfSeats;
        this.cinemaEntity = cinemaEntity;
    }


    @Override
    public String toString() {
        return "HallEntity{" +
                "id=" + id +
                ", numberOfSeats=" + numberOfSeats +
                ", cinemaEntity=" + cinemaEntity.toString() +
                '}';
    }

    public HallEntity() {
    }
}
