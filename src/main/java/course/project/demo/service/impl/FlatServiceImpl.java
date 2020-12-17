package course.project.demo.service.impl;

import course.project.demo.model.Flat;
import course.project.demo.repository.FlatRepository;
import course.project.demo.service.FlatService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class FlatServiceImpl implements FlatService {

    private final FlatRepository repository;

    public FlatServiceImpl(FlatRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Flat> getAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Flat> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Flat saveFlat(Flat flat) {
        return repository.save(flat);
    }

    @Override
    public void deleteFlatById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public List<Flat> getSortedFlatByPrice() {
        return repository.getSortFlatByPrice();
    }

    @Override
    public List<Flat> findAllBtStreet(String street) {
        return repository.findAllByStreet(street);
    }


}
