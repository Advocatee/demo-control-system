package course.project.demo.repository;

import course.project.demo.model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface OrdersRepository extends JpaRepository<Orders, Long> {

    List<Orders> findAllByUser_Id(Long ida);

}
