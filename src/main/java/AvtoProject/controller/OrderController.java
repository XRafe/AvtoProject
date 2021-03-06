package AvtoProject.controller;

import AvtoProject.dto.Order.OrderCreateDto;
import AvtoProject.dto.Order.OrderDto;
import AvtoProject.service.OrderService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
@CrossOrigin(origins = "http://localhost:4200")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public List<OrderDto> getList() {
        return orderService.getList();
    }

    @PostMapping
    public OrderDto createOrder(@RequestBody OrderCreateDto orderCreateDto) {
        return orderService.createOrder(orderCreateDto);
    }
}
