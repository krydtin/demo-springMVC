package com.demo.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.demo.springmvc.controller.Subscriber.Frequency;
import com.demo.springmvc.controller.Subscriber.Gender;

@Controller
public class SubscriberFormController {

	@ModelAttribute("frequencies")
	public Frequency[] frequencies() {
		return Frequency.values();
	}

	@ModelAttribute("genders")
	public Gender[] genders() {
		return Gender.values();
	}

	@RequestMapping(value = "form", method = RequestMethod.GET)
	public String loadFormPage(Model m) {
		Subscriber subscriber = new Subscriber();
		subscriber.setReceiveNewsletter(true);
		subscriber.setNewsletterFrequency(Frequency.HOURLY);
		m.addAttribute("subscriber", subscriber);
		return "subscriberFormPage";
	}

	@RequestMapping(value = "form", method = RequestMethod.POST)
	public String submitForm(@ModelAttribute Subscriber subscriber, Model m) {
		m.addAttribute("message",
				"Successfully saved person: " + subscriber.toString());
		return "subscriberFormPage";
	}

}
