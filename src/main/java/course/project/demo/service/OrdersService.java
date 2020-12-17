package course.project.demo.service;

import course.project.demo.model.Orders;

import java.util.List;

public interface OrdersService {

    Orders saveById(Orders orders);

    List<Orders> getAllOrdersForAuthenticatedUser(Long id);

    void remove(Long id);


}
