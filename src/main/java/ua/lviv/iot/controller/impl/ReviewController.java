package ua.lviv.iot.controller.impl;

import ua.lviv.iot.controller.AbstractGenericController;
import ua.lviv.iot.model.dao.impl.ReviewDaoImpl;
import ua.lviv.iot.model.entity.ReviewEntity;

import java.util.List;

public class ReviewController implements AbstractGenericController<ReviewEntity> {


    ReviewDaoImpl dao = new ReviewDaoImpl();

    @Override
    public List<ReviewEntity> findAll()  {
        return dao.findAll();
    }

    @Override
    public ReviewEntity findOne(Integer id)  {
        return dao.findOne(id);
    }

    @Override
    public void create(ReviewEntity entity)  {
        dao.create(entity);
    }

    @Override
    public void update(Integer id, ReviewEntity entity)  {
        dao.update(id, entity);
    }

    @Override
    public void delete(Integer id) {
        dao.delete(id);

    }
}
