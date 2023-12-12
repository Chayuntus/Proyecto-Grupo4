package com.ciclo2.proyectoia.cotrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.ciclo2.proyectoia.models.Cultura;
import com.ciclo2.proyectoia.models.Idioma;
import com.ciclo2.proyectoia.models.Region;
import com.ciclo2.proyectoia.services.CulturaService;
import com.ciclo2.proyectoia.services.IdiomaService;
import com.ciclo2.proyectoia.services.RegionService;
import java.util.List;

@Controller
@RequestMapping("/cultura")
public class CulturaController {
    @Autowired
    private CulturaService culturaSer;

    @Autowired
    private RegionService regionService;
    
    @Autowired
    private IdiomaService idiomaService;

    @GetMapping("/listar")
    public String listar(Model mod) {
        List<Cultura> culturas = culturaSer.listar();
        List<Region> regiones = regionService.listar();

        Cultura cultura = new Cultura();

        mod.addAttribute("cul", culturas);
        mod.addAttribute("cultura", cultura);
        mod.addAttribute("regiones", regiones);

        return "cultura/listar";
    }
    
     @PostMapping("/guardar")
        public String guardar(Cultura cultura) {
            culturaSer.guardar(cultura);
            return "redirect:/cultura/listar";
        }
     
     @GetMapping("/eliminar/{id}")
        public String eliminar(@PathVariable Integer id) {
            culturaSer.eliminar(id);
            return "redirect:/cultura/listar";
        }
     
     @GetMapping("/editar/{id}")
     public String editar(@PathVariable Integer id, Model model) {
         Cultura cultur = culturaSer.encontrar(id);
         List<Region> regiones = regionService.listar();
         List<Idioma> idiomas = idiomaService.listar();
         Idioma idioma = new Idioma();
         model.addAttribute("idioma", idioma);
         model.addAttribute("idiomas", idiomas);
         model.addAttribute("cultura", cultur);
         model.addAttribute("regiones", regiones); 
         return "cultura/editar-cultura";
     }
     @PostMapping("/editar/{id}")
        public String editarCultura(@PathVariable Integer id, Cultura cultura) {
            culturaSer.guardar(cultura);
            return "redirect:/cultura/listar";
        }
     @PostMapping("/editar-idioma/{id}")
     public String editarIdioma(@PathVariable Integer id, Idioma idioma) {
    	 Idioma idi = new Idioma();
    	 idi.setNombre(idioma.getNombre());
    	 idi.setProvincia_id(id);
    	 idiomaService.guardar(idi);
         return "redirect:/cultura/listar";
     }
     
}




