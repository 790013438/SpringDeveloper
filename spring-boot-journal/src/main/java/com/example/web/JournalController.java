package com.example.web;

import com.example.domain.JournalEntry;
import com.example.repository.JournalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class JournalController {

    private static List<JournalEntry> journalEntryList = new ArrayList<>();

    static {
        try {
            journalEntryList.add(new JournalEntry("Get to know Spring Boot", "Today I will learn Srping Boot", "01/01/2016"));
            journalEntryList.add(new JournalEntry("Simple Spring Boot Project", "I will do my first Spring Boot Project", "01/02/2016"));
            journalEntryList.add(new JournalEntry("Simple Boot Reading", "Read more about Spring Boot", "02/01/2016"));
            journalEntryList.add(new JournalEntry("Spring Boot in the Cloud", "Spring Boot using Cloud Foundry", "03/01/2016"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Autowired
    public JournalController(JournalRepository repo) {
        this.repo = repo;
    }

    @RequestMapping("/journal/all")
    public List<JournalEntry> getAll() {
        return journalEntryList;
    }

    @RequestMapping("/journal/findBy/title/{title}")
    public List<JournalEntry> findByTitleContains(@PathVariable String title) throws ParseException {
        return journalEntryList
                .stream()
                .filter(entry -> entry.getTitle().toLowerCase().contains(title.toLowerCase()))
                .collect(Collectors.toList());
    }

    @RequestMapping(value = "/journal", method = RequestMethod.POST)
    public JournalEntry add(@RequestBody JournalEntry entry) {
        journalEntryList.add(entry);
        return entry;
    }

    private final JournalRepository repo;

    @RequestMapping(value = "/journal", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    @ResponseBody
    public List<JournalEntry> getJournal() {
        return repo.findAll();
    }

    @RequestMapping("/")
    public String index(Model model) {
        model.addAttribute("journal", repo.findAll());
        return "index";
    }
}
