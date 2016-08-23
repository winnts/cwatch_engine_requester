package WebApp;

import Postgres.Reports.WebReport;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by Andrey.Dyachenko on 20.08.16.
 */
@Controller
public class MonitorController {
    @RequestMapping("/greeting")
    public String greeting(@RequestParam(value="name", required=false, defaultValue="World") String name, Model model) {
        WebReport host = new WebReport();
        model.addAttribute("name", name);
        model.addAttribute("host", host.reportToHtml("MyHost"));
        return "greeting";
    }
}
