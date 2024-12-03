package fr.baretto.tp3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Restaurant implements Subscriber {
    private String name;
    private EventBus eventBus;
    private List<Order> orders = new ArrayList<>();

    public Restaurant(String name, EventBus eventBus) {
        this.name = name;
        this.eventBus = eventBus;
    }

    public String getName() {
        return name;
    }

    public Order prepareOrder(List<Dish> dishes, double price, String deliveryPlace, Customer customer) throws InterruptedException, OrderPreparationException {
        Thread.sleep(new Random().nextInt(3000));

        Map<Dish, Integer> dishesMap = new HashMap<>();
        for(Dish dish : dishes){
            dishesMap.merge(dish, 1, Integer::sum);
        }

        Order order = new Order(this, dishesMap, price, deliveryPlace, customer);

        Double random = Math.random();
        if(random < 0.2){
            try {
                throw new OrderPreparationException("Kohaku(mon chat, le loukoum) a décidé que l'order ne passerait pas AHAHAHAHAHAHAH");
            } catch (OrderPreparationException e) {
                System.out.println(e.getMessage());
                ErrorManagementService.exceptions.add(e);
            }
            return null;
        }

        orders.add(order);
        OrderEvent orderEvent = new OrderEvent(order);

        this.eventBus.handleEvent(EventType.ORDER_PREPARED, orderEvent);

        return order;
    }


    @Override
    public void handleEvent(Event event) throws InterruptedException {
        if(event instanceof DeliveryEvent) {

            DeliveryEvent deliveryEvent = ((DeliveryEvent) event);
            Logger logger = Logger.getInstance();
            if (orders.contains(deliveryEvent.getOrder())) {
                if (deliveryEvent.getDeliveryStatus() == DeliveryStatus.IN_DELIVERY) {
                    logger.addLog("["+ name +"] Livraisons de la commande à " + deliveryEvent.getOrder().getDeliveryPlace() + "...");
                    NotificationService.sendNotification("["+deliveryEvent.getOrder().getCustomer().getLastname()+"] Livraisons de votre commande à " + deliveryEvent.getOrder().getDeliveryPlace() + "...");
                } else if (deliveryEvent.getDeliveryStatus() == DeliveryStatus.DELIVERED) {
                    logger.addLog("Commande livrée, vous devez payer " + deliveryEvent.getOrder().getPrice() + " sivouplé.");
                    NotificationService.sendNotification("["+deliveryEvent.getOrder().getCustomer().getLastname()+"] Commande livrée, vous devez payer " + deliveryEvent.getOrder().getPrice() + " sivouplé.");
                    orders.remove(deliveryEvent.getOrder());
                }
            }
        }
    }
}
