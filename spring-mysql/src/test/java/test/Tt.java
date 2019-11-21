package test;

import java.math.BigDecimal;

import com.ytq.data.po.OrderPO;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

/**
 * @author yuantongqin
 * 2019/10/22
 */
public class Tt {

//    @Transactional
//    public int addOrderRecord(Order order) {
//        if(orderDao.selectOrderRecord(order)==null){
//            int result = orderDao.addOrderRecord(order);
//            if(result>0){
//                return 1;
//            }
//        }
//        return 0;
//    }

    @Test
    public void ss(){
        String s=null;
        BigDecimal min = new BigDecimal(10).min(new BigDecimal(9));
        System.out.println(min);

        ThreadLocal<OrderPO> local = new ThreadLocal<OrderPO>(){
            @Override
            protected OrderPO initialValue() {
                return new OrderPO();
            }
        };
    }

    @Test
    public void ssa(){
        String s = StringUtils.leftPad("2", 4, "00");
        System.out.println(s);
    }


}
