package com.nihatalim.millipiyango.api.controllers;

import com.nihatalim.millipiyango.api.business.Facade;
import com.nihatalim.millipiyango.api.models.Loto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "loto")
public class LotoController {

    @Autowired
    private Facade facade;

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public Loto get(@RequestParam(value = "type", required = true) Loto.LotoType type, @RequestParam(value = "date", required = true) String date){
        return this.facade.lookup(type, date);
    }

}
