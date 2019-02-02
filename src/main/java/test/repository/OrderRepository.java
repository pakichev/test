package test.repository;

import test.model.Order;

import java.time.LocalDateTime;
import java.util.List;

public interface OrderRepository {
    Order save(Order order);

    Order get(String num);

    List<Order> getAll();
}
