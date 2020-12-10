package ua.lviv.iot.controller.impl;

import ua.lviv.iot.controller.AbstractGenericController;
import ua.lviv.iot.model.dao.impl.ActorDaoImpl;
import ua.lviv.iot.model.entity.ActorEntity;

import java.util.List;

public class ActorController implements AbstractGenericController<ActorEntity> {


    ActorDaoImpl dao = new ActorDaoImpl();

    @Override
    public List<ActorEntity> findAll() {
        return dao.findAll();
    }

    @Override
    public ActorEntity findOne(Integer id) {
        return dao.findOne(id);
    }

    @Override
    public void create(ActorEntity entity) {
        dao.create(entity);
    }

    @Override
    public void update(Integer id, ActorEntity entity) {
        dao.update(id, entity);
    }

    @Override
    public void delete(Integer id) {
        dao.delete(id);
    }
}
