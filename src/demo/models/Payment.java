package demo.models;

import demo.models.enums.PaymentMode;
import demo.models.enums.PaymentStatus;

public class Payment extends BaseModel{
	private PaymentMode paymentMode;
	private PaymentStatus paymentStatus;
	private Bill bill;
}
