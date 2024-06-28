package ba.smoki.taifun.home;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Arrays;
//http://localhost:8080/home

/**
 * <>1. DispatcherServlet</>
 * <>2. HandlerMapper  /home</>
 * <>3. HomeController: model(poruke)</>
 * <>4. ViewResolver : "home"  templates -> home</>
 * <>5. View "home.html" se vraća nazad clientu koji je gađao naš kontroler</>
 */
@Controller
public class HomeController {

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String home(Model model){
        model.addAttribute("poruke", Arrays.asList("Spring je sjajan", "Spring MVC odličan", "Spring REST takođe"));
        return "home";
    }
}
