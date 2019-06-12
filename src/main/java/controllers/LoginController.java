package controllers;

import com.example.demo.configuration.UserRepositoryCommandLineRunner;
import com.example.demo.repository.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {
    private static final Logger log = LoggerFactory.getLogger(UserRepositoryCommandLineRunner.class);


    @Autowired
    private ProductRepository productRepository;

    @RequestMapping(value = {"/login"}, method = RequestMethod.GET)
    public ModelAndView login() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");
        return modelAndView;
    }

    @RequestMapping(value = {"/"}, method = RequestMethod.GET)
    public ModelAndView welcome() {
        log.info("Called Welcome method");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("prods", productRepository.findAll());
        modelAndView.addObject("titles", "");
        modelAndView.setViewName("welcome");
        return modelAndView;
    }

    @RequestMapping(value = {"/vhod"}, method = RequestMethod.GET)
    public ModelAndView vhod() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("vhod");
        return modelAndView;
    }

    @RequestMapping(value = {"/vhod1"}, method = RequestMethod.GET)
    public ModelAndView vhod1() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("vhod1");
        return modelAndView;
    }
    @RequestMapping(value = {"/index"}, method = RequestMethod.GET)
    public ModelAndView indexNoo() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        return modelAndView;
    }
    @RequestMapping(value = {"/registration"}, method = RequestMethod.GET)
    public ModelAndView registration() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("registration");
        return modelAndView;
    }


}