package glg203.jpa.control;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import glg203.jpa.control.form.ProfForm;
import glg203.jpa.service.ProfService;

/**
 * CreerProfController
 */
@Controller
@RequestMapping("/prof/creer")
public class CreerProfController {    
    private ProfService profService;

    public CreerProfController(ProfService profService) {
        this.profService = profService;
    }
    @GetMapping
    public String get(Model model) {
        model.addAttribute(new ProfForm());
        return "prof/form";
    }

    @PostMapping
    public String post(ProfForm form, 
        Model model) {
        // Nous laissons les vérifications comme exercice au lecteur
        // intéressé.
        profService.creerProf(form.getNom(), form.getPrenom());
        return "redirect:/prof";
    }
    
}