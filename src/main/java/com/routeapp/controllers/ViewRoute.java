package com.routeapp.controllers;

import com.routeapp.entity.Route;
import com.routeapp.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.Base64;

@Controller
public class ViewRoute {
    private RouteService routeService;

    @Autowired
    public void setRouteService(RouteService routeService) {
        this.routeService = routeService;
    }

    @RequestMapping(value = "**/route/{id}", method = RequestMethod.GET)
    public String showRoute(@PathVariable Long id, Model model, Route route) throws IOException {
        model.addAttribute("car", routeService.getRouteById(id));
        return "viewroute";
    }
    }
