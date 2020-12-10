package ua.lviv.iot.controller.impl;

import ua.lviv.iot.controller.AbstractGenericController;
import ua.lviv.iot.model.dao.impl.CountryDaoImpl;
import ua.lviv.iot.model.entity.CountryEntity;

import java.util.List;

public class CountryController implements AbstractGenericController<CountryEntity> {

    CountryDaoImpl dao = new CountryDaoImpl();

    @Override
    public List<CountryEntity> findAll() {
        return dao.findAll();
    }

    @Override
    public CountryEntity findOne(Integer id) {
        return dao.findOne(id);
    }

    @Override
    public void create(CountryEntity entity) {
        dao.create(entity);
    }

    @Override
    public void update(Integer id, CountryEntity entity) {
        dao.update(id, entity);
    }

    @Override
    public void delete(Integer id) {
        dao.delete(id);

    }
}
