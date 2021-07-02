package com.testing.demo.Controller;

import com.stripe.exception.StripeException;
import com.stripe.model.Charge;
import com.testing.demo.Model.Request.ChargeRequest;
import com.testing.demo.Service.StripePaymentService.StripeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("api/v1")
public class ChargeController {

    @Autowired
    StripeService paymentsService;

    @PostMapping("/charge1")
    public String charge(ChargeRequest chargeRequest, Model model) throws Exception {
        chargeRequest.setDescription("Example charge");
        chargeRequest.setCurrency(ChargeRequest.Currency.EUR);
        Charge charge = paymentsService.charge(chargeRequest);
        model.addAttribute("id", ((Charge) charge).getId());
        model.addAttribute("status", charge.getStatus());
        model.addAttribute("chargeId", charge.getId());
        model.addAttribute("balance_transaction", charge.getBalanceTransaction());
        return "result";
    }

    @PostMapping("/charge")
    public String chargeCard(@RequestHeader(value="token") String token, @RequestHeader(value="amount") Double amount) throws Exception {
        System.out.println(token);
        System.out.println(amount);
        Charge charge = paymentsService.chargeNewCard(token, amount);
        return "charge";
    }

    @ExceptionHandler(StripeException.class)
    public String handleError(Model model, StripeException ex) {
        model.addAttribute("error", ex.getMessage());
        return "result";
    }

}
