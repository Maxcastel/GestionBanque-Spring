package com.gestionbanque.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.gestionbanque.entities.Compte;
import com.gestionbanque.entities.Operation;
import com.gestionbanque.metier.IBanqueMetier;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class BanqueController {
	
	@Autowired
    private IBanqueMetier banqueMetier;

    @Autowired
    private HttpServletRequest request;

    @RequestMapping("/operations")
    public String index(){
        return "comptes";
    }
    @RequestMapping("/consulterCompte")
    public String consulterCompte(Model model, String codeCompte, @RequestParam(name="page", defaultValue="0") int page, @RequestParam(name="size", defaultValue="4") int size){
        try{
            Compte compte = banqueMetier.consulterCompte(codeCompte);

            Page<Operation> pageOperations = banqueMetier.listOperation(codeCompte, page, size);
            model.addAttribute("listeOperations", pageOperations.getContent());

            int [] pages = new int[pageOperations.getTotalPages()];
            model.addAttribute("pages", pages);

            model.addAttribute("compte", compte);
        }
        catch (Exception e){
            model.addAttribute("exception", e.getMessage());
        }

        model.addAttribute("codeCompte", codeCompte);
        
        return "comptes";
    }

    @RequestMapping(value = "/enregistrerOperation", method = RequestMethod.POST)
    public String enregistrerOperation(Model model, String typeOperation, String codeCompte, double montant, String codeCompte2){
        try {
            if(typeOperation.equals("VERS")){
                banqueMetier.verser(codeCompte, montant);
            }
            if(typeOperation.equals("RET")){
                banqueMetier.retirer(codeCompte, montant);
            }
            if(typeOperation.equals("VIR")){
                banqueMetier.virement(codeCompte, codeCompte2, montant);
            }
        }
        catch (Exception e) {
            model.addAttribute("error", e);
            return "redirect:consulterCompte?codeCompte="+codeCompte+"&error="+e.getMessage();
        }
        return "redirect:consulterCompte?codeCompte="+codeCompte;
    }
}
