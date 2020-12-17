package course.project.demo.service.impl;

import course.project.demo.model.Orders;
import course.project.demo.repository.OrdersRepository;
import course.project.demo.service.OrdersService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdersServiceImpl implements OrdersService {

    private final OrdersRepository ordersRepository;

    public OrdersServiceImpl(OrdersRepository ordersRepository) {
        this.ordersRepository = ordersRepository;
    }

    @Override
    public Orders saveById(Orders orders) {
        return ordersRepository.save(orders);
    }

    @Override
    public List<Orders> getAllOrdersForAuthenticatedUser(Long id) {
        return ordersRepository.findAllByUser_Id(id);
    }

    @Override
    public void remove(Long id) {
        ordersRepository.deleteById(id);
    }
}
