package br.edu.ifsul.cc.projetolpooe2_barbarawehrmann.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.ManyToMany;
import java.util.List;

@Entity
@Table(name = "tb_midias")
public class Midias implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(nullable = false, length = 155, name = "descrição")
    private String descricao;
    
    @Column(nullable = false, name = "url") // sem limite de caracteres, pois a url pode ser longa
    private String url;

    @ManyToMany(mappedBy = "midias")
    private List<Noticias> noticias;

    public Midias() {}

    public Integer getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getUrl() {
        return url;
    }

    public List<Noticias> getNoticias() {
        return noticias;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setNoticias(List<Noticias> noticias) {
        this.noticias = noticias;
    }
    
    @Override
    public String toString() {
        return descricao;
    }
}
