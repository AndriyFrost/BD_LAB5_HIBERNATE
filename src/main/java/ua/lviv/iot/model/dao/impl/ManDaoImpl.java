package ua.lviv.iot.model.dao.impl;

import org.hibernate.Session;
import ua.lviv.iot.model.dao.AbstractGenericDao;
import ua.lviv.iot.model.entity.CountryEntity;
import ua.lviv.iot.model.entity.ManEntity;
import ua.lviv.iot.persistance.ConnectionManager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ManDaoImpl implements AbstractGenericDao<ManEntity> {
    ReviewDaoImpl reviewDao = new ReviewDaoImpl();
    ActorDaoImpl actorDao = new ActorDaoImpl();
    @Override
    public List<ManEntity> findAll() {
        List<ManEntity> countries = new ArrayList<>();

        try (Session session = ConnectionManager.getSession()) {
            session.beginTransaction();
            countries = session.createQuery("from ManEntity").getResultList();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return countries;
    }

    @Override
    public ManEntity findOne(Integer id) {
        ManEntity country = null;

        try (Session session = ConnectionManager.getSession()) {
            session.beginTransaction();
            country = session.get(ManEntity.class, id);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return country;
    }


    @Override
    public void create(ManEntity country)  {
        try (Session session = ConnectionManager.getSession()) {
            session.beginTransaction();
            session.save(country);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Integer id,  ManEntity country)  {
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
            ManEntity country = session.get(ManEntity.class, id);
            if (country != null) {
                reviewDao.deleteWithMan(country);
                actorDao.deleteWithMan(country);

                session.delete(country);
            }
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
