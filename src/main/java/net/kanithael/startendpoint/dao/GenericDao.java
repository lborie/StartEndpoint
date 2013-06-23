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
    public List<T> getEntities() {
        return ofy().load().type(this.typeParameterClass).list();
    }

    /**
     * Insert one Entity
     * Synchronous insert to get the ID
     * @param object entity to save
     */
    public void insertEntity(T object) {
        ofy().save().entity(object).now();
    }

    /**
     * Delete one entity
     * @param id the id Entity to delete
     */
    public void deleteEntity(Long id) {
        ofy().delete().type(this.typeParameterClass).id(id);
    }

}
