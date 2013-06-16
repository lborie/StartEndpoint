package net.kanithael.startendpoint.dao;

import com.googlecode.objectify.ObjectifyService;

import java.util.List;

import static com.googlecode.objectify.ObjectifyService.ofy;

/**
 * Generic DAO for CRUD Operations
 * @param <T> must be an Entity Objectify
 */
public class GenericDao<T> {

    final Class<T> typeParameterClass;

    public GenericDao(Class<T> typeParameterClass) {
        this.typeParameterClass = typeParameterClass;
        ObjectifyService.register(typeParameterClass);
    }

    /**
     * return the entire list of Entity
     */
    public List<T> getTasks() {
        return ofy().load().type(this.typeParameterClass).list();
    }

    /**
     * Insert one Entity
     */
    public void insertTask(T object) {
        ofy().save().entity(object);
    }

}
