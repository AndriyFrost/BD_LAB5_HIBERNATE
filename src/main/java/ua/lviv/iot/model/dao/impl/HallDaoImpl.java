package ua.lviv.iot.model.dao.impl;

import org.hibernate.Session;
import ua.lviv.iot.model.dao.AbstractGenericDao;
import ua.lviv.iot.model.entity.CinemaEntity;
import ua.lviv.iot.model.entity.CountryEntity;
import ua.lviv.iot.model.entity.HallEntity;
import ua.lviv.iot.persistance.ConnectionManager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class HallDaoImpl implements AbstractGenericDao<HallEntity> {

    SessionDaoImpl sessionDao = new SessionDaoImpl();
    @Override
    public List<HallEntity> findAll() {
        List<HallEntity> countries = new ArrayList<>();

        try (Session session = ConnectionManager.getSession()) {
            session.beginTransaction();
            countries = session.createQuery("from HallEntity").getResultList();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return countries;
    }

    @Override
    public HallEntity findOne(Integer id) {
        HallEntity country = null;

        try (Session session = ConnectionManager.getSession()) {
            session.beginTransaction();
            country = session.get(HallEntity.class, id);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return country;
    }


    @Override
    public void create(HallEntity country)  {
        try (Session session = ConnectionManager.getSession()) {
            session.beginTransaction();
            session.save(country);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Integer id,  HallEntity country)  {
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
            HallEntity country = session.get(HallEntity.class, id);
            if (country != null) {
                sessionDao.deleteWithHall(country);
                session.delete(country);
            }
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteWithCinema(CinemaEntity country) {
        try (Session session = ConnectionManager.getSession()) {
            session.beginTransaction();
            List<HallEntity> all = findAll();
            List<HallEntity> cinemaEntityList = all.stream()
                    .filter(cinemaEntity -> cinemaEntity.getCinemaEntity().getId().equals(country.getId()))
                    .collect(Collectors.toList());
            for (HallEntity cinema :
                    cinemaEntityList) {
                delete(cinema.getId());
            }
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}



