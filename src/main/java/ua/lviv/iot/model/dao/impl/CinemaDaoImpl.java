package ua.lviv.iot.model.dao.impl;

import org.hibernate.Session;
import ua.lviv.iot.model.dao.AbstractGenericDao;
import ua.lviv.iot.model.entity.CinemaEntity;
import ua.lviv.iot.model.entity.CountryEntity;
import ua.lviv.iot.persistance.ConnectionManager;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CinemaDaoImpl implements AbstractGenericDao<CinemaEntity> {

    HallDaoImpl hallDao = new HallDaoImpl();
    @Override
    public List<CinemaEntity> findAll() {
        List<CinemaEntity> countries = new ArrayList<>();

        try (Session session = ConnectionManager.getSession()) {
            session.beginTransaction();
            countries = session.createQuery("from CinemaEntity").getResultList();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return countries;
    }

    @Override
    public CinemaEntity findOne(Integer id) {
        CinemaEntity country = null;

        try (Session session = ConnectionManager.getSession()) {
            session.beginTransaction();
            country = session.get(CinemaEntity.class, id);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return country;
    }


    @Override
    public void create(CinemaEntity country) {
        try (Session session = ConnectionManager.getSession()) {
            session.beginTransaction();
            session.save(country);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Integer id, CinemaEntity country) {
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
            CinemaEntity country = session.get(CinemaEntity.class, id);
            if (country != null) {
                hallDao.deleteWithCinema(country);
                session.delete(country);
            }
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteWithCountry(CountryEntity country) {
        try (Session session = ConnectionManager.getSession()) {
            session.beginTransaction();
            List<CinemaEntity> all = findAll();
            List<CinemaEntity> cinemaEntityList = all.stream()
                    .filter(cinemaEntity -> cinemaEntity.getCountryEntity().getId().equals(country.getId()))
                    .collect(Collectors.toList());
            for (CinemaEntity cinema :
                    cinemaEntityList) {
                delete(cinema.getId());
            }
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
