package course.project.demo.service;

import course.project.demo.model.Flat;

import java.util.List;
import java.util.Optional;

public interface FlatService {

    List<Flat> getAll();

    Optional<Flat> findById(Long id);

    Flat saveFlat(Flat flat);

    void deleteFlatById(Long id);

    List<Flat> getSortedFlatByPrice();

    List<Flat> findAllBtStreet(String street);

}
