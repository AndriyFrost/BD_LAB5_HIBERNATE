package ua.lviv.iot.model.dao.impl;

import org.hibernate.Session;
import ua.lviv.iot.model.dao.AbstractGenericDao;
import ua.lviv.iot.model.entity.*;
import ua.lviv.iot.persistance.ConnectionManager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ActorDaoImpl implements AbstractGenericDao<ActorEntity> {


    @Override
    public List<ActorEntity> findAll() {
        List<ActorEntity> countries = new ArrayList<>();

        try (Session session = ConnectionManager.getSession()) {
            session.beginTransaction();
            countries = session.createQuery("from ActorEntity").getResultList();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return countries;
    }

    @Override
    public ActorEntity findOne(Integer id) {
        ActorEntity country = null;

        try (Session session = ConnectionManager.getSession()) {
            session.beginTransaction();
            country = session.get(ActorEntity.class, id);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return country;
    }


    @Override
    public void create(ActorEntity country)  {
        try (Session session = ConnectionManager.getSession()) {
            session.beginTransaction();
            session.save(country);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Integer id,  ActorEntity country)  {
        try (Session session = ConnectionManager.getSession()) {
            session.beginTransaction();
            session.update(country);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Integer id) {
        try (Session session = ConnectionManager.getSession()) {
            session.beginTransaction();
            ActorEntity country = session.get(ActorEntity.class, id);
            if (country != null) {
                session.delete(country);
            }
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteWithMan(ManEntity country) {
        try (Session session = ConnectionManager.getSession()) {
            session.beginTransaction();
            List<ActorEntity> all = findAll();
            List<ActorEntity> cinemaEntityList = all.stream()
                    .filter(cinemaEntity -> cinemaEntity.getManEntity().getId().equals(country.getId()))
                    .collect(Collectors.toList());
            for (ActorEntity cinema :
                    cinemaEntityList) {
                delete(cinema.getManEntity().getId());
            }
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
