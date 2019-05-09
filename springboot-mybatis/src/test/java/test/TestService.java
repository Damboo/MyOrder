package test;

import com.alibaba.fastjson.JSON;
import com.joy.core.SafeKit;
import com.joy.dto.PreOrderAddDTO;
import com.joy.service.PreOrderService;
import com.joy.vo.BillInfoVO;
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
        List<BillInfoVO> list = new ArrayList<>();
        BillInfoVO billInfoVO = new BillInfoVO();
        billInfoVO.setPkChargeItem("DISAGKDGSAKDSAHGDI3213213");
        billInfoVO.setChargeItem("物业服务费");
        billInfoVO.setFeeType(0);
        billInfoVO.setNprice(200.00);
        billInfoVO.setAdvanceMoney(3060.00);
        billInfoVO.setDiscountMoney(200.00);
        billInfoVO.setDiscount(0.8);
        billInfoVO.setChargeMoney(2860.00);
        billInfoVO.setNcPkStd("H5J432KJ532IU4I32HI4");
        billInfoVO.setNcPkDiscount("FHIU32FIU32874G");
        billInfoVO.setDiscountName("空置房折扣");
        list.add(billInfoVO);
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
