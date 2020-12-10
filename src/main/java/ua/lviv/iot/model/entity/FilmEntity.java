package ua.lviv.iot.model.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "film")
public class FilmEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "move_title")
    private String moveTitle;

    @Column(name = "genre")
    private String genre;

    @Column(name = "descripttion")
    private String description;

    @Column(name = "release_date")
    private String releaseDate;


    @ManyToMany(mappedBy = "filmEntities")
    private Set<ActorEntity> actorEntities = new HashSet<>();


    @OneToMany(mappedBy = "filmEntity")
    private List<SessionEntity> sessionEntities;


    @OneToMany(mappedBy = "filmEntity")
    private List<ReviewEntity> reviewEntities;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        FilmEntity filmEntity = (FilmEntity) o;
        return id.equals(filmEntity.id)
                && moveTitle.equals(filmEntity.moveTitle)
                && genre.equals(filmEntity.genre)
                && Objects.equals(description, filmEntity.description)
                && Objects.equals(releaseDate, filmEntity.releaseDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, moveTitle, genre, description,releaseDate);
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMoveTitle() {
        return moveTitle;
    }

    public void setMoveTitle(String moveTitle) {
        this.moveTitle = moveTitle;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Set<ActorEntity> getActorEntities() {
        return actorEntities;
    }

    public void setActorEntities(Set<ActorEntity> actorEntities) {
        this.actorEntities = actorEntities;
    }

    public List<SessionEntity> getSessionEntities() {
        return sessionEntities;
    }

    public void setSessionEntities(List<SessionEntity> sessionEntities) {
        this.sessionEntities = sessionEntities;
    }

    public List<ReviewEntity> getReviewEntities() {
        return reviewEntities;
    }

    public void setReviewEntities(List<ReviewEntity> reviewEntities) {
        this.reviewEntities = reviewEntities;
    }

    public FilmEntity(String moveTitle, String genre, String description, String releaseDate ) {
        this.moveTitle = moveTitle;
        this.genre = genre;
        this.description = description;
        this.releaseDate = releaseDate;
    }

    @Override
    public String toString() {
        return "Film{" +
                "id=" + id +
                ", moveTitle='" + moveTitle + '\'' +
                ", genre='" + genre + '\'' +
                ", description='" + description + '\'' +
                ", releaseDate='" + releaseDate + '\'' +
                '}';
    }

    public FilmEntity() {
    }
}
