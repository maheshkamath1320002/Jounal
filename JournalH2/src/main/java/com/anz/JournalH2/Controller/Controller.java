package com.anz.JournalH2.Controller;

import com.anz.JournalH2.Entity.Journal;
import com.anz.JournalH2.Repository.Journalrepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/journal")
public class Controller {
    @Autowired
    Journalrepo repo;
    @PostMapping
    public void SaveEntry(@RequestBody Journal journal)
    {
        repo.save(journal);
    }
    @GetMapping
    public List<Journal> getall()
    {
        return repo.findAll();
    }
    @GetMapping("id/{myid}")
    public Optional<Journal> getById(@PathVariable int myid)
    {
        return repo.findById(myid);
    }
    @PutMapping("id/{myid}")
    public Journal putById(@RequestBody Journal j ,@PathVariable int myid)
    {
        Journal old = repo.findById(myid).orElse(null);
        if (old!=null){
            old.setTitle(j.getTitle()!= null && !j.getTitle().equals("")?j.getTitle():old.getTitle());
            old.setContent(j.getContent()!= null && !j.getContent().equals("")?j.getContent():old.getContent());
        }
        repo.save(old);
        return old;
    }
    @DeleteMapping("id/{myid}")
    public void  DeleteById(@PathVariable int myid)
    {
        repo.deleteById(myid);
    }
}
