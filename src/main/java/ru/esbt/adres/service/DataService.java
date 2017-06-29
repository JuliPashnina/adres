package ru.esbt.adres.service;

import java.util.Set;

/**
 *
 * @author Y.Pashnina
 */
public interface DataService {

    public boolean persist(String problem);

    public Set<String> getRandomData();
}