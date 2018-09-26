package com.super223.tasks;

import com.super223.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * @author superz
 */
@RestController
@RequestMapping("/admin")
public class UpdateTicketController {

    @Autowired
    private TicketService ticketService;

    @GetMapping("/updateTicket")
    public String  updateTicket(){
        try {
            ticketService.addTicket(1);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }
}
