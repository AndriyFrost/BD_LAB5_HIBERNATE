package ua.lviv.iot.model.entity;


import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "session")
public class SessionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "event_time")
    private String eventTime;

    @Column(name = "ticket_price")
    private Integer ticketPrice;

    @Column(name = "tickets_sold")
    private Integer ticketSold;


    @ManyToOne
    @JoinColumn(name = "film_id",
            referencedColumnName = "id", nullable = false)
    private FilmEntity filmEntity;

    @ManyToOne
    @JoinColumn(name = "hall_id",
            referencedColumnName = "id", nullable = false)
    private HallEntity hallEntity;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        SessionEntity sessionEntity = (SessionEntity) o;
        return id.equals(sessionEntity.id)
                && eventTime.equals(sessionEntity.eventTime)
                && ticketPrice.equals(sessionEntity.ticketPrice)
                && ticketSold.equals(sessionEntity.ticketSold)
                && filmEntity.equals(sessionEntity.filmEntity)
                && hallEntity.equals(sessionEntity.hallEntity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, eventTime, ticketPrice, ticketSold, filmEntity, hallEntity);
    }

    public SessionEntity(String eventTime, Integer ticketPrice, Integer ticketSold, FilmEntity filmEntity, HallEntity hallEntity) {
        this.eventTime = eventTime;
        this.ticketPrice = ticketPrice;
        this.ticketSold = ticketSold;
        this.filmEntity = filmEntity;
        this.hallEntity = hallEntity;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEventTime() {
        return eventTime;
    }

    public void setEventTime(String eventTime) {
        this.eventTime = eventTime;
    }

    public Integer getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(Integer ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public Integer getTicketSold() {
        return ticketSold;
    }

    public void setTicketSold(Integer ticketSold) {
        this.ticketSold = ticketSold;
    }


    public FilmEntity getFilmEntity() {
        return filmEntity;
    }

    public void setFilmEntity(FilmEntity filmEntity) {
        this.filmEntity = filmEntity;
    }

    public HallEntity getHallEntity() {
        return hallEntity;
    }

    public void setHallEntity(HallEntity hallEntity) {
        this.hallEntity = hallEntity;
    }

    @Override
    public String toString() {
        return "Session{" +
                "id=" + id +
                ", eventTime='" + eventTime + '\'' +
                ", ticketPrice=" + ticketPrice +
                ", ticketSold=" + ticketSold +
                ", filmEntity=" + filmEntity.toString() +
                ", hallEntity=" + hallEntity.toString() +
                '}';
    }

    public SessionEntity() {
    }
}
