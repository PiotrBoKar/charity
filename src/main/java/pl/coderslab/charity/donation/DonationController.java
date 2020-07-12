package pl.coderslab.charity.donation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.charity.category.Category;
import pl.coderslab.charity.category.CategoryDao;
import pl.coderslab.charity.category.CategoryRepository;

import java.util.List;

@Controller
@RequestMapping("/donation")
public class DonationController {

    @Autowired
    DonationRepository donationRepository;
    @Autowired
    CategoryRepository categoryRepository;
    private final DonationDao donationDao;
//    private final CategoryDao categoryDao;
    public DonationController(DonationDao donationDao){
        this.donationDao=donationDao;
//        this.categoryDao=categoryDao;
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String getForm(Model model) {
        model.addAttribute("donationAdd", new Donation());
        model.addAttribute("category", categoryRepository.findAll());
        return "addDonation";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String donationAdd(@ModelAttribute @Validated Donation donation, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "addDonation";
        }
        donationRepository.save(donation);
        return "redirect:add";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        donationDao.delete(id);
        return "redirect:../add";
    }

    @GetMapping("/update/{id}")
    public String update(@PathVariable Long id, Model model) {
        Donation donation = donationDao.find(id);
        model.addAttribute("donationAdd", donation);
        return "editDonation";
    }

    @PostMapping("/update/{id}")
    public String update(@PathVariable Long id, @ModelAttribute @Validated Donation donation, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "editDonation";
        }
        donationDao.update(donation);
        return "redirect:../add";
    }
    @ModelAttribute("categoryList")
    public List<Category> findAllCategories() { return categoryRepository.findAll(); }
//
}
