package com.karakatalmasova.orderservice.service;

import com.karakatalmasova.orderservice.dto.OrderLineItemsDto;
import com.karakatalmasova.orderservice.dto.OrderRequest;
import com.karakatalmasova.orderservice.model.Order;
import com.karakatalmasova.orderservice.model.OrderLineItems;
import com.karakatalmasova.orderservice.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional
public class OrderService {
    private final OrderRepository orderRepository;
    private final WebClient webClient;
    public void placeOrder(OrderRequest orderRequest){
        Order order = new Order();
        order.setOrderNumber(UUID.randomUUID().toString());

        List<OrderLineItems> orderLineItemsList=
                orderRequest.getOrderLineItemsDtoList().stream().map(this::mapToDto).toList();


        //        order.setOrderLineItemsList(orderLineItemsList);
        Boolean result = webClient.get().uri("http://localhost:8082/api/inventory").retrieve().bodyToMono(Boolean.class).block();
        if(result){
        orderRepository.save(order);}else{
            throw new IllegalArgumentException("Product is not in stock, please try again later");
        }
    }

    private OrderLineItems mapToDto(OrderLineItemsDto orderLineItemsDto) {
        OrderLineItems orderLineItems=new OrderLineItems();
        orderLineItems.setPrice(orderLineItemsDto.getPrice());
        orderLineItems.setQuantity(orderLineItems.getQuantity());
        orderLineItems.setSkuCode(orderLineItemsDto.getSkuCode());
        return orderLineItems;
    }
}
