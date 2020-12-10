package ua.lviv.iot.model.entity;


import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "review")
public class ReviewEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "response")
    private String response;

    @Column(name = "rating")
    private Integer rating;

    @Column(name = "recommended")
    private Integer recommended;

    @ManyToOne
    @JoinColumn(name = "man_id",
            referencedColumnName = "id", nullable = false)
    private ManEntity manEntity;

    @ManyToOne
    @JoinColumn(name = "film_id",
            referencedColumnName = "id", nullable = false)
    private FilmEntity filmEntity;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ReviewEntity reviewEntity = (ReviewEntity) o;
        return id.equals(reviewEntity.id)
                && response.equals(reviewEntity.response)
                && rating.equals(reviewEntity.rating)
                && Objects.equals(recommended, reviewEntity.recommended)
                && Objects.equals(manEntity, reviewEntity.manEntity)
                && Objects.equals(filmEntity, reviewEntity.filmEntity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, response, rating, recommended, manEntity, filmEntity);
    }

    public ReviewEntity(String response, Integer rating, Integer recommended, ManEntity manEntity, FilmEntity filmEntity) {
        this.response = response;
        this.rating = rating;
        this.recommended = recommended;
        this.manEntity = manEntity;
        this.filmEntity = filmEntity;
    }

    @Override
    public String toString() {
        return "Review{" +
                "id=" + id +
                ", response='" + response + '\'' +
                ", rating=" + rating +
                ", recommended=" + recommended +
                ", manEntity=" + manEntity.toString() +
                ", filmEntity=" + filmEntity.toString() +
                '}';
    }

    public ManEntity getManEntity() {
        return manEntity;
    }

    public void setManEntity(ManEntity manEntity) {
        this.manEntity = manEntity;
    }

    public FilmEntity getFilmEntity() {
        return filmEntity;
    }

    public void setFilmEntity(FilmEntity filmEntity) {
        this.filmEntity = filmEntity;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public Integer getRecommended() {
        return recommended;
    }

    public void setRecommended(Integer recommended) {
        this.recommended = recommended;
    }


}
