package com.example.task3;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import com.example.task3.model.Order;
import com.example.task3.model.Status;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

@Component
class OrderModelAssembler implements RepresentationModelAssembler<Order, EntityModel<Order>> {

    @Override
    public EntityModel<Order> toModel(Order order) {
        
        EntityModel<Order> orderModel = EntityModel.of(order,
                linkTo(methodOn(OrderController.class).one((long) order.getId())).withSelfRel(),
                linkTo(methodOn(OrderController.class).all()).withRel("orders"));

        if (order.getStatus() == Status.IN_PROGRESS) {
            orderModel.add(linkTo(methodOn(OrderController.class).cancel((long) order.getId())).withRel("cancel"));
            orderModel.add(linkTo(methodOn(OrderController.class).complete((long) order.getId())).withRel("complete"));
        }

        return orderModel;
    }
}