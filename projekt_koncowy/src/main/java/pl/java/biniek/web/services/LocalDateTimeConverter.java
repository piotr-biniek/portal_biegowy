/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.java.biniek.web.services;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.FacesConverter;

 

/**
 * Faces converter for LocalDateTime
 * przerobiono projekt ze strony
 * https://www.javacodegeeks.com/2015/06/utilizing-the-java-8-date-time-api-with-jsf-and-java-ee-7.html
 * użycie przez converter="nazwaKonwertera"  
 * @author Juneau
 */

@FacesConverter(value="localDateTimeConverter")

public class LocalDateTimeConverter implements javax.faces.convert.Converter {

 

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
          return LocalDateTime.parse(value);

    }

 

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        LocalDateTime dateValue = (LocalDateTime) value;
        return dateValue.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));

    }

     

}
