package com.joy.service;

import com.joy.constant.OrderConstant;
import com.joy.core.BeanMapper;
import com.joy.dao.BillInfoDao;
import com.joy.dao.PreOrderDao;
import com.joy.dto.PreOrderAddDTO;
import com.joy.pojo.BillInfo;
import com.joy.pojo.PreOrder;
import com.joy.util.DateUtil;
import com.joy.dto.BillInfoAddDTO;
import com.joy.vo.OrderInfoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PreOrderService {

    @Autowired
    private PreOrderDao preOrderDao;
    @Autowired
    private BillInfoDao billInfoDao;

    /**
     * 对接收到的dto,进行存库
     *
     * @param preOrderAddDTO
     * @return
     */
    public Map<String, Object> createPreOrder(PreOrderAddDTO preOrderAddDTO) {
        Map<String, Object> map = new HashMap<>();
        //首先校验出是否存在未支付的订单,如果存在则不生成(status未支付,delFlag为0)
        List<PreOrder> orderList = preOrderDao.getUserOrder(preOrderAddDTO.getUserCode(), preOrderAddDTO.getRoomCode());
        if (!orderList.isEmpty()) {
            map.put("isSuccess", false);
            map.put("errorMsg", "当前仍存在未支付的订单");
            return map;
        }
        //取出dto内的账单详情
        List<BillInfoAddDTO> list = preOrderAddDTO.getBillDetailList();
        //对当前list进行遍历,校验金额是否一致
        Double orderMoney = preOrderAddDTO.getTotalMoney();
        Double detailTotalMoney = 0.0;
        if (!list.isEmpty()) {
            for (BillInfoAddDTO billInfoAddDTO : list) {
                if (null != billInfoAddDTO) {
                    detailTotalMoney += billInfoAddDTO.getChargeMoney();
                }
            }
        } else {
            map.put("isSuccess", false);
            map.put("errorMsg", "订单下的账单为空");
            return map;
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
        PreOrder preOrder = BeanMapper.map(preOrderAddDTO, PreOrder.class);
        preOrder.setBillNo(billNo);
        preOrder.setBillDate(date);
        //默认预缴费
        preOrder.setBillType(OrderConstant.PREPAID_CODE);
        //默认待支付
        preOrder.setStatusCode(OrderConstant.TOBEPAID_CODE);
        preOrder.setCreatedTime(date);
        preOrder.setDelFlag(0);
        preOrderDao.save(preOrder);
        //保存账单信息
        for (BillInfoAddDTO billInfoAddDTO : list) {
            //自动装配然后循环保存
            BillInfo billInfo = BeanMapper.map(billInfoAddDTO, BillInfo.class);
            billInfoDao.save(billInfo);
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
            return null != orderTime ? preOrderDao.getPreOrderList3(userCode, preDate) : preOrderDao.getPreOrderList4(userCode);
        } else {
            return null != orderTime ? preOrderDao.getPreOrderList1(userCode, orderStatus, preDate) : preOrderDao.getPreOrderList2(userCode, orderStatus);
        }
    }
}
