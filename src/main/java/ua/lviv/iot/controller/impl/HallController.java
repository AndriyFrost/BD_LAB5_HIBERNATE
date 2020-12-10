package ua.lviv.iot.controller.impl;

import ua.lviv.iot.controller.AbstractGenericController;
import ua.lviv.iot.model.dao.impl.HallDaoImpl;
import ua.lviv.iot.model.entity.HallEntity;

import java.util.List;

public class HallController implements AbstractGenericController<HallEntity> {

    HallDaoImpl dao = new HallDaoImpl();

    @Override
    public List<HallEntity> findAll() {
        return dao.findAll();
    }

    @Override
    public HallEntity findOne(Integer id) {
        return dao.findOne(id);
    }

    @Override
    public void create(HallEntity entity) {
        dao.create(entity);
    }

    @Override
    public void update(Integer id, HallEntity entity) {
        dao.update(id, entity);
    }

    @Override
    public void delete(Integer id) {
        dao.delete(id);

    }

}
