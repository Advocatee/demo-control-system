package course.project.demo.repository;

import course.project.demo.model.Flat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FlatRepository extends JpaRepository<Flat, Long> {

    @Query(value = "select * from flat inner join year on flat.id= year.id order by flat.price_in_month", nativeQuery = true)
    List<Flat> getSortFlatByPrice();

    List<Flat> findAllByStreet(String street);

}
