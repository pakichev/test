package test.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import test.model.Order;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public class OrderRepositoryImpl implements OrderRepository {
    private static final RowMapper<Order> ROW_MAPPER = BeanPropertyRowMapper.newInstance(Order.class);

    private final JdbcTemplate jdbcTemplate;
    private final SimpleJdbcInsert insertOrder;
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    public OrderRepositoryImpl(JdbcTemplate jdbcTemplate, NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.insertOrder = new SimpleJdbcInsert(jdbcTemplate)
                .withTableName("orders")
                .usingGeneratedKeyColumns("id");
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }


    @Override
    @Transactional
    public Order save(Order order) {
        MapSqlParameterSource map = new MapSqlParameterSource()
                .addValue("id", order.getId())
                .addValue("num", order.getNum())
                .addValue("date_time", order.getDateTime());

        if (order.isNew()) {
            Number newId = insertOrder.executeAndReturnKey(map);
            order.setId(newId.intValue());
        } else {
            if (namedParameterJdbcTemplate.update("" +
                            "UPDATE orders " +
                            "   SET num=:num, calories=:calories, date_time=:date_time " +
                            " WHERE id=:id"
                    , map) == 0) {
                return null;
            }
        }
        return order;
    }

    @Override
    public Order get(String num) {
        List<Order> order = jdbcTemplate.query(
                "SELECT * FROM orders WHERE num = ?", ROW_MAPPER, num);
        return DataAccessUtils.singleResult(order);
    }

    @Override
    public List<Order> getAll() {
        return jdbcTemplate.query(
                "SELECT * FROM orders ORDER BY date_time DESC", ROW_MAPPER);
    }

}
