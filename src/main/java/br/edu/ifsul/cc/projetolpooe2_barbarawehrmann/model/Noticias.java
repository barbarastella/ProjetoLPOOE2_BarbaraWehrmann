package br.edu.ifsul.cc.projetolpooe2_barbarawehrmann.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
@Table(name = "tb_noticias")
public class Noticias implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(nullable = false, length = 155, name = "titulo")
    private String titulo;

    @Column(nullable = false, length = 255, name = "conteudo") // sem limite de caracteres, pois o conteúdo da notícia pode ser longo
    private String conteudo;

    @ManyToOne
    @JoinColumn(name = "tipo_noticia")
    private TipoNoticia tipo_noticia;

    /*@ManyToMany
    @JoinTable(name = "tb_noticiaMidia",
            joinColumns = @JoinColumn(name = "noticia_id"),
            inverseJoinColumns = @JoinColumn(name = "midia_id"))
    private List<Midias> midias = new ArrayList<>();*/
    
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "tb_noticiaMidia",
            joinColumns = @JoinColumn(name = "noticia_id"),
            inverseJoinColumns = @JoinColumn(name = "midia_id"))
    private List<Midias> midias = new ArrayList<>();

    public Noticias() {
    }

    public Integer getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getConteudo() {
        return conteudo;
    }

    public TipoNoticia getTipo_noticia() {
        return tipo_noticia;
    }

    public List<Midias> getMidias() {
        return midias;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public void setTipo_noticia(TipoNoticia tipo_noticia) {
        this.tipo_noticia = tipo_noticia;
    }

    public void setMidias(List<Midias> midias) {
        this.midias = midias;
    }

    @Override
    public String toString() {
        return titulo;
    }
}
