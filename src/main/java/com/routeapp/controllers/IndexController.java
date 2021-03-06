package com.routeapp.controllers;

import com.routeapp.entity.Route;
import com.routeapp.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {

    private RouteService routeService;

    @Autowired
    public void setRouteService(RouteService routeService) {
        this.routeService = routeService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String sortDate(Model model, Pageable pageable) {
        model.addAttribute("title", "Cars Catalog");
        Page<Route> carsPage = routeService.findAllByOrderByDateDesc(pageable);
        PageWrapper<Route> page = new PageWrapper<Route>(carsPage, "/");
        model.addAttribute("car", carsPage.getContent());
        model.addAttribute("page", page);
        return "index";
    }

    @RequestMapping(value = "/sort/mark", method = RequestMethod.GET)
    public String sortMark(Model model, Pageable pageable) {
        model.addAttribute("title", "Cars Catalog");
        Page<Route> carsPage = routeService.findAllByOrderByMarkAsc(pageable);
        PageWrapper<Route> page = new PageWrapper<Route>(carsPage, "/sort/mark");
        model.addAttribute("car", carsPage.getContent());
        model.addAttribute("page", page);
        return "index";
    }

    @RequestMapping(value = "/sort/scope", method = RequestMethod.GET)
    public String sortScope(Model model, Pageable pageable) {
        model.addAttribute("title", "Cars Catalog");
        Page<Route> carsPage = routeService.findAllByOrderByScopeAsc(pageable);
        PageWrapper<Route> page = new PageWrapper<Route>(carsPage, "/sort/scope");
        model.addAttribute("car", carsPage.getContent());
        model.addAttribute("page", page);
        return "index";
    }

    @RequestMapping(value = "/sort/year", method = RequestMethod.GET)
    public String sortYear(Model model, Pageable pageable) {
        model.addAttribute("title", "Cars Catalog");
        Page<Route> carsPage = routeService.findAllByOrderByYearAsc(pageable);
        PageWrapper<Route> page = new PageWrapper<Route>(carsPage, "/sort/year");
        model.addAttribute("car", carsPage.getContent());
        model.addAttribute("page", page);
        return "index";
    }

    @RequestMapping(value = "/sort/mileage", method = RequestMethod.GET)
    public String sortMileage(Model model, Pageable pageable) {
        model.addAttribute("title", "Cars Catalog");
        Page<Route> carsPage = routeService.findAllByOrderByMileageAsc(pageable);
        PageWrapper<Route> page = new PageWrapper<Route>(carsPage, "/sort/mileage");
        model.addAttribute("car", carsPage.getContent());
        model.addAttribute("page", page);
        return "index";
    }

    @RequestMapping(value = "/sort/price", method = RequestMethod.GET)
    public String sortPrice(Model model, Pageable pageable) {
        model.addAttribute("title", "Cars Catalog");
        Page<Route> carsPage = routeService.findAllByOrderByPriceAsc(pageable);
        PageWrapper<Route> page = new PageWrapper<Route>(carsPage, "/sort/price");
        model.addAttribute("car", carsPage.getContent());
        model.addAttribute("page", page);
        return "index";
    }

    @RequestMapping(value = "/mark/{mark}", method = RequestMethod.GET)
    public String filterMark(@PathVariable String mark, Model model, Pageable pageable) {
        model.addAttribute("title", "Cars Catalog");
        Page<Route> carsPage = routeService.findAllByMark(mark, pageable);
        PageWrapper<Route> page = new PageWrapper<Route>(carsPage, "/mark/{mark}");
        model.addAttribute("car", carsPage.getContent());
        model.addAttribute("page", page);
        return "index";
    }

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public ModelAndView search(@RequestParam(value = "q", required = false) String search,
                               Pageable pageable, ModelAndView modelAndView) {
        modelAndView.addObject("title", "Cars Catalog");
        Page<Route> carsPage = routeService.findBy(search, pageable);
        PageWrapper<Route> page = new PageWrapper<Route>(carsPage, "/**");
        modelAndView.addObject("car", carsPage.getContent());
        modelAndView.addObject("page", page);
        modelAndView.setViewName("index");
        return modelAndView;
    }

    @RequestMapping("/car/new")
    public String newCar(Model model) {
        model.addAttribute("car", new Route());
        return "editroute";
    }
}
