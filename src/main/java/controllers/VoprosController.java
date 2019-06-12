package controllers;


import com.example.demo.models.Vopros;
import com.example.demo.repository.VoprosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class VoprosController {

    @Autowired
    private VoprosRepository voprosRepository;
    @RequestMapping(value="/vopros/create", method = RequestMethod.GET)
    public ModelAndView voproSehen(){
        ModelAndView modelAndView = new ModelAndView();
        Vopros vopros=new Vopros();
        modelAndView.addObject("vopros", vopros);
        modelAndView.addObject("listVopros", voprosRepository.findAll());
        modelAndView.setViewName("vopros/create");
        return  modelAndView;
    }
    @RequestMapping(value = "vopros/create", method = RequestMethod.POST)
    public ModelAndView voprosCreate(@Valid Vopros vopros,BindingResult bindingResult){
        ModelAndView modelAndView=new ModelAndView();
        try { if (bindingResult.hasErrors()){
            modelAndView.setViewName("vopros/create");
        }else{
            voprosRepository.save(vopros);
            modelAndView.setViewName("redirect:/vopros/index");
        }
            return modelAndView;

        }catch (Exception exp){
            modelAndView.addObject("Error", exp.getMessage());
            modelAndView.addObject("vopros", vopros);
            modelAndView.setViewName("vopros/create");
            return  modelAndView;
        }

    }

    @RequestMapping(value={"vopros/index"}, method = RequestMethod.GET)
    public ModelAndView Index(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("vopros", voprosRepository.findAll());
        modelAndView.setViewName("vopros/index");
        return modelAndView;
    }



}
