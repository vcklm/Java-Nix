package services;

import com_nix_ragency.models.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com_nix_ragency.repositories.IOrderRepository;

import java.util.List;

@Service
public class OrderService{
    private final IOrderRepository orderRepository;

    @Autowired
    public OrderService(IOrderRepository orderRepository){
        this.orderRepository=orderRepository;
    }
    public Order getById(Long id){
        return orderRepository.getById(id);
    }
    public List<Order> findAll(){
        return orderRepository.findAll();
    }
    public Order saveClient(Order client){
        return orderRepository.save(client);
    }
    public void deleteById(Long id){
        orderRepository.deleteById(id);
    }
}