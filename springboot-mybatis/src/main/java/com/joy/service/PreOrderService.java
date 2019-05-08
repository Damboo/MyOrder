package com.joy.service;

import com.joy.constant.OrderConstant;
import com.joy.core.SafeKit;
import com.joy.dao.PreOrderDao;
import com.joy.dto.PreOrderAddDTO;
import com.joy.pojo.PreOrder;
import com.joy.util.DateUtil;
import com.joy.vo.BillInfoVO;
import com.joy.vo.OrderInfoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PreOrderService {

    @Autowired
    private PreOrderDao preOrderDao;

    /**
     * 对接收到的dto,进行存库
     *
     * @param preOrderAddDTO
     * @return
     */
    public Map<String, Object> createPreOrder(PreOrderAddDTO preOrderAddDTO) {
        Map<String, Object> map = new HashMap<>();
        //    首先校验出是否存在未支付的订单,如果存在则不生成(status未支付,delFlag为0)
        List<PreOrder> orderList = preOrderDao.getUserOrder(preOrderAddDTO.getUserCode(), preOrderAddDTO.getRoomCode());
        if (!orderList.isEmpty()) {
            map.put("isSuccess", false);
            map.put("errorMsg", "当前仍存在未支付的订单");
            return map;
        }
        //取出dto内的账单详情
        List<BillInfoVO> list = preOrderAddDTO.getBillDetailList();
        //对当前list进行遍历,校验金额是否一致
        Double orderMoney = preOrderAddDTO.getTotalMoney();
        Double detailTotalMoney = null;
        for (BillInfoVO billInfoVO : list) {
            if (null != billInfoVO) {
                detailTotalMoney += billInfoVO.getChargeMoney();
            }
        }
        if (!orderMoney.equals(detailTotalMoney)) {
            map.put("isSuccess", false);
            map.put("errorMsg", "订单金额和账单总金额不匹配");
            return map;
        }
        //生成一个订单号
        String billNo = DateUtil.getNowTime() + DateUtil.getRandomNum(3) + "A1";
        //对未支付订单进行二次校验
        List<PreOrder> orderList2 = preOrderDao.getUserOrder(preOrderAddDTO.getUserCode(), preOrderAddDTO.getRoomCode());
        if (!orderList2.isEmpty()) {
            map.put("isSuccess", false);
            map.put("errorMsg", "当前仍存在未支付的订单");
            return map;
        }
        Date date = new Date();
        //保存订单信息
        PreOrder preOrder = new PreOrder();
        preOrder.setBillNo(billNo);
        preOrder.setBillDate(date);
        preOrder.setUserCode(preOrderAddDTO.getUserCode());
        preOrder.setRoomCode(preOrderAddDTO.getRoomCode());
        preOrder.setBeginDate(preOrderAddDTO.getBeginDate());
        preOrder.setEndDate(preOrderAddDTO.getEndDate());
        preOrder.setTotalMoney(preOrderAddDTO.getTotalMoney());
        preOrder.setCreatedTime(date);
        preOrder.setDelFlag(0);
        //默认待支付
        preOrder.setStatusCode(OrderConstant.TOBEPAID_CODE);
        preOrder.setStatusName(OrderConstant.TOBEPAID_NAME);
        //默认预缴费
        preOrder.setBillType(OrderConstant.PREPAID);
        preOrder.setServerTime(date);
        preOrder.setUnionPayMoney(preOrderAddDTO.getTotalMoney());
        //保存账单信息
        for (BillInfoVO billInfoVO : list) {
            //自动装配然后循环保存
        }
        map.put("isSuccess", true);
        map.put("billNo", billNo);
        return map;
    }

    /**
     * 查询预缴费订单列表
     */
    public List<OrderInfoVO> getPreOrderList(String userCode, Integer orderStatus, Integer orderTime) {
        String preDate = "";
        if (null != orderTime) {
            preDate = DateUtil.getPreDateStr(orderTime);
        }
        //获取指定时间前的日期
        if (null == orderStatus) {
            return null != orderTime ? preOrderDao.getPreOrderList(userCode, preDate) : preOrderDao.getPreOrderList(userCode);
        } else {
            return null != orderTime ? preOrderDao.getPreOrderList(userCode, orderStatus, preDate) : preOrderDao.getPreOrderList(userCode, orderStatus);
        }
    }
}
