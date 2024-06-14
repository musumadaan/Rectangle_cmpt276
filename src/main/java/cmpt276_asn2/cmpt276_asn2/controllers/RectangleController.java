package cmpt276_asn2.cmpt276_asn2.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import cmpt276_asn2.cmpt276_asn2.models.Rectangle;
import cmpt276_asn2.cmpt276_asn2.service.Rectangle_service;

@Controller
public class RectangleController{

    @Autowired
    private Rectangle_service rectangleservice;

     @GetMapping("/")
     public String viewHomePage(Model model){
      model.addAttribute("listRectangles", rectangleservice.getAllRectangles());
      return "rectangle_page";
      }
     
     @GetMapping("/showRect")
     public String showrect(Model model){
      Rectangle rectangle = new Rectangle();
      rectangle.setName("Alex");
      rectangle.setColor("red");
      rectangle.setBorder("red");
      rectangle.setHeight(20);
      rectangle.setWidth(20);
      Rectangle rectangle_2 = new Rectangle();
      rectangle_2.setName("Bran");
      rectangle_2.setColor("red");
      rectangle_2.setBorder("red");
      rectangle_2.setHeight(20);
      rectangle_2.setWidth(20);
      rectangleservice.saveRectangle(rectangle);
      rectangleservice.saveRectangle(rectangle_2);
      model.addAttribute("listRectangles", rectangleservice.getAllRectangles());
      return "rectangle_page";
     }
     @GetMapping("/showNewRectangleForm")
     public String showNewRectangleForm(Model model){
      Rectangle rectangle = new Rectangle();
      model.addAttribute("rectangle", rectangle);
      return "new_rectangle";

     }
   @PostMapping("/saveRectangle")
     public String saveRectangle(@ModelAttribute("rectangle") Rectangle rectangle) {
            rectangleservice.saveRectangle(rectangle);
            return "redirect:/";
     }
   
   @GetMapping("/draw/{id}")
   public String drawRectangle(@PathVariable (value = "id") Integer id, Model model){
      Rectangle rectangle = rectangleservice.getRectangleById(id);
      model.addAttribute("rectangle", rectangle);
      return "draw_rectangle_page";
   }
   @GetMapping("/showUpdateRectangleForm/{id}")
   public String showUpdateRectangleForm(@PathVariable(value = "id") Integer id, Model model){
      Rectangle rectangle = rectangleservice.getRectangleById(id);
      model.addAttribute("rectangle", rectangle);
      return "update_rectangle";
   }
   @GetMapping("/deleteRectangle/{id}")
   public String deleteRectangle(@PathVariable(value = "id") Integer id){
      this.rectangleservice.deleteRectangleById(id);
      return "redirect:/";
   }
}
