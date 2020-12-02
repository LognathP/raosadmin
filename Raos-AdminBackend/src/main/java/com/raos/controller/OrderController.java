package com.raos.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.raos.business.OrderBusiness;
import com.raos.logger.CommonLogger;
import com.raos.request.OrderFilter;

@RestController
public class OrderController {
	
private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
	

	@Autowired
	CommonLogger Logger;
	
	@Autowired
	OrderBusiness orderBusiness;

	@PostMapping("/api/order/updateOrder")
	public Object updateOrderStatus(int order_id,int order_status) {
		Logger.info(this.getClass(),"UPDATE ORDER API CALL STARTED AT "+dateFormat.format(new Date()));
		return orderBusiness.updateOrderStatus(order_id,order_status);
	}
	
	@PostMapping("/api/order/getOrderDetails")
	public Object getOrderDetails(@RequestBody OrderFilter orderFilter) {
		Logger.info(this.getClass(),"GET ORDER DETAILS API CALL STARTED AT "+dateFormat.format(new Date()));
		return orderBusiness.getOrderDetails(orderFilter);
	}
	
	


	
}
