package ru.esbt.adres.repository;

import java.util.Set;
import ru.esbt.adres.entity.DomainObject;

/**
 *
 * @author Y.Pashnina
 */
public interface DataRepository<V extends DomainObject> {

    void persist(V object);

    void delete(V object);

    Set<String> getRandomData();

}