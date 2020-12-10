package ua.lviv.iot.model.dao.impl;

import org.hibernate.Session;
import ua.lviv.iot.model.dao.AbstractGenericDao;
import ua.lviv.iot.model.entity.CountryEntity;
import ua.lviv.iot.model.entity.ManEntity;
import ua.lviv.iot.model.entity.ReviewEntity;
import ua.lviv.iot.model.entity.SessionEntity;
import ua.lviv.iot.persistance.ConnectionManager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ReviewDaoImpl implements AbstractGenericDao<ReviewEntity> {
    @Override
    public List<ReviewEntity> findAll() {
        List<ReviewEntity> countries = new ArrayList<>();

        try (Session session = ConnectionManager.getSession()) {
            session.beginTransaction();
            countries = session.createQuery("from ReviewEntity").getResultList();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return countries;
    }

    @Override
    public ReviewEntity findOne(Integer id) {
        ReviewEntity country = null;

        try (Session session = ConnectionManager.getSession()) {
            session.beginTransaction();
            country = session.get(ReviewEntity.class, id);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return country;
    }


    @Override
    public void create(ReviewEntity country)  {
        try (Session session = ConnectionManager.getSession()) {
            session.beginTransaction();
            session.save(country);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Integer id,  ReviewEntity country)  {
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
            ReviewEntity country = session.get(ReviewEntity.class, id);
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
            List<ReviewEntity> all = findAll();
            List<ReviewEntity> cinemaEntityList = all.stream()
                    .filter(cinemaEntity -> cinemaEntity.getManEntity().getId().equals(country.getId()))
                    .collect(Collectors.toList());
            for (ReviewEntity cinema :
                    cinemaEntityList) {
                delete(cinema.getId());
            }
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
