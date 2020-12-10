package ua.lviv.iot.model.dao.impl;

import org.hibernate.Session;
import ua.lviv.iot.model.dao.AbstractGenericDao;
import ua.lviv.iot.model.entity.CountryEntity;
import ua.lviv.iot.model.entity.HallEntity;
import ua.lviv.iot.model.entity.SessionEntity;
import ua.lviv.iot.persistance.ConnectionManager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SessionDaoImpl implements AbstractGenericDao<SessionEntity> {

    @Override
    public List<SessionEntity> findAll() {
        List<SessionEntity> countries = new ArrayList<>();

        try (Session session = ConnectionManager.getSession()) {
            session.beginTransaction();
            countries = session.createQuery("from SessionEntity").getResultList();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return countries;
    }

    @Override
    public SessionEntity findOne(Integer id) {
        SessionEntity country = null;

        try (Session session = ConnectionManager.getSession()) {
            session.beginTransaction();
            country = session.get(SessionEntity.class, id);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return country;
    }


    @Override
    public void create(SessionEntity country)  {
        try (Session session = ConnectionManager.getSession()) {
            session.beginTransaction();
            session.save(country);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Integer id,  SessionEntity country)  {
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
            SessionEntity country = session.get(SessionEntity.class, id);
            if (country != null) {
                session.delete(country);
            }
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteWithHall(HallEntity country) {
        try (Session session = ConnectionManager.getSession()) {
            session.beginTransaction();
            List<SessionEntity> all = findAll();
            List<SessionEntity> cinemaEntityList = all.stream()
                    .filter(cinemaEntity -> cinemaEntity.getHallEntity().getId().equals(country.getId()))
                    .collect(Collectors.toList());
            for (SessionEntity cinema :
                    cinemaEntityList) {
                delete(cinema.getId());
            }
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
