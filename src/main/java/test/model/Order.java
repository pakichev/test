package test.model;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@Component
public class Order extends AbstractBaseEntity {
    private String num;
    private LocalDateTime dateTime;

    public Order() {

    }

    public Order(String num) {
        this(null, num, LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS));
    }

    public Order(Integer id, String num, LocalDateTime dateTime) {
        super(id);
        this.num = num;
        this.dateTime = dateTime;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }
}
