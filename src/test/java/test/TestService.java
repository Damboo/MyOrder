package test;

import com.alibaba.fastjson.JSON;
import com.joy.core.SafeKit;
import com.joy.dto.PreOrderAddDTO;
import com.joy.service.PreOrderService;
import com.joy.dto.BillInfoAddDTO;
import com.joy.vo.OrderInfoVO;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class TestService extends TmallApplicationTests {

    @Autowired
    private PreOrderService preOrderService;

    @Test
    public void testSaveOrder() {
        PreOrderAddDTO preOrderAddDTO = new PreOrderAddDTO();
        preOrderAddDTO.setBeginDate(new Date());
        preOrderAddDTO.setEndDate(new Date());
        preOrderAddDTO.setRoomCode("DHIUSAHFDKJSAFDSA");
        preOrderAddDTO.setTotalMoney(2861.00);
        preOrderAddDTO.setUserCode("4514574DSA54d567854");
        List<BillInfoAddDTO> list = new ArrayList<>();
        BillInfoAddDTO billInfoAddDTO = new BillInfoAddDTO();
        billInfoAddDTO.setPkChargeItem("DISAGKDGSAKDSAHGDI3213213");
        billInfoAddDTO.setChargeItem("物业服务费");
        billInfoAddDTO.setFeeType(0);
        billInfoAddDTO.setNprice(200.00);
        billInfoAddDTO.setAdvanceMoney(3060.00);
        billInfoAddDTO.setDiscountMoney(200.00);
        billInfoAddDTO.setDiscount(0.8);
        billInfoAddDTO.setChargeMoney(2860.00);
        billInfoAddDTO.setNcPkStd("H5J432KJ532IU4I32HI4");
        billInfoAddDTO.setNcPkDiscount("FHIU32FIU32874G");
        billInfoAddDTO.setDiscountName("空置房折扣");
        list.add(billInfoAddDTO);
        preOrderAddDTO.setBillDetailList(list);
        String billNo = "";
        String errorMsg = "";
        Map<String, Object> map = preOrderService.createPreOrder(preOrderAddDTO);
        if (map != null && !map.isEmpty()) {
            if (SafeKit.getBoolean(map.get("isSuccess"))) {
                billNo = SafeKit.getString(map.get("billNo"));
            } else {
                errorMsg = SafeKit.getString(map.get("errorMsg"));
            }
        }
        Assert.assertSame("保存预缴费订单失败", "订单金额和账单总金额不匹配", errorMsg);
    }

    @Test
    public void testGetPreOrderList() {
        List<OrderInfoVO> list = preOrderService.getPreOrderList("DJHSAHDKJWQ21321",0,3);
        System.out.println(JSON.toJSONString(list));
    }

}
