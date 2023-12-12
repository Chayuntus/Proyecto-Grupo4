package com.ciclo2.proyectoia.models;

import java.util.List;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="cultura")
public class Cultura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String provincia;
    private String gastronomia;
    @OneToOne
    @JoinColumn(name="region_id")

    private Region region;

    @OneToMany(fetch=FetchType.LAZY)
    @JoinColumn(name="provincia_id")
    private List<Idioma> idioma;
    

    public Region getRegion() {
        return region;
    }
    public void setRegion(Region region) {
        this.region = region;
    }
    public Cultura() {

    }

    public List<Idioma> getIdioma() {
        return idioma;
    }
    public void setIdioma(List<Idioma> idioma) {
        this.idioma = idioma;
    }

    public Cultura(String provincia, String gastronomia, Region region, List<Idioma> idioma) {
        super();
        this.provincia = provincia;
        this.gastronomia = gastronomia;
        this.region = region;
        this.idioma = idioma;
    }
    
    public Cultura(String provincia, String gastronomia, Region region) {
		super();
		this.provincia = provincia;
		this.gastronomia = gastronomia;
		this.region = region;
	}
	public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getProvincia() {
        return provincia;
    }
    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }
    public String getGastronomia() {
        return gastronomia;
    }
    public void setGastronomia(String gastronomia) {
        this.gastronomia = gastronomia;
    }

}