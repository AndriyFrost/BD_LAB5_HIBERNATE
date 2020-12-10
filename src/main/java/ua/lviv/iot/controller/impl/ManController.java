package ua.lviv.iot.controller.impl;

import ua.lviv.iot.controller.AbstractGenericController;
import ua.lviv.iot.model.dao.impl.ManDaoImpl;
import ua.lviv.iot.model.entity.ManEntity;

import java.util.List;

public class ManController implements AbstractGenericController<ManEntity> {

    ManDaoImpl dao = new ManDaoImpl();

    @Override
    public List<ManEntity> findAll() {
        return dao.findAll();
    }

    @Override
    public ManEntity findOne(Integer id) {
        return dao.findOne(id);
    }

    @Override
    public void create(ManEntity entity) {
        dao.create(entity);
    }

    @Override
    public void update(Integer id, ManEntity entity) {
        dao.update(id, entity);
    }

    @Override
    public void delete(Integer id) {
        dao.delete(id);

    }
}
