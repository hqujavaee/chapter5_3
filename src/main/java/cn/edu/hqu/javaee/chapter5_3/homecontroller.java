package cn.edu.hqu.javaee.chapter5_3;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class homecontroller {
	public String index() {
		return "hello";
	}

}
