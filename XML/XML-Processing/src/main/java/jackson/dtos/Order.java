package jackson.dtos;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.math.BigDecimal;

@JacksonXmlRootElement(localName = "order")
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class Order {
    @JacksonXmlProperty(localName = "product")
    private Product item;
    @JacksonXmlProperty(localName = "amount")
    private int count;
    @JacksonXmlProperty(localName = "total", isAttribute = true)
    private BigDecimal totalPrice;

    public Order(Product item, int count, BigDecimal totalPrice) {
        this.item = item;
        this.count = count;
        this.totalPrice = totalPrice;
    }
}
