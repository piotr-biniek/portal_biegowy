/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.java.biniek.uzertheme;

import java.io.Serializable;
import javax.persistence.*;
import pl.java.biniek.model.AbstractEntity;

@Entity
@Table(name = "UzerTheme")

public class UzerTheme extends AbstractEntity implements Serializable {//user

    @Id
    @Column(name = "id", updatable = false)
    @TableGenerator(name = "Theme", table = "ThemeGENERATOR", pkColumnName = "ENTITY_NAME", valueColumnName = "ID_RANGE",  initialValue = 40000, allocationSize = 6053)
    @GeneratedValue(strategy = GenerationType.TABLE,
            generator = "ThemeGen")
    private Long id;


    @Column(nullable = false, unique = true)
    private long uzerId;
    

    @Column(nullable = false)
    private String theme;

    public long getUzerId() {
        return uzerId;
    }

    public void setUzerId(long uzerId) {
        this.uzerId = uzerId;
    }

    public String getThemeType() {
        return theme;
    }

    public void setThemeType(String theme) {
        this.theme = theme;
    }

    
    
    
    @Override
    protected Long getId() {
       return id;
    }

    @Override
    protected String getBusinessKey() {
        return "ThemeID: "+id+" Uzer: "+uzerId+", theme: "+theme;
    }
    
       
    
    
}