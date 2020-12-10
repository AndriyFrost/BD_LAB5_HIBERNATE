package ua.lviv.iot.controller.impl;

import ua.lviv.iot.controller.AbstractGenericController;
import ua.lviv.iot.model.dao.impl.SessionDaoImpl;
import ua.lviv.iot.model.entity.SessionEntity;

import java.util.List;

public class SessionController implements AbstractGenericController<SessionEntity> {

    SessionDaoImpl dao = new SessionDaoImpl();

    @Override
    public List<SessionEntity> findAll() {
        return dao.findAll();
    }

    @Override
    public SessionEntity findOne(Integer id) {
        return dao.findOne(id);
    }

    @Override
    public void create(SessionEntity entity) {
        dao.create(entity);
    }

    @Override
    public void update(Integer id, SessionEntity entity) {
        dao.update(id, entity);
    }

    @Override
    public void delete(Integer id) {
        dao.delete(id);
    }
}
