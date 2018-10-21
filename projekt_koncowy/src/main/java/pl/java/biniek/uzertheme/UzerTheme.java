/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.java.biniek.uzertheme;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import pl.java.biniek.model.AbstractEntity;

@Entity
@Table(name = "UzerTheme")
//@NamedQueries({
//        @NamedQuery(name = "Uzer.findByEmail", query = "SELECT d FROM Uzer d WHERE d.email = :email"),
//     @NamedQuery(name = "Uzer.doesEmailExists", query = "SELECT d FROM Uzer d WHERE d.email = :email"),
//})
public class UzerTheme extends AbstractEntity implements Serializable {//user

    @Id
    @Column(name = "id", updatable = false)
    @TableGenerator(name = "Theme", table = "GENERATOR", pkColumnName = "ENTITY_NAME", valueColumnName = "ID_RANGE", pkColumnValue = "User", initialValue = 400, allocationSize = 6053)
    @GeneratedValue(strategy = GenerationType.TABLE,
            generator = "UserGen")
    private Long id;

    @NotNull
    @Column(nullable = false, unique = true)
    private long uzerId;
    
    @NotNull
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