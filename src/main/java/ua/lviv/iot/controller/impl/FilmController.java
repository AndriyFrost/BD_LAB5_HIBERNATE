package ua.lviv.iot.controller.impl;

import ua.lviv.iot.controller.AbstractGenericController;
import ua.lviv.iot.model.dao.impl.FilmDaoImpl;
import ua.lviv.iot.model.entity.FilmEntity;

import java.util.List;

public class FilmController implements AbstractGenericController<FilmEntity> {

    FilmDaoImpl dao = new FilmDaoImpl();

    @Override
    public List<FilmEntity> findAll() {
        return dao.findAll();
    }

    @Override
    public FilmEntity findOne(Integer id) {
        return dao.findOne(id);
    }

    @Override
    public void create(FilmEntity entity) {
        dao.create(entity);
    }

    @Override
    public void update(Integer id, FilmEntity entity) {
        dao.update(id, entity);
    }

    @Override
    public void delete(Integer id) {
        dao.delete(id);

    }
}
