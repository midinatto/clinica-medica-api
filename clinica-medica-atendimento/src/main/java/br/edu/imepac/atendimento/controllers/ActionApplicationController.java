package br.edu.imepac.atendimento.controllers;

import br.edu.imepac.central.services.ActionsApplicationService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/actions-application")
public class ActionApplicationController {

    private final ActionsApplicationService actionsApplicationService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<String> getActionsApplication() {
        return actionsApplicationService.getActionsApplication();
    }

}
