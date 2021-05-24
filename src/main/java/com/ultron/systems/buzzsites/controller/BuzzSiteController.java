package com.ultron.systems.buzzsites.controller;

import com.ultron.systems.buzzsites.entity.BuzzSite;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "buzz-sites")
public class BuzzSiteController {

    private List<BuzzSite> sites;

    public BuzzSiteController() {
        this.sites = new ArrayList<>();
        this.sites.add(new BuzzSite(1, "https://amazon.com"));
        this.sites.add(new BuzzSite(2, "https://twitter.com"));
        this.sites.add(new BuzzSite(3, "https://facebook.com"));
    }

    /**
     * Liste des buzz sites
     * @return List
     */
    @GetMapping
    public List<BuzzSite> index() {
        return this.sites;
    }

    /**
     * Récupérer les détails d'un site
     * @param ident
     * @return
     */
    @GetMapping(value = "{id}")
    public BuzzSite details(@PathVariable(value = "id") Integer ident) {
        return this.sites.stream()
            .filter(buzzSite -> buzzSite.getId() == ident).findFirst().get();
    }


    /**
     * Ajouter un BuzzSite à la liste des sites
     * @param site
     * @return
     */
    @PostMapping
    public BuzzSite ajouter(@RequestBody BuzzSite site) {
        site.setId(sites.size() + 1);
        sites.add(site);
        return site;
    }


    /**
     * Supprimer un buzz site de la liste
     * @param id
     * @return
     */
    @DeleteMapping(value = "{id}")
    public List<BuzzSite> supprimer(@PathVariable Integer id) {
        return this.sites.stream()
            .filter(buzzSite -> buzzSite.getId() != id)
            .collect(Collectors.toList());
    }

    /**
     * Modifier un site
     * @param id
     * @return
     */
    @PutMapping(value = "{id}")
    public List<BuzzSite> modifier(@PathVariable Integer id, @RequestBody BuzzSite site) {
        // On supprime l'ancien de la liste
        List<BuzzSite> lesAutres = sites.stream()
                .filter(buzzSite -> buzzSite.getId() != id)
                .collect(Collectors.toList());
        // On ajoute la modification à la fin
        site.setId(id);
        lesAutres.add(site);
        this.sites = lesAutres;
        return sites;
    }
}
