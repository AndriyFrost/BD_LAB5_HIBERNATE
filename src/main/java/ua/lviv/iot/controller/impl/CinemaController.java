package ua.lviv.iot.controller.impl;

import ua.lviv.iot.controller.AbstractGenericController;
import ua.lviv.iot.model.dao.impl.CinemaDaoImpl;
import ua.lviv.iot.model.entity.CinemaEntity;

import java.util.List;

public class CinemaController implements AbstractGenericController<CinemaEntity> {

    CinemaDaoImpl dao = new CinemaDaoImpl();

    @Override
    public List<CinemaEntity> findAll() {
        return dao.findAll();
    }

    @Override
    public CinemaEntity findOne(Integer id) {
        return dao.findOne(id);
    }

    @Override
    public void create(CinemaEntity entity) {
        dao.create(entity);
    }

    @Override
    public void update(Integer id, CinemaEntity entity) {
        dao.update(id, entity);
    }

    @Override
    public void delete(Integer id) {
        dao.delete(id);

    }
}
