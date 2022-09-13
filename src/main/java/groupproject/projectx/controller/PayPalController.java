package groupproject.projectx.controller;

import com.paypal.api.payments.Links;
import com.paypal.api.payments.Payment;
import com.paypal.base.rest.PayPalRESTException;
import groupproject.projectx.services.PayPalService;
import groupproject.projectx.dtos.PaypalOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/payment")
public class PayPalController {

    @Autowired
    private PayPalService service;

    public static final String BASE_URL = "http://localhost:8080/api/v1/payment";
    public static final String SUCCESS_URL = BASE_URL + "/execute";
    public static final String CANCEL_URL = BASE_URL + "/cancel";
    public static final String ERROR_URL = BASE_URL + "/error";


    @PostMapping("/create")
    public String payment(@RequestBody PaypalOrder paypalOrderModel) {
        try {
            Payment payment = service.createPayment(paypalOrderModel.getTotalAmount(), paypalOrderModel.getDescription(), CANCEL_URL,
                    SUCCESS_URL);
            for (Links link : payment.getLinks()) {
                if (link.getRel().equals("approval_url")) {
                    paypalOrderModel.setLinkPaypal(link.getHref());
                    System.out.println(payment.toJSON());
                    System.out.println(payment.getId());
                    return paypalOrderModel.getLinkPaypal();
                }
            }
        } catch (PayPalRESTException e) {
            e.printStackTrace();
        }
        paypalOrderModel.setLinkPaypal(ERROR_URL);
        return paypalOrderModel.getLinkPaypal();
    }

    @GetMapping("/execute")
    public String successPay(@RequestParam("paymentId") String PAYID, @RequestParam("PayerID") String payerId) {
        try {
            Payment payment = service.executePayment(PAYID, payerId);
            System.out.println(payment.toJSON());
            if (payment.getState().equals("approved")) {
                return "success";
            }
        } catch (PayPalRESTException e) {
            System.out.println(e.getMessage());
        }
        return "redirect:/";
    }
}
