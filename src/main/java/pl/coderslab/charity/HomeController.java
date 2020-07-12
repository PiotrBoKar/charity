package pl.coderslab.charity;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.donation.DonationRepository;
import pl.coderslab.charity.institution.InstitutionDao;
import pl.coderslab.charity.institution.InstitutionRepository;



@Controller
public class HomeController {
    @Autowired
    DonationRepository donationRepository;
    @Autowired
    InstitutionRepository institutionRepository;
    private final InstitutionDao institutionDao;

    public HomeController(InstitutionDao institutionDao) {
        this.institutionDao = institutionDao;

    }

    @RequestMapping("/")
    public String homeAction(Model model) {
        model.addAttribute("institution", institutionRepository.findAll());
        model.addAttribute("donations", donationRepository.count());
        model.addAttribute("sum", donationRepository.selectTotals());
        return "index";
    }




}
