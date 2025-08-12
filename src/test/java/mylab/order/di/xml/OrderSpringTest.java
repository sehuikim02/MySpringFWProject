package mylab.order.di.xml;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig
@ContextConfiguration(locations = "classpath:mylab-order-di.xml")
public class OrderSpringTest {

    @Autowired
    private ShoppingCart cart;

    @Autowired
    private OrderService service;

    @Test
    void testShoppingCart() {
        assertNotNull(cart, "ShoppingCart가 null입니다.");
        assertEquals(2, cart.getProducts().size(), "상품 개수가 일치하지 않습니다.");
        assertEquals("노트북", cart.getProducts().get(0).getName());
        assertEquals("스마트폰", cart.getProducts().get(1).getName());
    }

    @Test
    void testOrderService() {
        assertNotNull(service, "OrderService가 null입니다.");
        assertNotNull(service.getShoppingCart(), "ShoppingCart 주입 실패");
        assertEquals(950000, service.calculateOrderTotal(), 0.001);
    }
}
