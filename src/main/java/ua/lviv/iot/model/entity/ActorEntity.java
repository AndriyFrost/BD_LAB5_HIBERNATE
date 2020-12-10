package ua.lviv.iot.model.entity;


import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "actor")
public class ActorEntity implements Serializable {

    @Column(name = "acting_education")
    private Integer actingEducation;

    @Column(name = "biography")
    private String biography;

    @OneToOne
    @JoinColumn(name = "manId", referencedColumnName = "id", nullable = false)
    @Id
    private ManEntity manEntity;

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
            name = "Film_Has_Actor",
            joinColumns = {@JoinColumn(name = "film_id")},
            inverseJoinColumns = {@JoinColumn(name = "actor_id")}
    )
    private Set<FilmEntity> filmEntities = new HashSet<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ActorEntity actorEntity = (ActorEntity) o;
        return Objects.equals(manEntity, actorEntity.manEntity)
                && actingEducation.equals(actorEntity.actingEducation)
                && Objects.equals(biography, actorEntity.biography);
    }

    @Override
    public int hashCode() {
        return Objects.hash(actingEducation, biography, manEntity);
    }

    public ActorEntity(Integer actingEducation, String biography, ManEntity manEntity) {
        this.actingEducation = actingEducation;
        this.biography = biography;
        this.manEntity = manEntity;
    }

    @Override
    public String toString() {
        return "ActorEntity{" +
                "actingEducation=" + actingEducation +
                ", biography='" + biography + '\'' +
                ", manEntity=" + manEntity.toString() +
                '}';
    }

    public void removeActor(FilmEntity book) {
        this.filmEntities.remove(book);
    }
    public Set<FilmEntity> getFilmEntities() {
        return filmEntities;
    }

    public void setFilmEntities(Set<FilmEntity> filmEntities) {
        this.filmEntities = filmEntities;
    }

    public Integer getActingEducation() {
        return actingEducation;
    }

    public void setActingEducation(Integer actingEducation) {
        this.actingEducation = actingEducation;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    public ManEntity getManEntity() {
        return manEntity;
    }

    public void setManEntity(ManEntity manEntity) {
        this.manEntity = manEntity;
    }

    public ActorEntity() {
    }
}
